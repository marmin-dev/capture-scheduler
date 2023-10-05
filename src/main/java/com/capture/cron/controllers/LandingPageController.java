package com.capture.cron.controllers;


import com.capture.cron.services.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/landing")
public class LandingPageController {

    private final LandingPageService service;

//    @PostMapping
//    public ResponseEntity<Long> postResponse(){
//
//    }




}
