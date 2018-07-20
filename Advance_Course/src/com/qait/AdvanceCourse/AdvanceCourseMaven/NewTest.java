package com.qait.AdvanceCourse.AdvanceCourseMaven;

import org.testng.annotations.Test;

import com.qait.testing.Maven_Tatoc.Basic_Course;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
  
	WebDriver driver;
	WelcomePage welcomepage;
	
	@BeforeClass
	public void initial() {
		driver = new ChromeDriver();
		welcomepage= new WelcomePage(driver);
	}
	
	@Test(priority=1)
	public void WelcomePage(){
		welcomepage.launchApplication("http://10.0.1.86/tatoc");
		welcomepage.verifyHomePageLaunched();
	}
	
	
}
