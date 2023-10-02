package com.cryptoinvestment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinRangeResponse {
    private String year;
    private String month;
    private String crypto;
    private float rangePrice;
    private float maxPrice;
    private float minPrice;
}
