package com.example.bootwithtesting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bootwithtesting.mapper")
public class BootwithtestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootwithtestingApplication.class, args);
	}

}
