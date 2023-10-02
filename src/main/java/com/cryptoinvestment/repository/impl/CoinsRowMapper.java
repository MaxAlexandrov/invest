package com.cryptoinvestment.repository.impl;

import com.cryptoinvestment.models.dto.CoinResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsRowMapper  implements RowMapper<CoinResponse> {
    @Override
    public CoinResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CoinResponse.builder()
                .date(rs.getString("date"))
                .crypto(rs.getString("crypto"))
                .price(rs.getFloat("price"))
                .build();
    }
}
