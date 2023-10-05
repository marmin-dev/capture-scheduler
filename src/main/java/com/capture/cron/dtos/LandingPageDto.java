package com.capture.cron.dtos;


import com.capture.cron.entities.LandingPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandingPageDto {

    private Long id;

    private String urlPath;

    private String filename;

    private String captureYn;

    public LandingPageDto(LandingPage page){
        this.id = page.getId();
        this.urlPath = page.getUrl();
        this.filename = page.getFilename();
        this.captureYn = page.getCaptureYn();
    }


}
