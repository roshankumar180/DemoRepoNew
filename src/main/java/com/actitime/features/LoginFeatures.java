package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginFeatures {
	WebDriver driver;
	LoginPage lp;
	EnterTimeTrackPage ettp;
	
	public LoginFeatures(WebDriver driver) {
		this.driver=driver;
		lp=new LoginPage(driver);
		ettp=new EnterTimeTrackPage(driver);
	}
	
	public void login(String userName, String password){
		lp.getUnTxtBx().sendKeys(userName);
		lp.getPwdTxtBx().sendKeys(password);
		lp.getLgnBtn().click();
	}
	
	public void verifyValidLoginMsg() {
		String expected="Enter Time-Track";
		String actual=ettp.getPgTitle().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Home Page Title is verified", true);
	}
	
	public void verifyInvalidLoginMsg() {
		String expected="Username or Password is invalid. Please try again.";
		String actual=lp.getErrorMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Invalid Login Message is verified", true);
	}
}

