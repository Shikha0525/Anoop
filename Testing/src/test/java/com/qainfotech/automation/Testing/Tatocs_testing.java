package com.qainfotech.automation.Testing;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tatocs_testing {

    WebDriver driver;

    public Tatocs_testing() {
    	
    	System.setProperty("webdriver.chrome.driver", "/Home/Downloads/chromedriver");
    	 this.driver = new ChromeDriver();	
    	 driver.navigate().to("http://10.0.1.86/tatoc");
   
    }
    

  
}