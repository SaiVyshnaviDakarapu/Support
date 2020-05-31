package com.irctc.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcHolidaysMenuPage {

	WebDriverWait wait=null;
	@FindBy(xpath="//a[contains(text(),'HOLIDAYS ')]")
	WebElement Holidays;

	@FindBy(xpath="//span[contains(text(),'Special Trains')]")
	WebElement SpecialTrains;

	@FindBy(xpath="//span[contains(text(),'Tourist Train')]")
	WebElement touristTrain;

	@FindBy(xpath="//span[contains(text(),'Maharaja')]")
	WebElement maharajExpress;

	@FindBy(xpath="//div[contains(@class,'sub-filters')]//label")
	WebElement Touristtrain_OriginFilters;
	@FindBy(xpath="//a[contains(text(),'maharajas@irctc.com')]")
	WebElement maharajasEmail;

	@FindBy(xpath="//span[contains(text(),'Packages')]")
	WebElement packages;

	@FindBy(xpath="//span[contains(text(),'Tour Packages')]")
	WebElement tourPackage;

	@FindBy(xpath="//span[contains(text(),'Air Packages')]")
	WebElement airPackage;

	@FindBy(xpath="//span[contains(text(),'International Packages')]")
	WebElement inernatonalPackage;


	Actions act=null;
	String parent="";
	public void selectHoliday(String holiday,WebDriver driv) {
		act=new Actions(driv);
		wait=new WebDriverWait(driv,50);
		parent=driv.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(Holidays));
		act.moveToElement(Holidays).moveToElement(SpecialTrains).build().perform();
		if(holiday.equalsIgnoreCase("tourist")) {
			act.moveToElement(touristTrain).click().build().perform();
			//selectTouritTrain(driv);
		}
		else {
			act.moveToElement(maharajExpress).click().build().perform();

		}
	}

	public void tourPackages(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(Holidays));
			act.moveToElement(Holidays).moveToElement(packages).build().perform();
			act.moveToElement(packages).moveToElement(tourPackage).click().build().perform();
			
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			List<WebElement> li=driv.findElements(By.xpath("//div[contains(@class,'sub-filters')]//label"));
			ArrayList<String> actual=new ArrayList<String>();
			for(int i=0;i<li.size();i++)
				actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)["+i+"]")).getText());
			ArrayList<String> expected=new ArrayList<String>();
			expected.add("CHANDIGARH");
			expected.add("DELHI");
			expected.add("DURG");
			expected.add("HYDERABAD");
			expected.add("NANDED");
			expected.add("RENIGUNTA JN");
			expected.add("TIRUPATI");
			expected.add("VIJAYAWADA");


			if(actual.contains(expected)) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{	driv.close();
			driv.switchTo().window(parent);
			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("exception occured in tour package");
		}
	}
	public void airPackages(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(Holidays));
			act.moveToElement(Holidays).moveToElement(packages).build().perform();
			act.moveToElement(packages).moveToElement(airPackage).click().build().perform();
			
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			List<WebElement> li=driv.findElements(By.xpath("//div[contains(@class,'sub-filters')]//label"));
			ArrayList<String> actual=new ArrayList<String>();
			for(int i=0;i<li.size();i++)
				actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)["+i+"]")).getText());
			ArrayList<String> expected=new ArrayList<String>();

			expected.add("DELHI");

			expected.add("HYDERABAD");
			expected.add("INDORE");
			expected.add("KOLKATA");
			expected.add("MUMBAI");


			if(actual.contains(expected)) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{	driv.close();
			driv.switchTo().window(parent);
			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("exception occured in air package");
		}
	}
	public void internationalPackagesValidate(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(Holidays));
			act.moveToElement(Holidays).moveToElement(packages).build().perform();
			act.moveToElement(packages).moveToElement(inernatonalPackage).click().build().perform();
			
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			List<WebElement> li=driv.findElements(By.xpath("//div[contains(@class,'sub-filters')]//label"));
			ArrayList<String> actual=new ArrayList<String>();
			for(int i=0;i<li.size();i++)
				actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)["+i+"]")).getText());
			ArrayList<String> expected=new ArrayList<String>();
			expected.add("BHOPAL");
			expected.add("DELHI");

			expected.add("HYDERABAD");
			expected.add("MUMBAI");
			if(actual.contains(expected)) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{	driv.close();
			driv.switchTo().window(parent);
			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("exception occured in inernational package");
		}
	}
	public void internationalPackages(WebDriver driv) {
		try {
			act=new Actions(driv);
			wait=new WebDriverWait(driv,50);
			parent=driv.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(Holidays));
			act.moveToElement(Holidays).moveToElement(packages).build().perform();
			act.moveToElement(packages).moveToElement(inernatonalPackage).click().build().perform();
			
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			List<WebElement> li=driv.findElements(By.xpath("//div[contains(@class,'sub-filters')]//label"));
			ArrayList<String> actual=new ArrayList<String>();
			for(int i=0;i<li.size();i++)
				actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)["+i+"]")).getText());
			ArrayList<String> expected=new ArrayList<String>();
			expected.add("BHOPAL");
			expected.add("DELHI");

			expected.add("HYDERABAD");
			expected.add("MUMBAI");
			if(actual.contains(expected)) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{	driv.close();
			driv.switchTo().window(parent);
			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("exception occured in inernational package");
		}
	}

	public void selectTouristTrain(WebDriver driv) {


		try {
			System.out.println("Tourist Train");
			selectHoliday("tourist",driv);
			wait=new WebDriverWait(driv,60);
			wait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//div[contains(@class,'sub-filters')]"))));
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);

				}
			}
			ArrayList<String> actual=new ArrayList<String>();
			actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)[1]")).getText());
			actual.add(driv.findElement(By.xpath("(//div[contains(@class,'sub-filters')]//label)[2]")).getText());
			ArrayList<String> expected=new ArrayList<String>();
			expected.add("NANDED");
			expected.add("RENIGUNTA JN");
			if(actual.contains(expected)) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{	driv.close();
			driv.switchTo().window(parent);
			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}

	}
	public void selectMaharajsExpress(WebDriver driv) {
		try {
			System.out.println("Maharajas Express");
			selectHoliday("Maharaj",driv);
			Set<String> allWindows=driv.getWindowHandles();
			for(String child:allWindows) {
				if(!child.equalsIgnoreCase(parent)) {
					driv.switchTo().window(child);
				}
			}
			wait=new WebDriverWait(driv,50);
			wait.until(ExpectedConditions.elementToBeClickable(maharajasEmail));
			if(maharajasEmail.isDisplayed() && maharajasEmail.isEnabled()) {
				driv.close();
				driv.switchTo().window(parent);
			}else
			{driv.close();
			driv.switchTo().window(parent);

			throw new Exception("orgin filters are not displayed");
			}
		}catch(Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
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
	public void verifyHolidays(WebDriver driv) {
		Assert.assertTrue(IsElementDisplayed(Holidays,driv), "Holidays menu displayed successfully");
	}
	public void verifyHolidaysMenu(WebDriver driv) {
		act=new Actions(driv);
		act.moveToElement(Holidays).build().perform();
		Assert.assertTrue(IsElementDisplayed(SpecialTrains,driv), "Special Trains menu displayed successfully");
		Assert.assertTrue(IsElementDisplayed(packages,driv), "Packages menu displayed successfully");
	}
	public void verifySpecialTrainsMenu(WebDriver driv) {
		act=new Actions(driv);
		act.moveToElement(Holidays).moveToElement(SpecialTrains).build().perform();
		Assert.assertTrue(IsElementDisplayed(SpecialTrains,driv), "Special Trains menu displayed successfully");
		Assert.assertTrue(IsElementDisplayed(maharajExpress,driv), "Maharaj Express  menu displayed successfully");
	}


}
