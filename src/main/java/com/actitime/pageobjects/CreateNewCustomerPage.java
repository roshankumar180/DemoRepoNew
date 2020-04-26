package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class CreateNewCustomerPage {
	@FindBy(name="name")
	private @Getter WebElement custNameTxtBx;
	
	@FindBy(name="createCustomerSubmit")
	private @Getter WebElement crtCustBtn;
	
	public CreateNewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
