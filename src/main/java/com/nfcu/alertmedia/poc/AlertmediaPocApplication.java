package com.nfcu.alertmedia.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AlertmediaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertmediaPocApplication.class, args);
	}
	
	@GetMapping("/notification")
	public String notification() {
		return " AlertMedia Notofication is received!!!";
	}

}
