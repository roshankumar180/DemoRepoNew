package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class CreateNewUserPage {
	@FindBy(name="username")
	private @Getter WebElement untxtBx;
	
	@FindBy(name="passwordText")
	private @Getter WebElement pswrdTxtBx;
	
	@FindBy(name="passwordTextRetype")
	private @Getter WebElement reTypePswrdTxtBx;
	
	@FindBy(name="firstName")
	private @Getter WebElement fnameTxtBx;
	
	@FindBy(name="lastName")
	private @Getter WebElement lnameTxtBx;
	
	@FindBy(name="email")
	private @Getter WebElement emailTxtBx;
	
	@FindBy(xpath="//input[contains(@value,'Create User')]")
	private @Getter WebElement crtUserBtn;

	public CreateNewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
