package dev.leo.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication
public class ShorturlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorturlApplication.class, args);
	}

}
