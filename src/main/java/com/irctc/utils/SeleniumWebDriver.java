package com.irctc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriver {
	public static WebDriverWait wait=null;

	public static WebDriver driver=null;
	public static WebDriver driverInitialization(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().deleteAllCookies();
		
		///driver.get("https://www.united.com/en/us");
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,50);
		return driver;
		
	}
	public void waitForElementToDisplay(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public void closeDriver() {
		//driver.close();
		driver.quit();
	}
	
}
