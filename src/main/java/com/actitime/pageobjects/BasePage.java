package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

abstract public class BasePage {
	@FindBy(xpath="//div[text()='Tasks']")
	private @Getter WebElement tskBtn;
	
	@FindBy(xpath="//div[text()='Users']")
	private @Getter WebElement UsersBtn;
	
	@FindBy(id="logoutLink")
	private @Getter WebElement lgtLink;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
