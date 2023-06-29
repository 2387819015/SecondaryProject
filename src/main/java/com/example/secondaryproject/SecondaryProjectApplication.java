package com.example.secondaryproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.secondaryproject.mapper")
public class SecondaryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondaryProjectApplication.class, args);
	}

}
