package com.selenium.basic;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class DownloadfiletoDiffDirectory {
	@Test
	public void downloadfile() {
		PageLauncher page = new PageLauncher();
		page.OpenURL("https://demoqa.com/upload-download");
		WebDriver driver = page.driver;

		WebElement downloadElement = driver.findElement(By.id("downloadButton"));
		downloadElement.click();

		File dir = new File(System.getProperty("user.home") + "\\Documents");
		File[] dirContents = dir.listFiles();
		System.out.println(System.getProperty("user.home") + "\\Documents");
		for (int i = 0; i < dirContents.length; i++) {

			if (dirContents[i].getName().equals("sampleFile.jpeg")) {
				// File has been found, it can now be deleted:
			//	dirContents[i].delete();
				System.out.println("File deleted");
				
			}
		}
	}

}
