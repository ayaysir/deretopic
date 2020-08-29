package com.example.deretopic;

import com.example.deretopic.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class DeretopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeretopicApplication.class, args);
	}

}
