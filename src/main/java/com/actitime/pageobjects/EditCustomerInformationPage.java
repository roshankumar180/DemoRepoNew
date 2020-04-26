package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class EditCustomerInformationPage {
	@FindBy(css="input[value='Delete This Customer']")
	private @Getter WebElement dltThisCustBtn;
	
	@FindBy(xpath="//input[@value='Delete Customer']")
	private @Getter WebElement dltCustBtnPopup;
	
	public EditCustomerInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
