package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class EditProjectInformationPage {
	@FindBy(css="input[value='Delete This Project']")
	private @Getter WebElement dltThisProBtn;
	
	@FindBy(css="input[value='Delete Project']")
	private @Getter WebElement dltProBtnPopup;
	
	public EditProjectInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
