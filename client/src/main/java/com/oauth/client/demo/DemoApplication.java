package com.oauth.client.demo;

import com.oauth.client.demo.spring.ClientMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oauth.client.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				DemoApplication.class, ClientMvcConfig.class}, args);
	}
}
