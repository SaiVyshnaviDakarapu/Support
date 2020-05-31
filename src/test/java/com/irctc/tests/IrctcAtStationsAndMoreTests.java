package com.irctc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.pages.IrctcAtStationsAndMorePage;
import com.irctc.pages.IrctcHomePage;
import com.irctc.utils.SeleniumWebDriver;

public class IrctcAtStationsAndMoreTests {
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
	public void validateAtStationsMenuTest() {
		IrctcAtStationsAndMorePage iasmp= PageFactory.initElements(driv, IrctcAtStationsAndMorePage.class);
		iasmp.ValidateAtStationsMenu(driv);
	}
	@Test(priority=2)
	public void wifirailwayStationsTest() {
		IrctcAtStationsAndMorePage iasmp= PageFactory.initElements(driv, IrctcAtStationsAndMorePage.class);
		iasmp.WifiRailwayStations(driv);
	}
	@Test(priority=3)
	public void batteryOperatedCarsTest() {
		IrctcAtStationsAndMorePage iasmp= PageFactory.initElements(driv, IrctcAtStationsAndMorePage.class);
		iasmp.batteryOperatedCars(driv);
	}
	@Test(priority=4)
	public void eWheelChairTest() {
		IrctcAtStationsAndMorePage iasmp= PageFactory.initElements(driv, IrctcAtStationsAndMorePage.class);
		iasmp.eWheelchair(driv);
	}
	@Test(priority=5)
	public void validateMoreMenuTest() {
		IrctcAtStationsAndMorePage iasmp= PageFactory.initElements(driv, IrctcAtStationsAndMorePage.class);
		iasmp.validateMoreMenu(driv);
	}
	
	
}
