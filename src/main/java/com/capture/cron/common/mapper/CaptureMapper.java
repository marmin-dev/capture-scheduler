package com.capture.cron.common.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptureMapper { // to JSON

    private String filename;

    private String urlPath;

}
