package com.nfcu.alertmedia.poc;

import org.jboss.aerogear.security.otp.Totp;
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
	
	private static final String SITE = "https://authenticationtest.com/totpChallenge/";

	public static void main(String[] args) {
		//String myPath = AlertmediaPocApplication.class.getClassLoader().getResource("geckodriver.exe").getPath();
		//System.out.println("myPath1:" + myPath);
		//String myPath1 = myPath.replaceAll("/C:", "");
		//System.out.println("myPath new:" + myPath1);
		SpringApplication.run(AlertmediaPocApplication.class, args);
	}
	
	@GetMapping("/notification")
	public String notification() {
		String flowMessage = "Started, ";
		try {
			//File file = new File("resources/chrome.exe");
			//String absolutePath = file.getPath();
			//System.setProperty("webdriver.chrome.driver", AlertmediaPocApplication.class.getClassLoader().getResource("chrome.exe").getPath());
			//String myPath = getClass().getClassLoader().getResource("chromedriver.exe").getPath();
			//String myPath = getClass().getClassLoader().getResource("geckodriver.exe").getPath();
			//myPath = myPath.replaceAll("/C:", "");
			//myPath = myPath.replaceAll("/D:", "");
			//System.out.println("myPath2:" + myPath);
			//System.setProperty("webdriver.chrome.driver", myPath);
			
			// Define ChromeDriver options
			/*
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("headless");
			
			WebDriver driver= new ChromeDriver();
	
			driver.get(SITE);
			
			WebElement emailElem = driver.findElement(By.id("email"));
			emailElem.sendKeys("totp@authenticationtest.com");
			wait(2);
			WebElement passwordElem = driver.findElement(By.id("password"));
			passwordElem.sendKeys("pa$$w0rd");
			wait(5);
			WebElement mfaElem = driver.findElement(By.id("totpmfa"));
			mfaElem.sendKeys(getMFACode());
			wait(5);
			WebElement submitElem = driver.findElement(By.xpath("//input[@type='submit']"));
			submitElem.click();
			*/
			
			try (Playwright playwright = Playwright.create()) {
				flowMessage += "Created PR, ";
	            //BrowserType chromium = playwright.firefox();
	            //flowMessage += "Created Browser, ";
	            // Connect to Browserless 
	            //Browser browser = chromium.connectOverCDP("wss://chrome.browserless.io?token=RVyoFsgeAqd7dd210b99202d220f5e66fa5724ac81");
	            Browser browser = playwright.chromium().launch();
	            flowMessage += "Launchede chromium, ";
	            // Create a new page and navigate to a URL
	            Page page = browser.newPage();
	            page.navigate("https://www.google.com/");
	            flowMessage += "Opened Page ";	
	            browser.close();
	        } catch(Exception e) {
	        	flowMessage += "Exception in playright, ";	
	        }
			
			/*
			BrowserStackTest bsTest = new BrowserStackTest();
			String bsMessage = bsTest.getFromBrowserStack();			
			flowMessage += bsMessage;
			*/
		} catch (Exception e) {
			return "AlertMedia processing is failed, Flow:" + flowMessage +", Error:" + e.getMessage();
		}
		
		return "AlertMedia Notofication is received!!! " + flowMessage;
	}
	
	private String getMFACode() {
		Totp totp = new Totp("I65VU7K5ZQL7WB4E");
		String mfaCode = totp.now();
		System.out.println("getMFACode:" + mfaCode);
		return mfaCode;		
	}
	
	private void wait(int secs) {
		try {
			Thread.sleep(secs);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
