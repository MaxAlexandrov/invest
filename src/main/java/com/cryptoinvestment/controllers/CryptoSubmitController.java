package com.cryptoinvestment.controllers;

import com.cryptoinvestment.services.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Crypto Submit Rest Controller.
 * api: 'api/v1/crypto-invest/submit'
 *
 * @author maksim aleksandrov
 */
@Slf4j
@RestController
@RequestMapping(value = "api/v1/crypto-invest/submit", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Recommendation Crypto", description = "Recommendations Crypto API")
@RequiredArgsConstructor
public class CryptoSubmitController {

    private final FileService fileService;

    @Operation(summary = "Method submits new files", description = "Method submits new files")
    @ResponseBody
    @PostMapping(value = "/all")
    public ResponseEntity<Void> submitNewFilesProcessing() {
        fileService.processFileData();
        return ResponseEntity.ok().build();
    }
}

