package com.selenium.basic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;



public class FrameSwitchTest {

	public static void main(String[] args) throws InterruptedException {


		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://demoqa.com/frames");

		WebDriver driver = PageLauncher.driver;
		
	
		
		
		int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(countIframesInFrame1);
		
		driver.switchTo().frame("frame1"); //concentration driver will be changedto frame1
		
		
		WebElement ele = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(ele.getText());
		
		
		Thread.sleep(5000);
		
		
		driver.switchTo().defaultContent();// switch back to parent frame
		driver.quit();
		
		
	}

}
