package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class ActiveProCustPage {
	@FindBy(xpath="//input[@value='Create New Customer']")
	private @Getter WebElement crtNewCustBtn;
	
	@FindBy(css="span[class='successmsg']")
	private @Getter WebElement sucsMsg;
	
	@FindBy(name="selectedCustomer")
	private @Getter WebElement custDrpDwn;
	
	@FindBy(xpath="//input[contains(@value,'Show')]")
	private @Getter WebElement showBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'customer')]//a[contains(@href,'customeredit')]")
	private @Getter WebElement custNameLink;
	
	@FindBy(css="input[value='Create New Project']")
	private @Getter WebElement crtNewProBtn;
	
	@FindBy(xpath="//td[contains(@id,'projectName')]//a[contains(@href,'projectedit')]")
	private @Getter WebElement proNameLink;
	
	public ActiveProCustPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
