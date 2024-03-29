package com.learnautomation.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	
	{
	   if(browserName.equals("Chrome"))	
		
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	        driver=new ChromeDriver();	
	}
		
	   else if(browserName.equals("Firefox"))
	   {
         System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
           driver=new FirefoxDriver();
	   }
	   
	   else if(browserName.equals("MSedge"))
		   
	   {
	   System.setProperty("webdriver.msedge.driver","./Drivers/msedgedriver.exe");
	        driver=new EdgeDriver();
	   }
		
	   else
		   
	   {
		   System.out.println("We do not support this Browser");
	   }

	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	   driver.manage().window().maximize();
	   driver.get(appURL);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
	  return driver;
	   
	}

	
	public static void quitBrowser(WebDriver driver)
	
	{
	    driver.quit();	
	}
	
		
		
	}


