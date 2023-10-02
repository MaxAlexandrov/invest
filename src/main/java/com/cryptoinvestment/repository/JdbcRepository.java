package com.cryptoinvestment.repository;

import com.cryptoinvestment.models.dto.CoinRangeResponse;
import com.cryptoinvestment.models.dto.CoinResponse;

import java.sql.Date;
import java.util.Collection;

/**
 * Jdbc interface.
 *
 * @author maksim aleksandrov
 */
public interface JdbcRepository {

    /**
     * invoke function calculate minimum price
     *
     * @param crypto name of crypto
     * @param dateBegin date of begin period
     * @param dateEnd date of end period
     * @return list of coins
     */
    Collection<CoinResponse> getMinPrice(String crypto, Date dateBegin, Date dateEnd);

    /**
     * invoke function calculate maximum price
     *
     * @param crypto name of crypto
     * @param dateBegin date of begin period
     * @param dateEnd date of end period
     * @return list of coins
     */
    Collection<CoinResponse> getMaxPrice(String crypto, Date dateBegin, Date dateEnd);

    /**
     * invoke function calculate oldest price
     *
     * @param crypto name of crypto
     * @param dateBegin date of begin period
     * @param dateEnd date of end period
     * @return list of coins
     */
    Collection<CoinResponse> getOldestPrice(String crypto, Date dateBegin, Date dateEnd);

    /**
     * invoke function calculate newest price
     *
     * @param crypto name of crypto
     * @param dateBegin date of begin period
     * @param dateEnd date of end period
     * @return list of coins
     */
    Collection<CoinResponse> getNewestPrice(String crypto, Date dateBegin, Date dateEnd);

    /**
     * invoke function calculate range of coins by month by period
     *
     * @param crypto name of crypto
     * @param dateBegin date of begin period
     * @param dateEnd date of end period
     * @return list of coins
     */
    Collection<CoinRangeResponse> getRangePrice(String crypto, Date dateBegin, Date dateEnd);

}
