/*
 * author=Neelesh
 */
package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeature;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TaskTest extends BaseLib{
	
	@Test
	public void createCustomer() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 3, 1);
		String password=eu.readData("sheet1", 3, 2);
		String customerName = eu.readData("sheet1", 3, 3);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		tf.createCustomer(customerName);
		tf.verifyCreateCustomerMsg(customerName);
		tf.logout();
	}
	
	@Test(dependsOnMethods="createCustomer", enabled=false)
	public void deleteCustomer() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 4, 1);
		String password=eu.readData("sheet1", 4, 2);
		String customerName=eu.readData("sheet1", 4, 3);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		tf.deleteCustomer(customerName);
		tf.verifyDeleteCustomerMsg();
		tf.logout();
	}
	
	@Test(dependsOnMethods="createCustomer")
	public void createProject() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 5, 1);
		String password=eu.readData("sheet1", 5, 2);
		String customerName=eu.readData("sheet1", 5, 3);
		String projectName=eu.readData("sheet1", 5, 4);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		tf.createProject(customerName, projectName);
		tf.verifyCreateProjectMsg(projectName);
		tf.logout();
	}
	
	@Test(dependsOnMethods= {"createCustomer", "createProject"}, enabled=false)
	public void deleteProject() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 6, 1);
		String password=eu.readData("sheet1", 6, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		tf.deleteProject();
		tf.verifyDeleteProjectMsg();
		tf.logout();
	}
	
	@Test(dependsOnMethods= {"createCustomer", "createProject"})
	public void createTask() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 7, 1);
		String password=eu.readData("sheet1", 7, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		String customerName=eu.readData("sheet1", 7, 3);
		String projectName=eu.readData("sheet1", 7, 4);
		String taskName=eu.readData("sheet1", 7, 5);
		String date=eu.readData("sheet1", 7, 6);
		tf.createTask(customerName, projectName, taskName, date);
		tf.verifyCreateTaskMsg(customerName, projectName);
		tf.logout();
	}
	
	@Test(dependsOnMethods= {"createCustomer", "createProject", "createTask"}, enabled=false)
	public void deleteTask() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 8, 1);
		String password=eu.readData("sheet1", 8, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		TaskFeature tf=new TaskFeature(driver);
		tf.deleteTask();
		tf.verifyDeleteTaskMsg();
		tf.logout();
	}
}
