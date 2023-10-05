package com.capture.cron.services;

import com.capture.cron.common.exceptions.CustomException;
import com.capture.cron.common.exceptions.ErrorCode;
import com.capture.cron.common.mapper.CaptureMapper;
import com.capture.cron.repositories.LandingPageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@RequiredArgsConstructor
public class CaptureService {


//    private final LandingPageRepository repository;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final Gson gson;

    @Autowired // 생성자를 통해 빈 주입
    public CaptureService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper, LandingPageRepository repository, Gson gson) {
        this.webClient = webClientBuilder.baseUrl("http://211.191.174.11/").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        this.objectMapper = objectMapper;
//        this.repository = repository;
        this.gson = gson;
    }

//    @Autowired
//    public CaptureService(WebClient.Builder webClientBuilder, ObjectMapper mapper){
//        this.client = webClientBuilder.baseUrl("http://211.191.174.11/api/capture/").build();
//        this.mapper = ob
//    }
    public String capture(String filename, String urlPath){
/*
* 캡처하는 메서드
* DRF 에 요청을 보내 처리한다.
* */
        try{
            CaptureMapper mapper = new CaptureMapper(filename, urlPath); // 장고에 보낼 필요한 파라미터들
            String requestBody = gson.toJson(mapper); // 해당 오브젝트를 Json 형식으로 변환
            String response = webClient
                    .post() // http POST 로 전송하기, 응답값 출력하기
                    .uri("api/capture/")
                    .body(BodyInserters.fromValue(requestBody))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            System.out.println(response);
                    return response;
        } catch (Exception e){
            throw new CustomException(ErrorCode.CAPTURE_FAILED);
        }



    }







}
