package com.capture.cron.crons;


import com.capture.cron.dtos.LandingPageRequestDto;
import com.capture.cron.services.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CaptureTestingScheduler {
    // 스케줄을 사용하여 특정 시간에 랜딩 페이지를 등록하고 특정 시간에 캡쳐 시작하는 메서드

    private final LandingPageService landingPageService;

    @Scheduled(cron = "0 50 14 * * *")
    public void createLandingPage(){
    // 매일 2시 50분에 랜딩 페이지 등록
        System.out.println("랜딩 페이지를 추가합니다.");

        LocalDateTime now = LocalDateTime.now();

//        landingPageService.postLandingPage()
        List<LandingPageRequestDto> dtos = new ArrayList<>();
        dtos.add(new LandingPageRequestDto("chimchakman" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("mbcevery" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("profile"+ now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("greenday" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("naver"+ now,"https://www.youtube.com/@ChimChakMan_Official"));

        System.out.println(dtos.stream().map(landingPageService::postLandingPage));
    }

    @Scheduled(cron = "0 55 14 * * *")
    public void captureLandingpage(){
        System.out.println("랜딩 페이지를 캡쳐합니다");

    }





}


