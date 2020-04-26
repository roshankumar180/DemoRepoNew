package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.actitime.pageobjects.ActiveProCustPage;
import com.actitime.pageobjects.CreateNewCustomerPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EditCustomerInformationPage;
import com.actitime.pageobjects.EditProjectInformationPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.pageobjects.ViewOpenTaskPage;

public class TaskFeature {
	WebDriver driver;
	EnterTimeTrackPage ettp;
	OpenTaskPage otp;
	ActiveProCustPage apcp;
	CreateNewCustomerPage cncp;
	EditCustomerInformationPage ecip;
	CreateNewProjectPage cnpp;
	EditProjectInformationPage epip;
	CreateNewTasksPage cntp;
	ViewOpenTaskPage votp;
	
	public TaskFeature(WebDriver driver) {
		this.driver=driver;
		ettp=new EnterTimeTrackPage(driver);
		otp=new OpenTaskPage(driver);
		apcp=new ActiveProCustPage(driver);
		cncp=new CreateNewCustomerPage(driver);
		ecip=new EditCustomerInformationPage(driver);
		cnpp=new CreateNewProjectPage(driver);
		epip=new EditProjectInformationPage(driver);
		cntp=new CreateNewTasksPage(driver);
		votp=new ViewOpenTaskPage(driver);
	}
	
	public void logout() {
		ettp.getLgtLink().click();
	}
	
	public void createCustomer(String customerName) {
		ettp.getTskBtn().click();
		otp.getProCustLink().click();
		apcp.getCrtNewCustBtn().click();
		cncp.getCustNameTxtBx().sendKeys(customerName);
		cncp.getCrtCustBtn().click();
	}
	
	public void verifyCreateCustomerMsg(String customerName) {
		String expected="Customer \""+customerName+"\" has been successfully created.";
		String actual=apcp.getSucsMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
	
	public void deleteCustomer(String customerName) {
		ettp.getTskBtn().click();
		otp.getProCustLink().click();
		Select sel1=new Select(apcp.getCustDrpDwn());
		sel1.selectByVisibleText(customerName);
		apcp.getShowBtn().click();
		apcp.getCustNameLink().click();
		ecip.getDltThisCustBtn().click();
		ecip.getDltCustBtnPopup().click();
	}
	
	public void verifyDeleteCustomerMsg() {
		String expected="Customer has been successfully deleted.";
		String actual=apcp.getSucsMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
	
	public void createProject(String customerName, String projectName) {
		ettp.getTskBtn().click();
		otp.getProCustLink().click();
		apcp.getCrtNewProBtn().click();
		Select sel2=new Select(cnpp.getCustDrpDwn());
		sel2.selectByVisibleText(customerName);
		cnpp.getProNameTxtBx().sendKeys(projectName);
		cnpp.getCrtProSubmitBtn().click();
	}
	
	public void verifyCreateProjectMsg(String projectName) {
		String expected="Project \""+projectName+"\" has been successfully created.";
		String actual=apcp.getSucsMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
	
	public void deleteProject() {
		ettp.getTskBtn().click();
		otp.getProCustLink().click();
		apcp.getProNameLink().click();
		epip.getDltThisProBtn().click();
		epip.getDltProBtnPopup().click();
	}
	
	public void verifyDeleteProjectMsg() {
		String expected="Project has been successfully deleted.";
		String actual=apcp.getSucsMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true); 
	}
	
	public void createTask(String customerName, String projectName, String taskName, String date) {
		ettp.getTskBtn().click();
		otp.getCrtNewTaskbtn().click();
		Select sel3=new Select(cntp.getCustDrpDwn());
		sel3.selectByVisibleText(customerName);
		Select sel4=new Select(cntp.getProDrpDwn());
		sel4.selectByVisibleText(projectName);
		cntp.getTskNameTxtBx().sendKeys(taskName);
		cntp.getDateField().sendKeys(date);
		Select sel5=new Select(cntp.getBilTypeDrpDwn());
		sel5.selectByIndex(1);
		cntp.getChkBx().click();
		cntp.getCrtTaskBtn().click();
	}
	
	public void verifyCreateTaskMsg(String customerName, String projectName) {
		String expected="1 new task was added to the customer \""+customerName+"\", project \""+projectName+"\".";
		String actual=otp.getSucMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
	
	public void deleteTask() {
		ettp.getTskBtn().click();
		otp.getTskLink().click();
		votp.getDltThisTaskBtn().click();
		votp.getDltTaskPopup().click();
	}
	
	public void verifyDeleteTaskMsg() {
		String expected="Task has been successfully deleted.";
		String actual=otp.getSucMsg().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log(expected, true);
	}
}
