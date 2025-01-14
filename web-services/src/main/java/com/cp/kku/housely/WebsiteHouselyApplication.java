package com.cp.kku.housely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@Configuration
public class WebsiteHouselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteHouselyApplication.class, args);
	}

}
