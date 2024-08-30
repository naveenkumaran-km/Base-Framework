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



public class NestedFrameSwitchTest2 {

	public static void main(String[] args) throws InterruptedException {

		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/IFrame/index.html");

		WebDriver driver = PageLauncher.driver;
        
        //Number of Frames on a Page
        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);
        
        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));
        
        //Switch to Frame1
        driver.switchTo().frame(frame1);
        
        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));
        
        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);
        
        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);
        
        Thread.sleep(5000);
        //switch to child frame
        driver.switchTo().frame(0);
        
        //Locate the Element inside the Frame1
        WebElement frame2Element= driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]"));
        
        //Get the text for frame1 element
        String frame2Text=frame2Element.getText();
        System.out.println("Frame2 is :"+frame2Text);
        
        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);
        
        driver.close();
		
	}

}
