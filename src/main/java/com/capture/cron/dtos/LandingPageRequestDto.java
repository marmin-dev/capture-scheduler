package com.capture.cron.dtos;

import com.capture.cron.entities.LandingPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class LandingPageRequestDto {
    /*
    * 랜딩페이지 등록 시 입력받을 dto
    * */
    private String filename;

    private String urlPath;

//    private String captureYn;
//
//    public LandingPageRequestDto(String filename, String urlPath){
//        this.filename =
//    }

    public LandingPage toLandingPage(LandingPageRequestDto dto){
        return LandingPage.builder()
                .url(dto.getUrlPath())
                .filename(dto.getFilename())
                .captureYn("Y")
                .build();
    }


}
