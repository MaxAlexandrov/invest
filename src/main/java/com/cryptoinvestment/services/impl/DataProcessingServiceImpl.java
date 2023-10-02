package com.cryptoinvestment.services.impl;

import com.cryptoinvestment.models.dto.CryptoPayload;
import com.cryptoinvestment.repository.JdbcRepository;
import com.cryptoinvestment.services.DataProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Collection;

/**
 * Implementation of Data processing Service {@link DataProcessingService}.
 *
 * @author maksim aleksandrov
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataProcessingServiceImpl implements DataProcessingService {

  private final JdbcRepository jdbcRepository;

  @Override
  public Collection<?> getMinPrice(CryptoPayload cryptoPayload) {
    log.info("Minimum price calculation");
    return jdbcRepository.getMinPrice(cryptoPayload.getCrypto(),
            Date.valueOf(cryptoPayload.getDateBegin()),
            Date.valueOf(cryptoPayload.getDateEnd()));
  }

  @Override
  public Collection<?> getMaxPrice(CryptoPayload cryptoPayload) {
    log.info("Maximum price calculation");
    return jdbcRepository.getMaxPrice(cryptoPayload.getCrypto(),
            Date.valueOf(cryptoPayload.getDateBegin()),
            Date.valueOf(cryptoPayload.getDateEnd()));
  }

  @Override
  public Collection<?> getOldestPrice(CryptoPayload cryptoPayload) {
    log.info("Oldest price calculation");
    return jdbcRepository.getOldestPrice(cryptoPayload.getCrypto(),
            Date.valueOf(cryptoPayload.getDateBegin()),
            Date.valueOf(cryptoPayload.getDateEnd()));
  }

  @Override
  public Collection<?> getNewestPrice(CryptoPayload cryptoPayload) {
    log.info("Newest price calculation");
    return jdbcRepository.getNewestPrice(cryptoPayload.getCrypto(),
            Date.valueOf(cryptoPayload.getDateBegin()),
            Date.valueOf(cryptoPayload.getDateEnd()));
  }

  @Override
  public Collection<?> getRangePrice(CryptoPayload cryptoPayload) {
    log.info("Range price calculation by months and period");
    return jdbcRepository.getRangePrice(cryptoPayload.getCrypto(),
            Date.valueOf(cryptoPayload.getDateBegin()),
            Date.valueOf(cryptoPayload.getDateEnd()));
  }
}
