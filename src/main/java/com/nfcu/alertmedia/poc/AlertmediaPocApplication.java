package com.nfcu.alertmedia.poc;

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
		//String myPath = AlertmediaPocApplication.class.getClassLoader().getResource("geckodriver.exe").getPath();
		//System.out.println("myPath1:" + myPath);
		//String myPath1 = myPath.replaceAll("/C:", "");
		//System.out.println("myPath new:" + myPath1);
		SpringApplication.run(AlertmediaPocApplication.class, args);
	}
	
	@GetMapping("/notification")
	public String notification() {
		try {
			//File file = new File("resources/chrome.exe");
			//String absolutePath = file.getPath();
			//System.setProperty("webdriver.chrome.driver", AlertmediaPocApplication.class.getClassLoader().getResource("chrome.exe").getPath());
			String myPath = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
			//String myPath = getClass().getClassLoader().getResource("geckodriver.exe").getPath();
			myPath = myPath.replaceAll("/C:", "");
			myPath = myPath.replaceAll("/D:", "");
			System.out.println("myPath2:" + myPath);
			System.setProperty("webdriver.chrome.driver", myPath);
			// Define ChromeDriver options
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("headless");
			
			WebDriver driver= new ChromeDriver();
	
			driver.get("https://www.browserstack.com/");
			
			/*
			try (Playwright playwright = Playwright.create()) {
	            BrowserType chromium = playwright.chromium();
	
	            // Connect to Browserless 
	            Browser browser = chromium.connectOverCDP("wss://chrome.browserless.io?token=RVyoFsgeAqd7dd210b99202d220f5e66fa5724ac81");
	
	            // Create a new page and navigate to a URL
	            Page page = browser.newPage();
	            page.navigate("https://www.google.com/");
	            
	
	            browser.close();
	        }
			*/
		} catch (Exception e) {
			return "AlertMedia processing is failed:" + e.getMessage();
		}
		return "AlertMedia Notofication is received!!!";
	}

}
