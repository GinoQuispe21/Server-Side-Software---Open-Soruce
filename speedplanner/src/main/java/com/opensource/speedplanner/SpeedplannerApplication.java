package com.opensource.speedplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpeedplannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeedplannerApplication.class, args);
    }

}
