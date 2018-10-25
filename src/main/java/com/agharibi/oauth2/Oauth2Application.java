package com.agharibi.oauth2;

import com.agharibi.oauth2.spring.AuthorizationServerConfiguration;
import com.agharibi.oauth2.spring.ResourceServerConfiguration;
import com.agharibi.oauth2.spring.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan("com.agharibi.oauth2")
@EnableJpaRepositories("com.agharibi.oauth2")
@EntityScan("com.agharibi.oauth2.model")
@SpringBootApplication
public class Oauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				Oauth2Application.class,
				AuthorizationServerConfiguration.class,
				ResourceServerConfiguration.class,
				WebMvcConfiguration.class}, args);
	}
}
