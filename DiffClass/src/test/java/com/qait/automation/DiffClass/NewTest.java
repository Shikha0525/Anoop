package com.qait.automation.DiffClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class NewTest {
	
		WebDriver driver;
		BasicCourse page1;
		GridGate grid;
		FrameDungeon fd;
		
	  @BeforeTest
	  public void launchBrowser()
	  {
	      driver = new ChromeDriver();
	      driver.get("http://10.0.1.86/tatoc");
	      page1 = new BasicCourse(driver);
	  }
	  @AfterClass
	  public void closeBrowser(){
	      //driver.quit();
	  }
}
