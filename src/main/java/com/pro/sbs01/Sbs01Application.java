package com.pro.sbs01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JA AuditingEntity 기능을 활성화하기 위해서.
public class Sbs01Application {

	public static void main(String[] args) {
		SpringApplication.run(Sbs01Application.class, args);
	}

}
