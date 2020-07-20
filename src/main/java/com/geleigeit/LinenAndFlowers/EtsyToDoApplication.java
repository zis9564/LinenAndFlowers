package com.geleigeit.LinenAndFlowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
public class EtsyToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsyToDoApplication.class, args);
	}
}