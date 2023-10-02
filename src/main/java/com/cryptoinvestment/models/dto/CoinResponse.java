package com.cryptoinvestment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinResponse {
    private String date;
    private String crypto;
    private float price;
}
