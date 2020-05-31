package com.irctc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.pages.IrctcHomePage;
import com.irctc.pages.IrctcStaysPage;
import com.irctc.utils.SeleniumWebDriver;

public class IrctcStaysTests {
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
	public void IrctcvalidateStaysMenuTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Lounge");
		isp.verifyStaysMenu(driv);
	}
	@Test(priority=2)
	public void HotelsTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Hotel");
		isp.hotels(driv);
	}
	@Test(priority=3)
	public void IrctcValidateHotelFieldsTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Validatio Hotel fileds");
		isp.validadteHotelFields(driv);
	}
	@Test(priority=4)
	public void IrctcReitingRoomTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Retiring rooms");
		isp.retiringRooms(driv);
	}
	
	@Test(priority=5)
	public void IrctcLoungeTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Lounge");
		isp.lounge(driv);
	}
	@Test(priority=6)
	public void IrctcValidateLoungeFieldsTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Lounge fields validation");
		isp.validadteloungeFields(driv);
	}
	@Test(priority=7)
	public void IrctcReitingRoomValidateTest() {
		IrctcStaysPage isp= PageFactory.initElements(driv, IrctcStaysPage.class);
		System.out.println("Lounge fields validation");
		isp.retiringRoomsValidation(driv);
	}
	@AfterSuite
	public void closeApp() {
		swd.closeDriver();
	}
}
