package com.learnautomation.testcases;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCaseWithoutFramework { 
	
	
  @Test
  public void test1() throws InterruptedException {
  
  System.setProperty("driver.chrome.driver","H:\\batch12\\All_drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
  
  //ChromeOption co = new ChromeOption();   
   //co.addArguments("remote-allow-origin=*");
  
  WebDriver driver = new ChromeDriver();
  
  //driver.manage().window().maximize();
  
  driver.get("https://classic.freecrm.com/");
  
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  
  driver.findElement(By.name("username")).sendKeys("nilesh123com");
   
  driver.findElement(By.name("password")).sendKeys("selenium_120");
  
  driver.findElement(By.xpath("//input[@value='Login']")).click();
  
  driver.quit(); 
  
  
  
  
  
}  

}
