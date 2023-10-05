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

    private String filename;

    private String urlPath;

//    private String captureYn;
//
//    public LandingPageRequestDto(String filename, String urlPath){
//        this.filename =
//    }

    public LandingPage toLandingPage(String filename, String urlPath){
        return LandingPage.builder()
                .url(urlPath)
                .filename(filename)
                .captureYn("Y")
                .build();
    }


}
