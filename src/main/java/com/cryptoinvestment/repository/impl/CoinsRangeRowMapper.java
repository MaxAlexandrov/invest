package com.cryptoinvestment.repository.impl;

import com.cryptoinvestment.models.dto.CoinRangeResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsRangeRowMapper implements RowMapper<CoinRangeResponse> {
    @Override
    public CoinRangeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CoinRangeResponse.builder()
                .year(rs.getString("year"))
                .crypto(rs.getString("crypto"))
                .month(rs.getString("month"))
                .rangePrice(rs.getFloat("range_price"))
                .maxPrice(rs.getFloat("max_price"))
                .minPrice(rs.getFloat("min_price"))
                .build();
    }
}
