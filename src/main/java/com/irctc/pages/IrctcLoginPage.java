package com.irctc.pages;

import java.awt.Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IrctcLoginPage {
	
	@FindBy(xpath="//input[@id='userId']")
	WebElement user;
	@FindBy(xpath="//input[@id='pwd']")
	WebElement password;
	@FindBy(xpath="//label[contains(@id,'recaptcha-anchor-label')]")
	WebElement captcha;
	@FindBy(xpath="//button[contains(text(),'SIGN IN')]")
	WebElement signIn;
	@FindBy(xpath="//div[@class='loginError']")
	WebElement loginError;
	@FindBy(xpath="//div[@class='irmodal']//a[contains(text(),'REGISTER')]")
	WebElement registerLink;
	@FindBy(xpath="//div[contains(text(),'Individual Registration')]")
	WebElement registrationHeader;
	@FindBy(xpath="//div[@class='irmodal']//a[contains(text(),'AGENT LOGIN')]")
	WebElement agentLink;
	@FindBy(xpath="//h1[contains(text(),'The Page Requires a Client Certificate')]")
	WebElement agentHeader;
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement forgotPassword;
	@FindBy(xpath="//a[contains(text(),'Forgot User ID')]")
	WebElement forgotUserId;
	
	WebDriverWait wait=null;
	
	public boolean isUserIdDisplayed(WebDriver driv) {
		//wait=new WebDriverWait(driv,50);
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(user));
		if(user.isDisplayed() && user.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isForgotPasswordDisplayed(WebDriver driv) {
		//wait=new WebDriverWait(driv,50);
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(forgotPassword));
		if(forgotPassword.isDisplayed() && forgotPassword.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isForgotUserIdDisplayed(WebDriver driv) {
		//wait=new WebDriverWait(driv,50);
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(forgotUserId));
		if(forgotUserId.isDisplayed() && forgotUserId.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isPasswordDisplayed(WebDriver driv) {
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		if(password.isDisplayed() && password.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public boolean isSignInDisplayed(WebDriver driv) {
		boolean flag=false;
		wait=new WebDriverWait(driv,50);
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		if(signIn.isDisplayed() && signIn.isEnabled()) {
			flag=true;
		}
		return flag;
	}
	public void verifyLoginScreen(WebDriver driv) {
		System.out.println("Login screen validation");
		Assert.assertTrue(isUserIdDisplayed(driv), "Userid displayed successfully");
		Assert.assertTrue(isPasswordDisplayed(driv), "Password displayed successfully");
		Assert.assertTrue(isSignInDisplayed(driv), "Signin displayed successfully");
	}
	public void loginWithCredentials(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		user.sendKeys("SVysshnavi");
		password.sendKeys("SVyshu2208");
		Thread.sleep(2000);
//		String frameName=driv.findElement(By.xpath("//iframe")).getAttribute("name");
//		System.out.println("Frame name: "+frameName);
//		driv.switchTo().frame(driv.findElement(By.xpath("//iframe[@name='"+frameName+"']]")));
//		Thread.sleep(2000);
//		captcha.click();
//		driv.switchTo().defaultContent();
//		Thread.sleep(2000);
		//signIn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void verifyLoginError(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		user.clear();
		password.clear();
		Thread.sleep(5000);
		signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(loginError));
		System.out.println("Loggin error:: "+loginError.getText());
		Assert.assertEquals("Please Enter Valid User ID",loginError.getText() );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void validateRegisterLink(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(registrationHeader));
		System.out.println("registrationHeader:: "+registrationHeader.getText());
		Assert.assertEquals("Individual Registration",registrationHeader.getText() );
		//driv.navigate().back();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public void validateAgentLink(WebDriver driv) {
		wait=new WebDriverWait(driv,50);
		try {
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(agentLink));
		agentLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(agentHeader));
		System.out.println("agentHeader:: "+agentHeader.getText());
		Assert.assertEquals("The Page Requires a Client Certificate",agentHeader.getText() );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public void validateForgotpasswordLink(WebDriver driv) {
		Assert.assertTrue(isForgotPasswordDisplayed(driv), "Forgot password link displayed successfully");
	
	}
	public void validateForgotuserIdLink(WebDriver driv) {
		Assert.assertTrue(isForgotUserIdDisplayed(driv), "Forgot user id displayed displayed successfully");
	
	}

}
