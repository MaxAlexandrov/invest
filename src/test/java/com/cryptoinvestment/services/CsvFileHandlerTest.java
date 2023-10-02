package com.cryptoinvestment.services;

import com.cryptoinvestment.repository.CryptoRepository;
import com.cryptoinvestment.services.impl.CsvFileHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.File;

import static org.mockito.Mockito.mock;

/**
 * Test handler.
 */
class CsvFileHandlerTest {

  @Mock
  CryptoRepository repository = mock(CryptoRepository.class);
  CsvFileHandler fileReader = new CsvFileHandler(repository);

  @Test
  void test_process_File_success_return_OK() {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("BTC_values.csv").getFile());
    fileReader.processFile(file);
  }
}