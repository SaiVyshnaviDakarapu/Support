package com.irctc.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcAtStationsAndMorePage {
WebDriverWait wait=null;
	
	Actions act=null;
	String parent="";
	
	@FindBy(xpath="//a[contains(text(),'MORE')]")
	WebElement More; 
	@FindBy(xpath="//span[contains(text(),'IRCTC iMudra')]")
	WebElement irctcMudra;
	@FindBy(xpath="//span[contains(text(),'Link Your Aadhaar')]")
	WebElement linkYourAdhar;
	@FindBy(xpath="//span[contains(text(),'Counter Ticket Cancellation')]")
	WebElement counterTicketCancellation;
	@FindBy(xpath="//span[contains(text(),'Counter Ticket Boarding Point Change')]")
	WebElement counterTicketBoardingPointChange;
	@FindBy(xpath="//span[contains(text(),'Forgot User ID')]")
	WebElement forgotUserId;
	@FindBy(xpath="//span[contains(text(),'Forgot Password')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//a[contains(text(),'AT STATIONS')]")
	WebElement atStations;
	@FindBy(xpath="//span[contains(text(),'WI-Fi Railway Stations')]")
	WebElement wifirailwayStations;
	@FindBy(xpath="//span[contains(text(),'Battery Operated Cars')]")
	WebElement batteryoperatedCars;
	@FindBy(xpath="//span[contains(text(),'E-wheelchair')]")
	WebElement eWheelChair;
	
	@FindBy(xpath="//span[contains(text(),'Retiring Room')]")
	WebElement retiringRoom;
	@FindBy(xpath="//a[contains(text(),'Subscriber Online Payment')]")
	WebElement wifi_link; 
	@FindBy(xpath="//embed[contains(@type,'application/pdf')]")
	WebElement battery_pdf;
	@FindBy(xpath="//h5[contains(text(),'Wheelchair')]")
	WebElement eWheelChair_Header;
	
	@FindBy(xpath="//button[contains(text(),'Okay')]")
	WebElement retiringCovidAlert;
	@FindBy(xpath="//label[contains(text(),'Retiring Room')]")
	WebElement retiringHeader;
	public boolean IsElementDisplayed(WebElement we,WebDriver driv) {

		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(we));
		if(we.isDisplayed() && we.isEnabled()) {
			flag=true;
		}
		return flag;

	}
	
	public void ValidateAtStationsMenu(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(atStations));
			act.moveToElement(atStations).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(wifirailwayStations));
			Assert.assertTrue(IsElementDisplayed(wifirailwayStations,driv), "Wifi railway stations displayed successfully");
			Assert.assertTrue(IsElementDisplayed(batteryoperatedCars,driv), "batery operated carsdisplayed successfully");
			Assert.assertTrue(IsElementDisplayed(eWheelChair,driv), "e wheelchair name displayed successfully");
			Assert.assertTrue(IsElementDisplayed(retiringRoom,driv), "retiring room displayed successfully");
			
		}catch(Exception e) {
			
		}
	}
	
	public void WifiRailwayStations(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(atStations));
			act.moveToElement(atStations).moveToElement(wifirailwayStations).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(wifi_link));
			Assert.assertTrue(IsElementDisplayed(wifi_link,driv), "Subscribe link displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void batteryOperatedCars(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(atStations));
			act.moveToElement(atStations).moveToElement(batteryoperatedCars).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(battery_pdf));
			Assert.assertTrue(IsElementDisplayed(battery_pdf,driv), "PDF displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	 
	 
	public void eWheelchair(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(atStations));
			act.moveToElement(atStations).moveToElement(eWheelChair).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(eWheelChair_Header));
			Assert.assertTrue(IsElementDisplayed(eWheelChair_Header,driv), "Wheelchair displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	} 
	public void validateMoreMenu(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(More));
			act.moveToElement(More).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(irctcMudra));
			Assert.assertTrue(IsElementDisplayed(irctcMudra,driv), "irctc mudra displayed successfully");
			Assert.assertTrue(IsElementDisplayed(linkYourAdhar,driv), "link your aadhar displayed successfully");
			Assert.assertTrue(IsElementDisplayed(counterTicketCancellation,driv), "counter ticket cancellation displayed successfully");
			Assert.assertTrue(IsElementDisplayed(counterTicketBoardingPointChange,driv), "counter ticket boarding point displayed successfully");
			Assert.assertTrue(IsElementDisplayed(forgotPassword,driv), "forgot password displayed successfully");
			Assert.assertTrue(IsElementDisplayed(forgotUserId,driv), "forgot user id displayed successfully");
		}catch(Exception e) {
			e.printStackTrace();
			driv.close();
			driv.switchTo().window(parent);
		}
	}

}
