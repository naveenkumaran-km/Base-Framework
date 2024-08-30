package com.selenium.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.basic.PageLauncher;

public class TypesOfAlertTest {

	public static void main(String[] args) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://demoqa.com/alerts");

		WebDriver driver = PageLauncher.driver;

		// SIMPLE ALERT
		WebElement simple = driver.findElement(By.xpath("//button[@id='alertButton']"));
		if(isAlertPresent(driver)) {
			System.out.println("Alert iruku");
		}
		simple.click();
		if(isAlertPresent(driver)) {
			System.out.println("Alert iruku");
		}
		driver.switchTo().alert().accept(); // confirm the alert , no need to create separate webelement for clicking ok

		// PROMPT ALERT
		WebElement prompt = driver.findElement(By.xpath("//button[@id='promtButton']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", prompt); // automatically scroll upto the element and then click it

		Alert promptAlert = driver.switchTo().alert();

		String alertText = promptAlert.getText(); // alert message

		System.out.println("Alert text is " + alertText);

		promptAlert.sendKeys("Test User");
		promptAlert.accept();

		// Confirmation alert

		WebElement confirm = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		js.executeScript("arguments[0].scrollIntoView(true);", confirm); // it will scroll upto that element
		confirm.click();

		driver.switchTo().alert().dismiss();

	}

	public static boolean isAlertPresent(WebDriver driver) {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

}
