package com.capture.cron.controllers;


import com.capture.cron.common.exceptions.CustomException;
import com.capture.cron.common.exceptions.ErrorCode;
import com.capture.cron.dtos.LandingPageRequestDto;
import com.capture.cron.services.CaptureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/capture")
@RequiredArgsConstructor
public class CaptureController {

    private final CaptureService service;

    @PostMapping
    public ResponseEntity<String> selfCapture(@RequestBody LandingPageRequestDto dto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.capture(dto.getFilename(), dto.getUrlPath()));
        }catch (Exception e){
            throw new CustomException(ErrorCode.CAPTURE_FAILED);
        }
    }

    




}
