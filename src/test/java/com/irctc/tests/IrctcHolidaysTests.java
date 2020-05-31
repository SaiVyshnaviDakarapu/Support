package com.irctc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.pages.IrctcHolidaysMenuPage;
import com.irctc.pages.IrctcHomePage;
import com.irctc.utils.SeleniumWebDriver;

public class IrctcHolidaysTests {
	WebDriver driv=null;
	SeleniumWebDriver swd=new SeleniumWebDriver();
	IrctcHomePage ihp=new IrctcHomePage();
	@BeforeSuite
	public void lauchingApp() {
		driv=SeleniumWebDriver.driverInitialization();
		System.out.println(driv);
	}
	@Test(priority=0)
	public void HomePageTest() throws InterruptedException {
		ihp= PageFactory.initElements(driv, IrctcHomePage.class);
		System.out.println("Title:: "+driv.getTitle());
		Assert.assertEquals("IRCTC Next Generation eTicketing System", driv.getTitle());
		
		ihp.clickOnCovidAlertButton(driv);
		
		
	}
	@Test(priority=1)
	public void ValidateHolidaysMenuTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		System.out.println("Title:: "+driv.getTitle());
		Assert.assertEquals("IRCTC Next Generation eTicketing System", driv.getTitle());
		
		iholp.verifyHolidays(driv);
		iholp.verifyHolidaysMenu(driv);
		iholp.verifySpecialTrainsMenu(driv);
		
		
	}
	@Test(priority=2)
	public void IrctcHolidaysTouristTrainTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		
	}
	@Test(priority=3)
	public void IrctcHolidaysMaharajasExpressTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		//iholp.selectMaharajsExpress(driv);
		
		
	}
	@Test(priority=4)
	public void IrctcHolidaysTourPackagesTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		iholp.tourPackages(driv);
		
		
	}
	@Test(priority=5)
	public void IrctcHolidaysAirPackagesTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		iholp.airPackages(driv);
		
		
	}
	@Test(priority=6)
	public void IrctcHolidaysInternationalPackagesTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		iholp.internationalPackages(driv);
		
		
	}
	@Test(priority=7)
	public void validateIrctcHolidaysInternationalPackagesTest() throws InterruptedException {
		IrctcHolidaysMenuPage iholp= PageFactory.initElements(driv, IrctcHolidaysMenuPage.class);
		
		iholp.internationalPackagesValidate(driv);
		
		
	}
	@AfterSuite
	public void closeApp() {
		swd.closeDriver();
	}

	
	

}
