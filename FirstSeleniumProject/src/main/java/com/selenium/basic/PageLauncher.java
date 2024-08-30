package com.selenium.basic;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLauncher {

	public static WebDriver driver = null;

	public void OpenURL(String URL) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		
//		Map<String, Object> prefs = new HashMap();
//		prefs.put("download.default_directory", System.getProperty("user.home") + "\\Documents");
//		prefs.put("download.prompt_for_download", false);
//		prefs.put("directory_upgrade", true);
//		prefs.put("safebrowsing.enabled", true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		

	}

	public void closeBrowser() {
		
		driver.close();

	}

}
