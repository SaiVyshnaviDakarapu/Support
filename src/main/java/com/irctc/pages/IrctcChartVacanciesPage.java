package com.irctc.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcChartVacanciesPage {
	WebDriverWait wait=null;

	@FindBy(xpath="//h6[contains(text(),'RESERVATION CHART')]")
	WebElement chartHeader;

	@FindBy(xpath="//div[contains(text(),'Train Name/Number*')]//following::input[1]")
	WebElement trainNumber;

	@FindBy(xpath="//div[@id='boardingStation']")
	WebElement boardingStation;

	@FindBy(xpath="//span[contains(text(),'Get Train Chart')]")
	WebElement getTrainChart;
	
	@FindBy(xpath="//span[contains(text(),'Train Cancelled.')]")
	WebElement trainCancelled;
	//12709 - SIMHAPURI EXP
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
	public void EnterTrainDetails(WebDriver driv) {
		try {
			//switcToPnrWindow(driv);
			System.out.println("Enter the train details");
			wait=new WebDriverWait(driv,50);
			wait.until(ExpectedConditions.elementToBeClickable(trainNumber));
			//trainNumber.click();
			System.out.println("Enter the train number");
			trainNumber.sendKeys("12709");
			Thread.sleep(3000);
			String trainDetails="12709 - SIMHAPURI EXP";
			String option="//div[contains(text(),'"+trainDetails+"')]";
			wait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath(option))));
			System.out.println("select the train ");
			driv.findElement(By.xpath(option)).click();
			Thread.sleep(3000);
			boardingStation.click();
			String station="NELLORE (NLR)";;
			String boardingStat="//div[contains(text(),'"+station+"')]";
			wait.until(ExpectedConditions.elementToBeClickable(driv.findElement(By.xpath(boardingStat))));
			System.out.println("select the train ");
			driv.findElement(By.xpath(boardingStat)).click();
			Thread.sleep(3000);
			getTrainChart.click();
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(trainCancelled));
			System.out.println("Train cancelled text:: "+trainCancelled.getText());
			Assert.assertEquals("Train Cancelled.", trainCancelled.getText());
			driv.close();
			driv.switchTo().window(parent);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void verifyChartVacanciesPageTitle(WebDriver driv) {
		try {
			wait=new WebDriverWait(driv,50);
			wait.until(ExpectedConditions.elementToBeClickable(chartHeader));
			System.out.println("Page title:: "+driv.getTitle());
			Thread.sleep(3000);
			//driv.close();
			//driv.switchTo().window(parent);
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Exception occured in pnr page");
		}

	}


}
