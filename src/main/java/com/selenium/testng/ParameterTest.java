package com.selenium.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import com.selenium.basic.PageLauncher;

public class ParameterTest {
	
	WebDriver driver;

	@Test 
	@Parameters ({"URLParameter"})
	public void browserInitialize(String url) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL(url);
		driver = PageLauncher.driver;
	}

	@AfterMethod 
	public void methodToExecute() {

		WebElement option1 = driver.findElement(By.xpath("//input[@value='option-1']"));
		option1.click();

		if (option1.isSelected()) {
			System.out.println("option 1 is selected");
		}

		int numberOfOptions = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

		List<WebElement> optionList = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int i = 0; i < numberOfOptions; i++) {

			System.out.println(optionList.get(i).getAttribute("value"));

		}
	}

	@AfterTest
	public void browserclose() {
		 driver.close();
	}

}
