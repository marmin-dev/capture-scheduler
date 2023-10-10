package com.capture.cron.controllers;


import com.capture.cron.common.exceptions.CustomException;
import com.capture.cron.common.exceptions.ErrorCode;
import com.capture.cron.dtos.LandingPageRequestDto;
import com.capture.cron.services.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/landing")
public class LandingPageController {

    private final LandingPageService service;

    @PostMapping
    public ResponseEntity<Long> postResponse(@RequestBody LandingPageRequestDto dto){
        // 랜딩 페이지를 등록하는 메서드
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.postLandingPage(dto));
        }catch (Exception e){
            throw new CustomException(ErrorCode.POST_LANDING_FAILED);
        }
    }

}
