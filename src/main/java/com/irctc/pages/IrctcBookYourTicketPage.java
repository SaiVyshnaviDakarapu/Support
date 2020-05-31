package com.irctc.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcBookYourTicketPage {
	
	@FindBy(xpath="//input[contains(@placeholder,'From')]")
	WebElement from;
	
	@FindBy(xpath="//input[contains(@placeholder,'To')]")
	WebElement to;
	
	@FindBy(xpath="//input[contains(@placeholder,'Journey Date')]")	
    WebElement date;
	
	@FindBy(xpath="//label[contains(text(),'All Classes')]")
	WebElement allClasses;
	
	@FindBy(xpath="//button[contains(text(),'Find trains')]")
	WebElement findTrains;
	
	@FindBy(xpath="//label[contains(text(),'PNR STATUS')]")
	WebElement pnrStatus;
	
	@FindBy(xpath="//label[contains(text(),'CHARTS')]")
	WebElement chartVacancies;
	
	@FindBy(xpath="(//div[contains(text(),' Station is required')])[1]")
	WebElement stationRequired;
	
	
	WebDriverWait wait=null;
	String pattern = "MM-dd-yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String dt= simpleDateFormat.format(new Date());
	
	
	public void verifyBookYourTicketWidget(WebDriver driv) {
		String book=driv.findElement(By.xpath("//label[contains(text(),'BOOK')]")).getText();
		String yourTrain=driv.findElement(By.xpath("//label[contains(text(),'BOOK')]/span")).getText();
		System.out.println("Widget title:: "+yourTrain);
		System.out.println("Book title:: "+book);
		//Assert.assertEquals("BOOK YOUR TICKET", book.trim());
	}
	public boolean isPnrStatusDisplayed(WebDriver driv) {
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(pnrStatus));
		if(pnrStatus.isDisplayed() && pnrStatus.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isChartsDisplayed(WebDriver driv) {
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(chartVacancies));
		if(chartVacancies.isDisplayed() && chartVacancies.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isElementDisplayed(WebElement we,WebDriver driv) {
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(we));
		if(we.isDisplayed() && we.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public void verifPnrStatus(WebDriver driv) {
		Assert.assertTrue(isPnrStatusDisplayed(driv), "PNR status displayed successfully");
	}
	public void verifyChartsVacancy(WebDriver driv) {
		Assert.assertTrue(isChartsDisplayed(driv), "Charts/Vacancies displayed successfully");	
	}
	public void BookWidgetError(WebDriver driv) {
		try {
			wait=new WebDriverWait(driv,50);
			wait.until(ExpectedConditions.elementToBeClickable(from));
			findTrains.click();
			Assert.assertTrue(isElementDisplayed(stationRequired,driv), "Charts/Vacancies displayed successfully");
		}catch(Exception e) {
			
		}
	}
	public void fillDetails(WebDriver driv) {
		try {
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(from));
		from.clear();
		try {
			 
			 wait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath("//a[@class='fa fa-window-close pull-right']"))));
			 driv.findElement(By.xpath("//a[@class='fa fa-window-close pull-right']")).click();
			 Thread.sleep(5000);
		}
		catch(Exception e) {
			
		}
		from.sendKeys("NELLORE - NLR");
		//String location1="NELLORE - NLR";
		//String location2="KAVALI - KVZ";
		to.clear();
		to.sendKeys("KAVALI - KVZ");	
		System.out.println("date:: "+dt);
		date.clear();
		Thread.sleep(3000);
		date.clear();
		Thread.sleep(3000);
		date.sendKeys(dt);
		allClasses.click();
		String clas="AC First Class (1A)";
		String acClass="//ul[contains(@class,'ui-dropdown-items ui-dropdown-list')]//span[contains(text(),'"+clas+"')]";
		WebElement acClas=driv.findElement(By.xpath(acClass));
		wait.until(ExpectedConditions.elementToBeClickable(acClas));
		Thread.sleep(3000);
		acClas.click();
		}catch(Exception e) {
			System.out.println("Exception occured.....!!!");
			e.printStackTrace();
		}
		
		
	}
	public void clickOnPnrStatus(WebDriver driv) {
		System.out.println("Click on pnr status");
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(pnrStatus));
		pnrStatus.click();
	}
	public void clickOnChartStatus(WebDriver driv) {
		System.out.println("Click on charts/vacancies");
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(chartVacancies));
		chartVacancies.click();
	}

}
