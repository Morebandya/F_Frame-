package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Assist {
	
	//Screenshots, alerts,Frames,windows,Sync issue, JavaScript executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String screenshotpath=System.getProperty("user.dir")+"./Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
	 
	 try {
		   
		FileHandler.copy(src, new File(screenshotpath));
		
		System.out.println("Screenshot Captured");
		
	} catch (IOException e) {
		
	 System.out.println("Unable to Captured Screenshots" +e.getMessage());	
	}
	    return screenshotpath;
		
	}
	
	public  static String getCurrentDateTime()
	{
	  
		DateFormat Customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date Currentdate=new Date();
		
	    return Customformat.format(Currentdate);
		
		
		
		
		
	}

}
