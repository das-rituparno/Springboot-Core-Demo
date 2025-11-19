package com.conceptandcoding.AsyncAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncAnnotationApplication.class, args);
	}
}
