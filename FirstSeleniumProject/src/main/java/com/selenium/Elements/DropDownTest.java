package com.selenium.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.basic.PageLauncher;

public class DropDownTest {

	public static void main(String[] args) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

		WebDriver driver = PageLauncher.driver;
		
		//index
		WebElement options = driver.findElement(By.id("dropdowm-menu-1")) ;
		Select language = new Select(options);
		
		
		
		language.selectByIndex(0); 
		
		System.out.println(language.getFirstSelectedOption().getText()); //JAVA
		
		
		//By value
		language.selectByValue("c#");
		
		System.out.println(language.getFirstSelectedOption().getText());//C#
		
		
		
		
		//By Text
		language.selectByVisibleText("Python");
		System.out.println(language.getFirstSelectedOption().getText());//Python
		
		int numberOfOptions =language.getOptions().size();
		System.out.println("Number of Options: "+numberOfOptions);
		
		

	}

}
