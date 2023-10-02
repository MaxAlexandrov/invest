package com.cryptoinvestment.services;

import com.cryptoinvestment.models.dto.CryptoPayload;

import java.util.Collection;

/**
 * Data processing service.
 *
 * @author maksim aleksandrov
 */
public interface DataProcessingService {

  /**
   * getting minimum by period
   * @param cryptoPayload payload
   * @return list of coins
   */
  Collection<?> getMinPrice(CryptoPayload cryptoPayload);

  /**
   * getting maximum by period
   * @param cryptoPayload payload
   * @return list of coins
   */
  Collection<?> getMaxPrice(CryptoPayload cryptoPayload);

  /**
   * getting oldest value by period
   * @param cryptoPayload payload
   * @return list of coins
   */
  Collection<?> getOldestPrice(CryptoPayload cryptoPayload);
  /**
   * getting newest value by period
   * @param cryptoPayload payload
   * @return list of coins
   */
  Collection<?> getNewestPrice(CryptoPayload cryptoPayload);

  /**
   * getting range (max-min/min) of coins monthly by period
   * @param cryptoPayload payload
   * @return list of coins
   */
  Collection<?> getRangePrice(CryptoPayload cryptoPayload);

}
