package com.selenium.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.basic.PageLauncher;

public class DatePicker {

	public static void main(String[] args) {
		
		
		Date date = new Date();
		SimpleDateFormat Format = new SimpleDateFormat("dd:MMM:yyyy");
		String filepath = Format.format(date);
		filepath = "19:Jan:2017";
		System.out.println("Date To be selected is : " + filepath);
		
		// date which is mentioned in filepath need to select
		
		
		String datasplit[] = filepath.split(":");
		String day = datasplit[0];
		String month = datasplit[1];
		String year = datasplit[2];
		
		int yearTobeSelect = Integer.parseInt(year);
		
		
		PageLauncher launchPage = new PageLauncher();
		launchPage.OpenURL("https://webdriveruniversity.com/Datepicker/index.html");
		
		WebDriver driver = PageLauncher.driver;
		
		//clicking the calendar icon
		WebElement calendarIcon = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-calendar']"));
		calendarIcon.click();
		
		//clicking the date header
		WebElement dateHeader = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
		dateHeader.click();
		
		//click backward option upto exact year will come
		
		WebElement previousyear = driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='prev']"));
		int yearInCalendar = Integer.parseInt(driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).getText());
		while(!(yearInCalendar == yearTobeSelect)) {
			
			previousyear.click();
			yearInCalendar = Integer.parseInt(driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).getText());
		}
		
		WebElement monthNeedtoSelect = driver.findElement(By.xpath("//span[text()='"+month+"']"));
		monthNeedtoSelect.click();
		
		WebElement dataNeedtoselect = driver.findElement(By.xpath("//td[contains(@class,'day') and text()='"+day+"']"));
		dataNeedtoselect.click();
		
		

	}

}
