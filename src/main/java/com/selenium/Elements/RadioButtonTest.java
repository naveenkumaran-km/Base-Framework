package com.selenium.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.basic.PageLauncher;

public class RadioButtonTest {

	public static void main(String[] args) {
		
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebDriver driver = PageLauncher.driver;
		
		WebElement GreenColour = driver.findElement(By.xpath("//input[@value='green']"));
		GreenColour.click();
		
		if(GreenColour.isSelected()) {
			System.out.println("Green Colour is selected");
		}
		
		int numberOfOptions = driver.findElements(By.xpath("//form[@id='radio-buttons']//input[@type='radio']")).size();
		
		List <WebElement> optionList = driver.findElements(By.xpath("//form[@id='radio-buttons']//input[@type='radio']"));
		
		for(int i=0;i<numberOfOptions;i++) {
			
			System.out.println(optionList.get(i).getAttribute("value"));
			
		}
		
		WebElement cabbage = driver.findElement(By.xpath("//input[@value='cabbage']"));
		
		if(!(cabbage.isEnabled())) {
			System.out.println("Cabbage is not enabled");
			
		}
		
		
		launchPage.closeBrowser();
		

	}

}
