package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class UsersListPage {
	@FindBy(xpath="//span[text()='Create New User']")
	private @Getter WebElement crtNewuserBtn;
	
	@FindBy(className="successmsg")
	private @Getter WebElement sucMsg;
	
	@FindBy(xpath="(//td[contains(@class,'userNameTableCell')]//a[contains(@href,'useredit')])[1]")
	private @Getter WebElement userLink;
	
	public UsersListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
