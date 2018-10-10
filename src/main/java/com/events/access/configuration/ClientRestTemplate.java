package com.events.access.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientRestTemplate {
	
	
	@Bean
	public RestTemplate getFRestTemplate() {
		return new RestTemplate();
	}

}
