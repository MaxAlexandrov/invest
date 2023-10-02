package com.cryptoinvestment.services.impl;

import com.cryptoinvestment.models.Coin;
import com.cryptoinvestment.models.CoinKey;
import com.cryptoinvestment.models.FileType;
import com.cryptoinvestment.repository.CryptoRepository;
import com.cryptoinvestment.services.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV File Handler implementation of {@link FileHandler}.
 *
 * @author maksim aleksandrov
 */
@RequiredArgsConstructor
@Service
public class CsvFileHandler implements FileHandler {

  private final CryptoRepository cryptoRepository;
  private static final FileType FILE_TYPE = FileType.CSV;
  private static final int BATCH_SIZE = 5000;

  @Override
  public void processFile(File file) {
    boolean skipHeaders = false;
    List<Coin> coins = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (!skipHeaders) {
          skipHeaders = true;
          continue;
        }
        coins.add(parseCoinFromString(line));
        if (coins.size() >= BATCH_SIZE) {
          cryptoRepository.saveAll(coins);
          coins.clear();
        }

      }
      cryptoRepository.saveAll(coins);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public FileType getFileType() {
    return FILE_TYPE;
  }

  private Coin parseCoinFromString(String line) {
    String[] columns = line.split(",");
    Long date = Long.parseLong(columns[0]);
    String name = columns[1];
    float price = Float.parseFloat(columns[2]);
    CoinKey key = new CoinKey(new Date(date), name);
    return new Coin(key, price);
  }
}
