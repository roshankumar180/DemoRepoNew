package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserName, String baseUrl) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome Browser Launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Firefox Browser Launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./exe/geckodriver.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("IE Browser Launch", true);
		}
			
		return driver;
	}
}
