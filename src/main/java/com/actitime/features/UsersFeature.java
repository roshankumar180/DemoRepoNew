package com.actitime.features;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.actitime.pageobjects.CreateNewUserPage;
import com.actitime.pageobjects.EditUserSettingsPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UsersListPage;

public class UsersFeature {
	WebDriver driver;
	EnterTimeTrackPage ettp;
	UsersListPage ulp;
	CreateNewUserPage cnup;
	LoginPage lp;
	EditUserSettingsPage eusp;
	
	public UsersFeature(WebDriver driver) {
		this.driver=driver;
		ettp=new EnterTimeTrackPage(driver);
		ulp=new UsersListPage(driver);
		cnup=new CreateNewUserPage(driver);
		lp=new LoginPage(driver);
		eusp=new EditUserSettingsPage(driver);
	}
	
	public void logOut() {
		ettp.getLgtLink().click();
	}
	
	public void createNewUser(String username1, String password1, String rePassword, String fname, String lname, String email ) {
		ettp.getUsersBtn().click();
		ulp.getCrtNewuserBtn().click();
		cnup.getUntxtBx().sendKeys(username1);
		cnup.getPswrdTxtBx().sendKeys(password1);
		cnup.getReTypePswrdTxtBx().sendKeys(rePassword);
		cnup.getFnameTxtBx().sendKeys(fname);
		cnup.getLnameTxtBx().sendKeys(lname);
		cnup.getEmailTxtBx().sendKeys(email);
		cnup.getCrtUserBtn().click();
	}
	
	public void verifyCreateNewUserMsg() {
		String expected="User account has been successfully created.";
		String actual=ulp.getSucMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
	
	public void deleteNewUser() {
		ettp.getUsersBtn().click();
		ulp.getUserLink().click();
		eusp.getDltThisUserBtn().click();
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	
	public void verifyDeleteUserMsg() {
		String expected="User account has been successfully deleted.";
		String actual=ulp.getSucMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
}

