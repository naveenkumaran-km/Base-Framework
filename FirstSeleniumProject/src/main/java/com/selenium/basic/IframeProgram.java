package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeProgram {

	public static void main(String[] args) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/IFrame/index.html");

		WebDriver driver = PageLauncher.driver;
		int countIframesInFrame1 = driver.findElements(By.tagName("iframe")).size();

		System.out.println("No of Frames: " + countIframesInFrame1);

		driver.switchTo().frame("frame");

		WebElement para = driver
				.findElement(By.xpath("(//div[@class='col-sm-8 col-lg-8 col-md-8']//div[@class='caption']//p)[1]"));

		System.out.println(para.getText());

		driver.switchTo().defaultContent();

	}

}
