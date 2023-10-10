package com.capture.cron.crons;

import com.capture.cron.services.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaptureTestingScheduler {
    // 스케줄을 사용하여 특정 시간에 랜딩 페이지를 등록하고 특정 시간에 캡쳐 시작하는 메서드

    private final LandingPageService landingPageService;

    @Scheduled(cron = "0 50 14 * * *")
    public void createLandingPage(){

        System.out.println("랜딩 페이지를 추가합니다.");

//        landingPageService.postLandingPage()





    }





}


