package com.selenium.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.basic.PageLauncher;

public class DependencyTest {

	WebDriver driver;

	@Test 
	public void browserInitialize() {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		driver = PageLauncher.driver;
	}

	@Test (dependsOnMethods = {"browserInitialize"})
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

//	@AfterMethod
//	public void browserclose() {
//		 driver.close();
//	}
}
