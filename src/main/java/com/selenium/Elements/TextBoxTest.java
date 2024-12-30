package com.selenium.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.basic.PageLauncher;

public class TextBoxTest {

	public static void main(String[] args) {
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://www.saucedemo.com/");

		WebDriver driver = PageLauncher.driver;
		
		//username webelemnt
		WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
		
		if (userName.isDisplayed()) {
			
			// username value which we passed
			userName.sendKeys("standard_user");
		}
		

		String expectedUserName = userName.getAttribute("value"); 
		System.out.println("UserName: "+expectedUserName); //standard_user
		
		
		// username cleared
		userName.clear();
		

		expectedUserName = userName.getAttribute("value");
		System.out.println("UserName: "+expectedUserName); // null
		
		userName.sendKeys("standard_user");
		
		WebElement pwdValue = driver.findElement(By.xpath("//div[@class='login_password']"));
		
		String pwd = pwdValue.getText();
		
		System.out.println("Password :"+pwd); //Password for all users: secret_sauce
		
		pwd = pwd.substring(pwd.indexOf(":")+1).trim();
		System.out.println("Corrected Password :"+pwd); //secret_sauce
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pwd);
		
		//clicked
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginButton.click();
		
		
		
		
		

		

		
		
		
		
		
		
		
		

	
		
		System.out.println("Logged IN");

		launchPage.closeBrowser();

	}

}
