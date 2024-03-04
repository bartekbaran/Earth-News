package com.earth.news.EarthNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EarthNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EarthNewsApplication.class, args);
	}

}
