package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNgListener implements ITestListener{
	public static int executionCount, passCount, failCount, skipCount=0;
	
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" Suite Execution is start "+ new Date(), true);
	}
	
	public void TestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName()+" Script Execution is start "+new Date(), true);
	}
	
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName()+" Script Result is passed", true);
	}
	
	public void onTestSkip(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName()+" Script Result is skip", true);
	}
	
	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+" Script is fail", true);
		TakesScreenshot ts=(TakesScreenshot)BaseLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot"+ result.getName()+ ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("screenshot has been taken", true);
	}
	
	public void onFinish(ITestContext context) {
		Reporter.log("Total Scripts are executed: "+executionCount++);
		Reporter.log("Total Scripts are passed: "+passCount++);
		Reporter.log("Total Scripts are skipped: "+skipCount++);
		Reporter.log("Total Scripts are Failed: "+failCount++);
	}
}

