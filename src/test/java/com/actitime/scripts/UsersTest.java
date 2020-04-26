/*
 * author="ebix"
 */
package com.actitime.scripts;

import org.testng.annotations.Test;
import com.actitime.features.LoginFeatures;
import com.actitime.features.UsersFeature;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class UsersTest extends BaseLib {
	
	@Test
	public void createNewUser() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 9, 1);
		String password=eu.readData("sheet1", 9, 2);
		String username1=eu.readData("sheet1", 9, 3);
		String password1=eu.readData("sheet1", 9, 4);
		String rePassword=eu.readData("sheet1", 9, 5);
		String fname=eu.readData("sheet1", 9, 6);
		String lname=eu.readData("sheet1", 9, 7);
		String email=eu.readData("sheet1", 9, 8);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		UsersFeature uf=new UsersFeature(driver);
		uf.createNewUser(username1, password1, rePassword, fname, lname, email);
		uf.verifyCreateNewUserMsg();
	}
	
	@Test(dependsOnMethods= {"createNewUser"})
	public void loginNewUser() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 10, 1);
		String password=eu.readData("sheet1", 10, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		lf.verifyValidLoginMsg();
		UsersFeature uf=new UsersFeature(driver);
		uf.logOut();
	}
	
	@Test(dependsOnMethods= {"createNewUser", "loginNewUser"})
	public void deleteNewUser() {
		ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		String userName=eu.readData("sheet1", 11, 1);
		String password=eu.readData("sheet1", 11, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.login(userName, password);
		UsersFeature uf=new UsersFeature(driver);
		uf.deleteNewUser();
		uf.verifyDeleteUserMsg();
		uf.logOut();
	}
}
