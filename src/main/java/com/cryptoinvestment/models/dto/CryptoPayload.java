package com.cryptoinvestment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO request.
 *
 * @author maksim aleksandrov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CryptoPayload {
    String dateBegin;
    String dateEnd;
    String crypto;
}
