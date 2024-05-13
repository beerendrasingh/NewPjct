package com.vtiger.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener , ISuiteListener
{   
	
    public static ExtentTest test;
    //public ExtentSparkReporter spark;
	public  ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======"+result.getMethod().getMethodName()+"====START====");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===STARTED===");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stu
		System.out.println("======"+result.getMethod().getMethodName()+"====END====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "===COMPLETED===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot)BaseClass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, testName+ "_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===FAILED===");
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.SKIP, result.getMethod().getMethodName() + "===SKIPPED===");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		//step : Spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM Test suite Result");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				// Add environment information and create test
				
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","Windows-10");
				report.setSystemInfo("BROWSER", "CHROME-100");
				
			}
	

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		report.flush();
	}
	  


}
