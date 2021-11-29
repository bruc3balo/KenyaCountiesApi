package com.counties.kenya;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableScheduling
@CrossOrigin("*")
@Slf4j
public class KenyaCountiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(KenyaCountiesApplication.class, args);
	}
}
