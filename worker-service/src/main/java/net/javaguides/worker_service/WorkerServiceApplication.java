package net.javaguides.worker_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class WorkerServiceApplication {

	// maintainence mode, 3.5 depricated
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	// replacing with feign client
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkerServiceApplication.class, args);
	}

}
