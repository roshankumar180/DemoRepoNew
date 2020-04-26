package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class ViewOpenTaskPage {
	@FindBy(css="input[value='Delete This Task']")
	private @Getter WebElement dltThisTaskBtn;
	
	@FindBy(css="input[value='Delete Task']")
	private @Getter WebElement dltTaskPopup;
	
	public ViewOpenTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
