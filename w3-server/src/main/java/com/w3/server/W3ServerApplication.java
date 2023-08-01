package com.w3.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"${w3.info.base-package}.server", "${w3.info.base-package}.module"})
public class W3ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(W3ServerApplication.class, args);
	}

}
