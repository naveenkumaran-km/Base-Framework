package com.selenium.basic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;




public class FirstSeleniumTest {

	public static void main(String[] args) throws InterruptedException {

		//1. setting the path of the Edge driver
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
		
		
		//2. initialize Edge driver
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("headless");
		
		WebDriver driver = new EdgeDriver(options);
		
		//3. launch the url
		driver.get("https://webdriveruniversity.com/");
	//	driver.navigate().to("https://demoqa.com/");
		
	
		//4. Maximize the window
		driver.manage().window().maximize();
		

		//5. Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	    //6. Verify page title
		
		String PageTitleActual = driver.getTitle();
		String PageTitleExpected = "WebDriverUniversity";
		
		//Method 1
		if(PageTitleActual.equalsIgnoreCase(PageTitleExpected)) {
			System.out.println("Page title matches");
		}else {
			System.out.println("Page title is different");
		}
		
		//method2 - HardAssert, Softassert
		
//		Assert.assertEquals(PageTitleActual, PageTitleExpected);
		
		SoftAssert assertion = new SoftAssert();
//		
		assertion.assertEquals(PageTitleActual, PageTitleExpected);
		
		//pause time
		Thread.sleep(5000);
		
		
		// Close all the opened browsers(2-3 windows)
		driver.quit();
		
		//close only current opened 
		//driver.close();
		
		
		
	}

}
