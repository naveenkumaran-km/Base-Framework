package com.selenium.basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload {

	@Test
	public void uploadFile() throws AWTException {
		PageLauncher page = new PageLauncher();
		page.OpenURL("https://demoqa.com/upload-download");
		WebDriver driver = page.driver;
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("scroll(0,500)");
//		StringSelection stringSelection = new StringSelection(
//				System.getProperty("user.home") + "\\Downloads\\chromedriver.exe");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		WebElement uploadElement = driver.findElement(By.id("uploadFile"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(uploadElement));
		uploadElement.sendKeys(System.getProperty("user.home") + "\\Downloads\\chromedriver.exe");
		/*
		uploadElement.click();
		// Robot object creation
		Robot r = new Robot();
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
		// pressing ctrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		// releasing ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);*/

	}

}
