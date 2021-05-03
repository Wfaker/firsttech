package com.msl.rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import com.msl.rule.lt.common.PolicyBomConvert;

@SpringBootApplication
@EnableAsync
@ComponentScan("com")
public class LtLifeApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LtLifeApplication.class);
		PolicyBomConvert.env = application.run(args).getEnvironment().getActiveProfiles()[0];
	}

}
