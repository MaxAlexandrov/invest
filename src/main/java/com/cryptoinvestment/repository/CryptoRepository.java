package com.cryptoinvestment.repository;

import com.cryptoinvestment.models.Coin;
import com.cryptoinvestment.models.CoinKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Crypto JPA interface.
 *
 * @author maksim aleksandrov
 */
@Repository
public interface CryptoRepository extends JpaRepository<Coin, CoinKey> {
}
