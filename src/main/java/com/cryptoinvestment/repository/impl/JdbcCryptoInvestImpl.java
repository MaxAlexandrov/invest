package com.cryptoinvestment.repository.impl;

import com.cryptoinvestment.models.dto.CoinRangeResponse;
import com.cryptoinvestment.models.dto.CoinResponse;
import com.cryptoinvestment.repository.JdbcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;

/**
 * Implementation of JdbcRepository {@link JdbcRepository}.
 *
 * @author maksim aleksandrov
 */
@Repository
@Slf4j
@RequiredArgsConstructor
public class JdbcCryptoInvestImpl implements JdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Collection<CoinResponse> getMinPrice(String crypto, Date dateBegin, Date dateEnd) {
        if (isNull(crypto)) {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_min_crypto('%s','%s')", dateBegin, dateEnd), new CoinsRowMapper());
        } else {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_min_crypto('%s','%s','%s')", crypto, dateBegin, dateEnd), new CoinsRowMapper());
        }
    }

    @Override
    public Collection<CoinResponse> getMaxPrice(String crypto, Date dateBegin, Date dateEnd) {
        if (isNull(crypto)) {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_max_crypto('%s','%s')", dateBegin, dateEnd), new CoinsRowMapper());
        } else {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_max_crypto('%s','%s','%s')", crypto, dateBegin, dateEnd), new CoinsRowMapper());
        }
    }

    @Override
    public Collection<CoinResponse> getOldestPrice(String crypto, Date dateBegin, Date dateEnd) {
        if (isNull(crypto)) {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_oldest_crypto('%s','%s')", dateBegin, dateEnd), new CoinsRowMapper());
        } else {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_oldest_crypto('%s','%s','%s')", crypto, dateBegin, dateEnd), new CoinsRowMapper());
        }
    }

    @Override
    public Collection<CoinResponse> getNewestPrice(String crypto, Date dateBegin, Date dateEnd) {
        if (isNull(crypto)) {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_newest_crypto('%s','%s')", dateBegin, dateEnd), new CoinsRowMapper());
        } else {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_newest_crypto('%s','%s','%s')", crypto, dateBegin, dateEnd), new CoinsRowMapper());
        }
    }

    @Override
    public Collection<CoinRangeResponse> getRangePrice(String crypto, Date dateBegin, Date dateEnd) {
        if (isNull(crypto)) {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_range_crypto('%s','%s')", dateBegin, dateEnd),
                    new CoinsRangeRowMapper());
        } else {
            return jdbcTemplate.query(String.format("SELECT * FROM calc_range_crypto('%s','%s','%s')", crypto, dateBegin, dateEnd),
                    new CoinsRangeRowMapper());
        }
    }

    /**
     * check is crypto null
     * @param crypto crypto
     * @return boolean
     */
    private boolean isNull(final String crypto) {
        return crypto == null || crypto.isEmpty();
    }
}
