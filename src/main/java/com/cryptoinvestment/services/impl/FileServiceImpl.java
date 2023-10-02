package com.cryptoinvestment.services.impl;

import com.cryptoinvestment.exception.FileNotFoundException;
import com.cryptoinvestment.models.FileMetadata;
import com.cryptoinvestment.repository.FileMetaDataRepository;
import com.cryptoinvestment.services.FileHandler;
import com.cryptoinvestment.services.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements CommandLineRunner, FileService {

  public static final String MD_5_ALGORITHM = "MD5";
  private final List<FileHandler> fileHandlers;
  private final FileMetaDataRepository metadataRepository;
  @Value("${file.dir}")
  private String pathToDir;
  @Value("${file.execution-timeout}")
  private Long executionTimeout;
  private final ExecutorService executors = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors());

  /**
   * Collecting all files by path {pathToDir} and saving their data and metadata. This method
   * processes each file in parallel by submitting tasks to an executor. Thread per core model is
   * using.
   *
   * @throws InterruptedException If the execution is interrupted while waiting for tasks to
   *                              complete.
   */
  @SneakyThrows
  public void processFileData() {
    List<File> files = collectFiles(pathToDir);
    for (File file : files) {
      executors.submit(() -> processFile(file));
    }
    executors.shutdown();
    executors.awaitTermination(executionTimeout, TimeUnit.NANOSECONDS);
    log.info("Finished processing all files");
  }

  /**
   * processing file method
   * @param file file
   */
  private void processFile(final File file) {
    FileMetadata fileMetadata = getFileMetadata(file);

    if (metadataRepository.isProcessed(fileMetadata.getHash())) {
      log.info("File {} already processed", file.getName());
      return;
    }

    Optional<FileHandler> fileHandler = getFileHandler(fileHandlers, file);

    if (fileHandler.isPresent()) {
      fileHandler.get().processFile(file);
      fileMetadata.setProcessedTimestamp(new Date(Instant.now().toEpochMilli()));
      metadataRepository.save(fileMetadata);
      log.info("File {} has been processed successfully", file.getName());
    } else {
      log.error("There is no appropriate file handler for file: {}", file.getName());
    }
  }

  /**
   * extract file metadata
   * @param file file
   * @return FileMetadata
   */
  private FileMetadata getFileMetadata(final File file) {
    if (file.exists()) {
      try {
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        Date creationTime = new Date(attr.creationTime().toMillis());
        long size = attr.size();
        Date lastModifiedTime = new Date(attr.lastModifiedTime().toMillis());
        String md5 = computeMD5Hash(String.format("%s%s%s", creationTime, size, lastModifiedTime));

        FileMetadata metadata = new FileMetadata();
        metadata.setFileName(file.getName());
        metadata.setHash(md5);
        metadata.setSize(size);
        metadata.setLastModified(lastModifiedTime);
        metadata.setCreationDate(creationTime);

        return metadata;
      } catch (IOException e) {
        throw new RuntimeException("Can't handle file: " + file.getName(), e);
      }

    } else {
      throw new FileNotFoundException("File doesn't exist: " + file.getName());
    }
  }

  /**
   * compute MD5 hash
   * @param data data
   * @return hash
   */
  private static String computeMD5Hash(final String data) {
    try {
      MessageDigest md = MessageDigest.getInstance(MD_5_ALGORITHM);
      byte[] hashBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

      // Convert the byte array to a hexadecimal string
      try (Formatter formatter = new Formatter()) {
        for (byte b : hashBytes) {
          formatter.format("%02x", b);
        }
        return formatter.toString();
      }
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * get file handler
   * @param fileHandlers fileHandlers
   * @param file file
   * @return Optional<FileHandler>
   */
  private Optional<FileHandler> getFileHandler(List<FileHandler> fileHandlers, File file) {
    String extension = file.getName().substring(file.getName().lastIndexOf("."));
    for (FileHandler fileHandler : fileHandlers) {
      if (fileHandler.getFileType().getName().equalsIgnoreCase(extension)) {
        return Optional.of(fileHandler);
      }
    }
    return Optional.empty();
  }

  /**
   * collect files from directory
   * @param path path
   * @return list of files
   */
  private List<File> collectFiles(final String path) {
    List<File> allFiles = new ArrayList<>();
    File dir = new File(path);
    if (dir.exists()) {
      File[] files = dir.listFiles();
      if (files != null) {
        allFiles.addAll(Arrays.asList(files));
      }
    }
    return allFiles;
  }

  /**
   * start processinf with the run Application
   * @param args args
   */
  @Override
  public void run(String... args) {
    processFileData();
  }
}
