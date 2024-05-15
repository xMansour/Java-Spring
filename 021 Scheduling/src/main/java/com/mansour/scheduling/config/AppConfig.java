package com.mansour.scheduling.config;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AppConfig {
    Logger log = LoggerFactory.getLogger(AppConfig.class);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    @Scheduled(fixedRateString = "${schedualing-fixed-rate-string}")
    private void printTime() {
        log.info("Time is: {}", LocalTime.now().format(dateTimeFormatter));

    }

}
