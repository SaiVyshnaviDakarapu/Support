package com.irctc.tests;

import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import com.irctc.utils.SeleniumWebDriver;

import com.irctc.pages.*;;

public class IrctcHomePageTests {
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
		IrctcHomePage ihp= PageFactory.initElements(driv, IrctcHomePage.class);
		System.out.println("Title:: "+driv.getTitle());
		Assert.assertEquals("IRCTC Next Generation eTicketing System", driv.getTitle());
		//System.out.println(driv);
		ihp.clickOnCovidAlertButton(driv);
		Thread.sleep(5000);
		
	}
	@Test(priority=1)
	public void ValidateBookYourWidget()throws InterruptedException {
		IrctcBookYourTicketPage byt= PageFactory.initElements(driv, IrctcBookYourTicketPage.class);
		//System.out.println(driv);
		byt.verifyBookYourTicketWidget(driv);;
		byt.verifPnrStatus(driv);
		byt.verifyChartsVacancy(driv);
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void BookYourWidget()throws InterruptedException {
		IrctcBookYourTicketPage byt= PageFactory.initElements(driv, IrctcBookYourTicketPage.class);
		
		byt.fillDetails(driv);;
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void BookYourWidgetError()throws InterruptedException {
		IrctcBookYourTicketPage byt= PageFactory.initElements(driv, IrctcBookYourTicketPage.class);
		//System.out.println(driv);
		byt.fillDetails(driv);;
		Thread.sleep(5000);
	}
	@Test(priority=4)
//	@Test(priority=1)
	public void PnrStatusPage()throws InterruptedException {
		IrctcBookYourTicketPage byt= PageFactory.initElements(driv, IrctcBookYourTicketPage.class);
		//System.out.println(driv);
		byt.clickOnPnrStatus(driv);;
		IrctcPnrStatusPage psp=PageFactory.initElements(driv, IrctcPnrStatusPage.class);
		psp.switcToPnrWindow(driv);
		Thread.sleep(5000);
		
	}
	@Test(priority=5)
//	//@Test(priority=2)
	public void validatePnrStatusPage()throws InterruptedException {
		
		IrctcPnrStatusPage psp=PageFactory.initElements(driv, IrctcPnrStatusPage.class);
		psp.verifyPnrPageTitle(driv);
		Thread.sleep(5000);
		
	}
	@Test(priority=6)
//	@Test(priority=1)
	public void ChartVacanciesPage()throws InterruptedException {
		IrctcBookYourTicketPage byt= PageFactory.initElements(driv, IrctcBookYourTicketPage.class);
		//System.out.println(driv);
		byt.clickOnChartStatus(driv);;
		IrctcPnrStatusPage psp=PageFactory.initElements(driv, IrctcPnrStatusPage.class);
		psp.switcToPnrWindow(driv);
		Thread.sleep(5000);
		
	}
	@Test(priority=7)
//	@Test(priority=2)
	public void validateChartVacanciesPage()throws InterruptedException {
		
		IrctcChartVacanciesPage cvp=PageFactory.initElements(driv, IrctcChartVacanciesPage.class);
		cvp.verifyChartVacanciesPageTitle(driv);
		Thread.sleep(5000);
		
	}
	
	@Test(priority=8)
	public void GetChartDetails() {
		IrctcChartVacanciesPage cvp=PageFactory.initElements(driv, IrctcChartVacanciesPage.class);
		cvp.EnterTrainDetails(driv);
		//Thread.sleep(5000);
	}
	@AfterSuite
	public void closeApp() {
		swd.closeDriver();
	}
}
