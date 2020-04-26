package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class OpenTaskPage {
	@FindBy(xpath="//a[text()='Projects & Customers']")
	private @Getter WebElement ProCustLink;
	
	@FindBy(css="input[value='Create New Tasks']")
	private @Getter WebElement crtNewTaskbtn;
	
	@FindBy(className="successmsg")
	private @Getter WebElement sucMsg;
	
	@FindBy(xpath="//a[contains(@href,'taskId')]")
	private @Getter WebElement tskLink;
	
	public OpenTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
