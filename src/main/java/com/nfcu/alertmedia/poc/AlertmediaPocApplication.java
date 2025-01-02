package com.nfcu.alertmedia.poc;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		//File file = new File("resources/chrome.exe");
		//String absolutePath = file.getPath();
		System.setProperty("webdriver.chrome.driver", AlertmediaPocApplication.class.getClassLoader().getResource("chrome.exe").getPath());
		// Define ChromeDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
		WebDriver driver= new ChromeDriver(options);

		driver.get("https://www.browserstack.com/");
		return " AlertMedia Notofication is received!!!";
	}

}
