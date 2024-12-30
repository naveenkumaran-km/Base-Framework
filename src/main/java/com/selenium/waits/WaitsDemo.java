package com.selenium.waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WaitsDemo {
	
	public static void main (String[] args) {
		
		/*
		 * Waits: Needed to capture web application reaction
		 * 
		 * Types of waits:
		 * 1.sleep
		 * 2.pageLoadTimeout
		 * 3.Implicit Wait
		 * 4.SetScreen Timeout
		 */
		
		//1. Sleep: force the browser to wait for a specific time.
		//2. PageLoadTimeout : wait for a page-load to complete before throwing an error
		//3 . Implicitly Wait: Tell the webdriver to wait certain amount of time before it throws exception (eg.nosuchelement exception)
		//4. Set screen timeout: asynchronous parts of the web page to finish loading for a specified number of seconds.
		try {
		//1. setting the path of the chrome driver
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//2. initialize chrome driver
		WebDriver driver = new ChromeDriver(options);
		
		//3. Implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//did not wait upto 10 seconds
		
		//4. launch the url
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		
		
		//5. Maximize the window
		driver.manage().window().maximize();
		
		//5.1 PageLoadTimeOut
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
		
	    //6. Verify page title
		String PageTitleActual = driver.getTitle();
		String PageTitleExpected = "JPetStore Demo";
		
		//Method 1
		if(PageTitleActual.equalsIgnoreCase(PageTitleExpected)) {
			System.out.println("Page title matches");
		}else {
			System.out.println("Page title is different");
		}
		
		//pause time
		Thread.sleep(5000);
		
		
		// Close all the opened browsers(2-3 windows)
		driver.quit();
		}catch(Exception e) {
			System.out.println("Error occurred");
		}
		
	}

}
