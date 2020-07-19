package com.geleigeit.LinenAndFlowers;

import com.geleigeit.LinenAndFlowers.config.DataConfig;
import com.geleigeit.LinenAndFlowers.entity.util.ColourUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EtsyToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtsyToDoApplication.class, args);
	}
}