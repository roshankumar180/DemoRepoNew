package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class CreateNewProjectPage {
	@FindBy(name="customerId")
	private @Getter WebElement custDrpDwn;
	
	@FindBy(name="name")
	private @Getter WebElement proNameTxtBx;
	
	@FindBy(name="createProjectSubmit")
	private @Getter WebElement crtProSubmitBtn;
	
	public CreateNewProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
