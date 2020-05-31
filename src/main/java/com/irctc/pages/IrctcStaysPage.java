package com.irctc.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcStaysPage {

	WebDriverWait wait=null;
	@FindBy(xpath="//a[contains(text(),'STAYS')]")
	WebElement stays;
	@FindBy(xpath="//span[contains(text(),'IRCTC Hotels')]")
	WebElement hotels;
	@FindBy(xpath="//span[contains(text(),'Retiring Room')]")
	WebElement retiringRoom;
	@FindBy(xpath="//span[contains(text(),'Lounge')]")
	WebElement lounge;
	@FindBy(xpath="//a[contains(text(),'IRCTC Hotels')]")
	WebElement hotelHeader;
	@FindBy(xpath="//button[contains(text(),'Okay')]")
	WebElement retiringCovidAlert;
	@FindBy(xpath="//label[contains(text(),'Retiring Room')]")
	WebElement retiringHeader;
	@FindBy(xpath="//span[contains(text(),'Lounge')]")
	WebElement loungeHeader;


	@FindBy(xpath="//select[@name='city']")
	WebElement stationName;
	@FindBy(xpath="//select[@name='laungecity']")
	WebElement lounges;
	@FindBy(xpath="//select[@name='selPassangers']")
	WebElement noOfPassangers;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	WebElement resetButton;


	@FindBy(xpath="//input[contains(@placeholder,'Enter hotel name or city name')]")
	WebElement hotelDestination;
	@FindBy(xpath="//input[contains(@placeholder,'Check-in Date')]")
	WebElement checkin;
	@FindBy(xpath="//input[contains(@placeholder,'Check-out Date')]")
	WebElement checkout;
	@FindBy(xpath="//input[contains(@name,'guest')]")
	WebElement rooms;
	//@FindBy(xpath="//button[contains(text(),'Find Hotel')]")
	@FindBy(xpath="//div[contains(@class,'form-btn-find')]/button")
	WebElement findHotel;
	Actions act=null;
	String parent="";

	public void retiringRooms(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(retiringRoom).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(retiringCovidAlert));
			retiringCovidAlert.click();
			wait.until(ExpectedConditions.elementToBeClickable(retiringHeader));
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void retiringRoomsValidation(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(retiringRoom).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(retiringCovidAlert));
			retiringCovidAlert.click();
			wait.until(ExpectedConditions.elementToBeClickable(retiringHeader));
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}

	public void hotels(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(hotels).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(hotelHeader));
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}

	}
	public boolean IsElementDisplayed(WebElement we,WebDriver driv) {

		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(we));
		if(we.isDisplayed() && we.isEnabled()) {
			flag=true;
		}
		return flag;

	}

	public void verifyStaysMenu(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act=new Actions(driv);
			act.moveToElement(stays).build().perform();

			Assert.assertTrue(IsElementDisplayed(stays,driv), "Stays menu displayed successfully");
			Assert.assertTrue(IsElementDisplayed(hotels,driv), "Hotels ;ist displayed successfully");
			Assert.assertTrue(IsElementDisplayed(retiringRoom,driv), "Retiring room list displayed successfully");
			Assert.assertTrue(IsElementDisplayed(lounge,driv), "lounge list displayed successfully");
		}catch(Exception e) {
			System.out.println("Stays menu valdation failed");
		}
	}
	public void lounge(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(lounge).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(loungeHeader));
			driv.close();
			driv.switchTo().window(parent);
		}
		catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}


	public void validadteloungeFields(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(lounge).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(loungeHeader));	
			Assert.assertTrue(IsElementDisplayed(resetButton,driv), "Reset button displayed successfully");
			Assert.assertTrue(IsElementDisplayed(stationName,driv), "Station name displayed successfully");
			Assert.assertTrue(IsElementDisplayed(lounge,driv), "Lounge displayed successfully");
			Assert.assertTrue(IsElementDisplayed(noOfPassangers,driv), "Number of passangers displayed successfully");
			driv.close();
			driv.switchTo().window(parent);


		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void validadteHotelFields(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(stays));
			act.moveToElement(stays).moveToElement(hotels).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(hotelHeader));	
			Assert.assertTrue(IsElementDisplayed(hotelDestination,driv), "Hotel Destination displayed successfully");
			Assert.assertTrue(IsElementDisplayed(checkin,driv), "Checkin date displayed successfully");
			Assert.assertTrue(IsElementDisplayed(checkout,driv), "Checkout date displayed successfully");
			Assert.assertTrue(IsElementDisplayed(rooms,driv), "rooms/guests displayed successfully");
			//Assert.assertTrue(IsElementDisplayed(findHotel,driv), "Find hotel displayed successfully");
			driv.close();
			driv.switchTo().window(parent);

		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}


}
