package com.irctc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.pages.IrctcHomePage;
import com.irctc.pages.IrctcLoginPage;
import com.irctc.utils.SeleniumWebDriver;

public class IrctcLoginTests {
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
		//System.out.println(driv);
		ihp.clickOnCovidAlertButton(driv);
		ihp.clickOnLoginLink(driv);
		Thread.sleep(5000);
		
	}
	@Test(priority=1)
	public void ValidateLoginScreen() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.verifyLoginScreen(driv);
		}catch(Exception e) {
			
		}
	}
	@Test(priority=3)
	public void IrctcLogin() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.loginWithCredentials(driv);
		}catch(Exception e) {
			
		}
	}
	@Test(priority=2)
	public void IrctcLoginError() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.verifyLoginError(driv);;
		}catch(Exception e) {
			
		}
	}
	@Test(priority=6)
	public void IrctcLoginRegister() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.validateRegisterLink(driv);
		}catch(Exception e) {
			
		}
	}
	@Test(priority=7)
	public void IrctcLoginAgentTest() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			driv.navigate().back();
			System.out.println("click on login link");
			ihp.clickOnLoginLink(driv);
			
			ilp.validateAgentLink(driv);
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}
	@Test(priority=7)
	public void IrctcLoginAgentvalidateTest() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			driv.navigate().back();
			System.out.println("click on login link");
			ihp.clickOnLoginLink(driv);
			
			ilp.validateAgentLink(driv);
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}

	@Test(priority=4)
	public void ValidateForgotPasswordLinkTest() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.validateForgotpasswordLink(driv);
		}catch(Exception e) {
			
		}
	}
	@Test(priority=5)
	public void ValidateForgotUserIdLinkTest() {
		try {
			IrctcLoginPage ilp= PageFactory.initElements(driv, IrctcLoginPage.class);
			ilp.validateForgotuserIdLink(driv);
		}catch(Exception e) {
			
		}
	}
	@AfterSuite
	public void closeApp() {
		swd.closeDriver();
	}

}
