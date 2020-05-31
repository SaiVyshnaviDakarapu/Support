package com.irctc.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class IrctcPnrStatusPage {
	WebDriverWait wait=null;
	
	@FindBy(xpath="//h3[contains(text(),'Passenger Current Status Enquiry')]")
	WebElement pnrHeader;
	String parent="";
	public void switcToPnrWindow(WebDriver driv) {
		try {
		parent=driv.getWindowHandle();
		Set<String> allWindows=driv.getWindowHandles();
		for(String child:allWindows) {
			if(!child.equalsIgnoreCase(parent)) {
				driv.switchTo().window(child);
				
			}
		}
		}catch(Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		
	}
	public void verifyPnrPageTitle(WebDriver driv) {
		try {
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(pnrHeader));
		
		Assert.assertEquals("Welcome to Indian Railway Passenger Reservation Enquiry", driv.getTitle());
		Thread.sleep(5000);
		driv.close();
		driv.switchTo().window(parent);
		}catch(Exception e) {
			System.out.println("Exception occured in pnr page");
		}
		
	}
}
