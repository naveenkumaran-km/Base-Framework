package com.selenium.waits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitAndFluentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4. Explicit wait: wait for certain conditions upto max time given before
		// throwing an error
		/*
		 * Explicit conditions: alertIsPresent() elementSelectionStateToBe()
		 * elementToBeClickable() elementToBeSelected()
		 * frameToBeAvaliableAndSwitchToIt() invisibilityOfTheElementLocated()
		 * 
		 * invisibilityOfElementWithText() presenceOfAllElementsLocatedBy()
		 * presenceOfElementLocated() textToBePresentInElement()
		 * textToBePresentInElementLocated() textToBePresentInElementValue() titleIs()
		 * titleContains() visibilityOf() visibilityOfAllElements()
		 * visibilityOfAllElementsLocatedBy() visibilityOfElementLocated()
		 */
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//	wait.until(ExpectedConditions.)
		
		
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PWGadget01r"));

		
		
		
		
		
		
		
		
		
		
		
		
		// 5.FluentWait:maximum amount of time to wait for a condition, as well as the
		// frequency with which to check the condition

		Wait<WebDriver> waiting = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement foo = waiting.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}

		});

	}
}
