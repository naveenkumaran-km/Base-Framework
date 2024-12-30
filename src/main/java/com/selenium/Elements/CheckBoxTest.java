package com.selenium.Elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.basic.PageLauncher;

public class CheckBoxTest {

	public static void main(String[] args) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

		WebDriver driver = PageLauncher.driver;
		
		//option1
		WebElement option1 = driver.findElement(By.xpath("//input[@value='option-1']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(option1));
		option1.click();

		if (option1.isSelected()) {
			System.out.println("option 1 is selected");
		}

		int numberOfOptions = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

		List<WebElement> optionList = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int i = 0; i < numberOfOptions; i++) {

			System.out.println(optionList.get(i).getAttribute("value"));

		}
		
		launchPage.closeBrowser();

	}

}
