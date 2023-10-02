package com.cryptoinvestment.controllers;

import com.cryptoinvestment.models.dto.CryptoPayload;
import com.cryptoinvestment.services.DataProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Rest Controller for Recommendation Invest Crypto.
 * api:  'api/v1/crypto-invest/recommendation'
 *
 * @author maksim aleksandrov
 */
@Slf4j
@RestController
@RequestMapping(value = "api/v1/crypto-invest/recommendation", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Recommendation Crypto", description = "Recommendations resource for investment")
@RequiredArgsConstructor
public class CryptoInvestController {

    private final DataProcessingService dataProcessingService;

    @Operation(summary = "Fetcher recommendations",
            description = "Method return maximum price of recommendations of crypto from the source by period")
    @ResponseBody
    @PostMapping(value = "/getMaximumPriceByPeriod")
    public ResponseEntity<?> getMaximumPriceByPeriod(
            @RequestBody CryptoPayload cryptoPayload) {
        return ResponseEntity.ok()
                .body(dataProcessingService.getMaxPrice(cryptoPayload));
    }

    @Operation(summary = "Fetcher recommendations maximum price",
            description = "Method return maximum price of recommendations of crypto from the source by period")
    @ResponseBody
    @PostMapping(value = "/getMinimumPriceByPeriod")
    public ResponseEntity<?> getMinimumPriceByPeriod(
            @RequestBody CryptoPayload cryptoPayload) {
        return ResponseEntity.ok()
                .body(dataProcessingService.getMinPrice(cryptoPayload));
    }

    @Operation(summary = "Fetcher recommendations newest price",
            description = "Method return newest price of recommendations of crypto from the source by period")
    @ResponseBody
    @PostMapping(value = "/getNewestPriceByPeriod")
    public ResponseEntity<?> getNewestPriceByPeriod(
            @RequestBody CryptoPayload cryptoPayload) {
        return ResponseEntity.ok()
                .body(dataProcessingService.getNewestPrice(cryptoPayload));
    }

    @Operation(summary = "Fetcher recommendations oldest price",
            description = "Method return oldest price of recommendations of crypto from the source by period")
    @ResponseBody
    @PostMapping(value = "/getOldestPriceByPeriod")
    public ResponseEntity<?> getOldestPriceByPeriod(
            @RequestBody CryptoPayload cryptoPayload) {
        return ResponseEntity.ok()
                .body(dataProcessingService.getOldestPrice(cryptoPayload));
    }

    @Operation(summary = "Fetcher recommendations range of price by months",
            description = "Method return range of price by months from the source by period")
    @ResponseBody
    @PostMapping(value = "/getRangePriceByMonths")
    public ResponseEntity<?> getRangePriceByMonths(
            @RequestBody CryptoPayload cryptoPayload) {
        return ResponseEntity.ok()
                .body(dataProcessingService.getRangePrice(cryptoPayload));
    }
}

