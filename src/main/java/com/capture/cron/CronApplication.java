package com.capture.cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 크론잡 이용하기
@SpringBootApplication
public class CronApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronApplication.class, args);
	}

}
