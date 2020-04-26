package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class CreateNewTasksPage {
	@FindBy(name="customerId")
	private @Getter WebElement custDrpDwn;
	
	@FindBy(name="projectId")
	private @Getter WebElement proDrpDwn;
	
	@FindBy(xpath="//td[@class='listtblcell']//input[@name='task[0].name']")
	private @Getter WebElement tskNameTxtBx;
	
	@FindBy(id="taskDeadline0")
	private @Getter WebElement dateField;
	
	@FindBy(name="task[0].billingType")
	private @Getter WebElement bilTypeDrpDwn;
	
	@FindBy(name="task[0].markedToBeAddedToUserTasks")
	private @Getter WebElement chkBx;
	
	@FindBy(css="input[value='Create Tasks']")
	private @Getter WebElement crtTaskBtn;
	
	public CreateNewTasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
