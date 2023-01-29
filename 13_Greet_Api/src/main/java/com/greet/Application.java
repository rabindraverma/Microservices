package com.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greet.client.WelcomeClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

	@Autowired
	WelcomeClient client;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/greet")
	public String getGreet() {
		String welcomeResponse = client.invokeWelcomApi();
		String greetResponse= "........Hi, Good AfterNoon guys...!!!";
		
		return welcomeResponse+greetResponse;
	}
}
