package com.flashdin.belajarspringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BelajarSpringWebApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BelajarSpringWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringWebApplication.class, args);
	}
}
