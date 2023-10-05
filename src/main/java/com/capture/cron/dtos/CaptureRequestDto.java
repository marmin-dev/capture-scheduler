package com.capture.cron.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptureRequestDto {

    String filename;

    String urlPath;

}
