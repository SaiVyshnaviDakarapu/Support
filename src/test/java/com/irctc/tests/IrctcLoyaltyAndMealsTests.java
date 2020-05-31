package com.irctc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.pages.IrctcHomePage;
import com.irctc.pages.IrctcLoyaltyAndMealsPage;
import com.irctc.utils.SeleniumWebDriver;

public class IrctcLoyaltyAndMealsTests {
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
	public void LoyaltySbiTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.irctcSbiCard(driv);
	}
	@Test(priority=2)
	public void LoyaltySbiPlatinumTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.irctcSbiPlatinumCard(driv);
	}
	@Test(priority=3)
	public void ValidateLoyaltySbiPlatinumTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.validateSbiPlatinumCardFields(driv);
	}
	
	@Test(priority=4)
	public void MealsTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.verifyMealsMenu(driv);
	}
	@Test(priority=5)
	public void LoyaltyTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.verifyLoyaltyMenu(driv);
	}
	@Test(priority=6)
	public void ValidateECateringPage() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.ValidateEcartingFileds(driv);
	}
	@Test(priority=7)
	public void ValidateStandardMenuPage() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.ValidateStandardmenuRates(driv);
	}
	@Test(priority=8)
	public void ValidateStandardMenuPageTest() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.standardmenuRatesValidate(driv);
	}
	@Test(priority=9)
	public void MealsValidateTests() {
		IrctcLoyaltyAndMealsPage ilm=PageFactory.initElements(driv, IrctcLoyaltyAndMealsPage.class);
		ilm.mealsMenu(driv);
	}
	@AfterSuite
	public void closeApp() {
		swd.closeDriver();
	}

}
