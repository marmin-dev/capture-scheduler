package com.capture.cron.crons;


import com.capture.cron.dtos.LandingPageDto;
import com.capture.cron.dtos.LandingPageRequestDto;
import com.capture.cron.services.CaptureService;
import com.capture.cron.services.LandingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CaptureTestingScheduler {
    // 스케줄을 사용하여 특정 시간에 랜딩 페이지를 등록하고 특정 시간에 캡쳐 시작하는 메서드

    private final CaptureService captureService;
    private final LandingPageService landingPageService;

    //@Scheduled(cron = "0 50 14 * * *")
    @Scheduled(initialDelay = 2000, fixedDelay = 10000)
    public void createLandingPage(){
    // 매일 2시 50분에 랜딩 페이지 등록
        System.out.println("랜딩 페이지를 추가합니다.");

        LocalDateTime now = LocalDateTime.now();

//        landingPageService.postLandingPage()
        List<LandingPageRequestDto> dtos = new ArrayList<>();
        // 추가하기
        dtos.add(new LandingPageRequestDto("chimchakman" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("mbcevery" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("profile"+ now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("greenday" + now,"https://www.youtube.com/@ChimChakMan_Official"));
        dtos.add(new LandingPageRequestDto("naver"+ now,"https://www.youtube.com/@ChimChakMan_Official"));

        System.out.println(dtos.stream().map(landingPageService::postLandingPage).collect(Collectors.toList()));
    }

    @Scheduled(cron = "0 55 14 * * *")
    public void captureLandingPage(){
        System.out.println("랜딩 페이지를 캡쳐합니다");
        List<LandingPageDto> landingPages=landingPageService.findByCaptureYn();
        landingPages.stream().map(dto -> {
            captureService.capture(dto.getUrlPath(), dto.getFilename());
            System.out.println(landingPageService.updateCapture(dto));
            return "성공";
        });


    }
//    @Scheduled(fixedRate = 3000)
//    public void hello(){
//        System.out.println("안냐세여");
//    }
}


