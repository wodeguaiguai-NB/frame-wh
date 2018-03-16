package com.team.framenb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class FrameNbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameNbApplication.class, args);
	}
}
