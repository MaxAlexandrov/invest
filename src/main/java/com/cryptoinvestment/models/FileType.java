package com.cryptoinvestment.models;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * File types enumeration.
 *
 * @author maksim aleksandrov
 */
public enum FileType {

  /**
   * CSV format.
   */
  CSV(".csv");


  @Getter
  private final String name;

  FileType(String name) {
    this.name = name;
  }

  /**
   * get type of file by name
   * @param name name
   * @return Optional<FileType>
   */
  public Optional<FileType> getByName(final String name) {
    return Arrays.stream(FileType.values())
        .filter(v -> v.getName().equalsIgnoreCase(name))
        .findFirst();
  }
}
