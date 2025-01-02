package com.nfcu.alertmedia.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@SpringBootApplication
@RestController
public class AlertmediaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertmediaPocApplication.class, args);
	}
	
	@GetMapping("/notification")
	public String notification() {
		/*
		//File file = new File("resources/chrome.exe");
		//String absolutePath = file.getPath();
		//System.setProperty("webdriver.chrome.driver", AlertmediaPocApplication.class.getClassLoader().getResource("chrome.exe").getPath());
		// Define ChromeDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
		WebDriver driver= new ChromeDriver(options);

		driver.get("https://www.browserstack.com/");
		*/
		
		try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();

            // Connect to Browserless 
            Browser browser = chromium.connectOverCDP("wss://chrome.browserless.io?token=RVyoFsgeAqd7dd210b99202d220f5e66fa5724ac81");

            // Create a new page and navigate to a URL
            Page page = browser.newPage();
            page.navigate("https://www.google.com/");
            

            browser.close();
        }
		
		return " AlertMedia Notofication is received!!!";
	}

}
