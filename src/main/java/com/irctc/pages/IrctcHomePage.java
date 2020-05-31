package com.irctc.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import com.irctc.utils.SeleniumWebDriver;
public class IrctcHomePage {
	SeleniumWebDriver swd=new SeleniumWebDriver();
	Actions act=null;
	@FindBy(xpath="//button[@class='btn btn-primary' and contains(text(),'Ok')]")
	WebElement covidAlert;
	
	@FindBy(xpath="//a[contains(text(),'LOGIN')]")
	WebElement loginLink;
	WebDriverWait wait=null;
	//JavascriptExecutor js=null;
	public void clickOnCovidAlertButton(WebDriver driv) {
		System.out.println(driv);
		wait=new WebDriverWait(driv,50);
		act=new Actions(driv);
		System.out.println("wait for alrt to display");
		
		System.out.println("move for ok button in the alert ");
		//act.moveToElement(covidAlert).build().perform();
		//swd.waitForElementToDisplay(covidAlert);
		wait.until(ExpectedConditions.elementToBeClickable(covidAlert));
		JavascriptExecutor js=(JavascriptExecutor)driv;
		System.out.println(js);
		js.executeScript("arguments[0].click();", covidAlert);
		//swd.waitForElementToDisplay(covidAlert);
		System.out.println("click on ok");
		//act.click(covidAlert);
	}
	public void clickOnLoginLink(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		loginLink.click();
	}

	
}
