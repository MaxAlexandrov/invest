package com.cryptoinvestment.services;

import com.cryptoinvestment.models.dto.CryptoPayload;
import com.cryptoinvestment.repository.JdbcRepository;
import com.cryptoinvestment.services.impl.DataProcessingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.Collections;

import static org.mockito.Mockito.mock;

/**
 * Happy case scenario test.
 *
 * @author maksim aleksandrov
 */
class DataProcessingServiceHappyCaseTest {

    @Mock
    JdbcRepository repository = mock(JdbcRepository.class);
    private DataProcessingService it = new DataProcessingServiceImpl(repository);

    @Test
    void check_min_price_then_return_OK() {
        Mockito.when(repository.getMinPrice("BCT", Date.valueOf("2020-01-01"),Date.valueOf("2023-01-01")))
                .thenReturn(Collections.emptyList());
        it.getMinPrice(CryptoPayload.builder()
                .crypto("BCT")
                .dateBegin("2020-01-01")
                .dateEnd("2023-01-01")
                .build());
    }

    @Test
    void  check_max_price_then_return_OK() {
        Mockito.when(repository.getMaxPrice("BCT", Date.valueOf("2020-01-01"),Date.valueOf("2023-01-01")))
                .thenReturn(Collections.emptyList());
        it.getMaxPrice(CryptoPayload.builder()
                .crypto("BCT")
                .dateBegin("2020-01-01")
                .dateEnd("2023-01-01")
                .build());
    }

    @Test
    void check_oldest_price_then_return_OK() {
        Mockito.when(repository.getOldestPrice("BCT", Date.valueOf("2020-01-01"),Date.valueOf("2023-01-01")))
                .thenReturn(Collections.emptyList());
        it.getOldestPrice(CryptoPayload.builder()
                .crypto("BCT")
                .dateBegin("2020-01-01")
                .dateEnd("2023-01-01")
                .build());
    }

    @Test
    void check_newest_price_then_return_OK() {
        Mockito.when(repository.getNewestPrice("BCT", Date.valueOf("2020-01-01"),Date.valueOf("2023-01-01")))
                .thenReturn(Collections.emptyList());
        it.getNewestPrice(CryptoPayload.builder()
                .crypto("BCT")
                .dateBegin("2020-01-01")
                .dateEnd("2023-01-01")
                .build());
    }

    @Test
    void check_range_price_then_return_OK() {
        Mockito.when(repository.getRangePrice("BCT", Date.valueOf("2020-01-01"),Date.valueOf("2023-01-01")))
                .thenReturn(Collections.emptyList());
        it.getRangePrice(CryptoPayload.builder()
                .crypto("BCT")
                .dateBegin("2020-01-01")
                .dateEnd("2023-01-01")
                .build());
    }
}