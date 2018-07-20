package com.qait.Bing.Translator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTestTest {
	WebDriver driver;
	
  @BeforeTest
  public void initial() {
  
	  String exepath="/home/qainfotech/Downloads/chromedriver";
      System.setProperty("webdriver.chrome.driver",exepath);
	  driver = new ChromeDriver();
  
  }
}
