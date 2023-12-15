package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.Assist;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger; 
	
	
	@BeforeSuite
	public void setUpSuit()
	{
		Reporter.log("Setup the reports and Test is getting ready",true);
		
	   excel=new ExcelDataProvider();
	   config=new ConfigDataProvider();
	   
	   ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") +"/Reports/FreeCRM_"+Assist.getCurrentDateTime()+".html"));
	   report = new ExtentReports();
	   report.attachReporter(extent);
	   
	   Reporter.log("Setup Done- Test Can be Started", true);
    }
   
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start the browser and application ready ", true);
		
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		
		Reporter.log("Browser and Application are startup and running", true);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
    }
		
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		
	    if(result.getStatus() == ITestResult.FAILURE) 
	    {
		// Assist.captureScreenshot(driver);	
		logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Assist.captureScreenshot(driver)).build());	
	    }
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Assist.captureScreenshot(driver)).build());	
		}
	 
	     report.flush();
	     
	     Reporter.log("Tested Completed>>>> Report Generated", true);
	     
	     }	
	} 
	

	





