package com.irctc.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.utils.SeleniumWebDriver;

public class IrctcLoyaltyAndMealsPage {
	WebDriverWait wait=null;
	
	Actions act=null;
	String parent="";
	
	@FindBy(xpath="//a[contains(text(),'LOYALTY')]")
	WebElement loyalty;
	@FindBy(xpath="//span[contains(text(),'About IRCTC SBI Credit Card')]")
	WebElement irctcSbiCard; 
	@FindBy(xpath="//span[contains(text(),'IRCTC SBI Platinum Card e-apply')]")
	WebElement irctcSbiPlatinumCard;
	
	@FindBy(xpath="//a[contains(@href,'https://www.sbicard.com/en/eapply')]")
	WebElement irctcSbiCard_a;
	
	@FindBy(xpath="//h3[contains(text(),'IRCTC SBI Platinum Card')]")
	WebElement irctcSbiPlatinumCard_header;
	
	@FindBy(xpath="//div[@class='mat-select-arrow']")
	WebElement irctcSbiPlatinumCard_arrow;
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement irctcSbiPlatinumCard_Fname;
	@FindBy(xpath="//input[@placeholder='Middle Name(Optional)")
	WebElement irctcSbiPlatinumCard_Mname;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement irctcSbiPlatinumCard_Lname;
	@FindBy(xpath="//input[@placeholder='Residential City']")
	WebElement irctcSbiPlatinumCard_Rcity;
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement irctcSbiPlatinumCard_EmailAddress;
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement irctcSbiPlatinumCard_Mnum;
	
	

	@FindBy(xpath="//a[contains(text(),'MEALS')]")
	WebElement meals;
	@FindBy(xpath="//span[contains(text(),'E-Catering')]")
	WebElement E_Catering;
	@FindBy(xpath="//span[contains(text(),'Standard Menu Rates')]")
	WebElement standardMenuRates;
	
	@FindBy(xpath="//div[contains(text(),'Dismiss')]")
	WebElement ecarting_dismiss;
	
	@FindBy(xpath="//input[@placeholder='Enter 10 digit PNR']")
	WebElement ecarting_phnNum;
	
	@FindBy(xpath="//a[contains(text(),'E-Catering')]")
	WebElement ecart;
	
	public void ValidateStandardmenuRates(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(meals));
			act.moveToElement(meals).moveToElement(standardMenuRates).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(ecart));
			Assert.assertTrue(IsElementDisplayed(ecart,driv), "Ecatering phonen number displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void standardmenuRatesValidate(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(meals));
			act.moveToElement(meals).moveToElement(standardMenuRates).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(ecart));
			Assert.assertTrue(IsElementDisplayed(ecart,driv), "Ecatering phonen number displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	
	public void ValidateEcartingFileds(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(meals));
			act.moveToElement(meals).moveToElement(E_Catering).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(ecarting_dismiss));
			ecarting_dismiss.click();
			wait.until(ExpectedConditions.elementToBeClickable(ecarting_phnNum));
			Assert.assertTrue(IsElementDisplayed(ecarting_phnNum,driv), "Ecatering phonen number displayed successfully");
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void verifyMealsMenu(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(meals));
			act.moveToElement(meals).build().perform();
			Assert.assertTrue(IsElementDisplayed(E_Catering,driv), "Title Arrow displayed successfully");
			Assert.assertTrue(IsElementDisplayed(standardMenuRates,driv), "Title Arrow displayed successfully");
		}catch(Exception e) {
			
		}
	}
	public void verifyLoyaltyMenu(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(loyalty));
			act.moveToElement(loyalty).build().perform();
			Assert.assertTrue(IsElementDisplayed(irctcSbiCard,driv), "Title Arrow displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard,driv), "Title Arrow displayed successfully");
		}catch(Exception e) {
			
		}
	}
	public void mealsMenu(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(meals));
			act.moveToElement(meals).build().perform();
			Assert.assertTrue(IsElementDisplayed(E_Catering,driv), "Title Arrow displayed successfully");
			Assert.assertTrue(IsElementDisplayed(standardMenuRates,driv), "Title Arrow displayed successfully");
		}catch(Exception e) {
			
		}
	}
	public void irctcSbiCard(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(loyalty));
			act.moveToElement(loyalty).moveToElement(irctcSbiCard).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(irctcSbiCard_a));
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}
	public void irctcSbiPlatinumCard(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(loyalty));
			act.moveToElement(loyalty).moveToElement(irctcSbiPlatinumCard).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(irctcSbiPlatinumCard_header));
			driv.close();
			driv.switchTo().window(parent);
		}catch(Exception e) {
			driv.close();
			driv.switchTo().window(parent);
		}
	}


	public void validateSbiPlatinumCardFields(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(loyalty));
			act.moveToElement(loyalty).moveToElement(irctcSbiPlatinumCard).click().build().perform();
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			wait.until(ExpectedConditions.elementToBeClickable(irctcSbiPlatinumCard_header));
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_arrow,driv), "Title Arrow displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_Fname,driv), "First name displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_Mname,driv), "middle name displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_Lname,driv), "lats name displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_Rcity,driv), "Residential city displayed successfully");
			Assert.assertTrue(IsElementDisplayed(irctcSbiPlatinumCard_EmailAddress,driv), "emial address displayed successfully");
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
}
