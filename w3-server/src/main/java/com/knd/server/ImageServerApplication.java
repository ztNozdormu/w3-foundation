package com.w3.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"${knd.info.base-package}.server", "${knd.info.base-package}.module"})
public class ImageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageServerApplication.class, args);
	}

}
