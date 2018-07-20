package com.qait.automation.AdvanceViaMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import org.eclipse.jetty.io.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
  
  WebDriver driver;
  WelcomePage welcomepage;
  HoverMenu hovermenu;
  QueryGate querygate;
  
  @BeforeClass
  public void beforeClass() {
  
	  String exepath="/home/qainfotech/Downloads/chromedriver";
      System.setProperty("webdriver.chrome.driver",exepath);
	  driver = new ChromeDriver();
	  
  }
  
  @Test(priority=1)
	public void welcomepage(){
	    welcomepage= new WelcomePage(driver);
		welcomepage.launchApplication("http://10.0.1.86/tatoc");
		welcomepage.verifyHomePageLaunched();
	}
  
  @Test(priority=2)
	public void HoverMenu() {
		hovermenu=new HoverMenu(driver);
		hovermenu.verify();
  }
  
  @Test(priority=3)
   public void QueryGate() throws ClassNotFoundException, SQLException {
	    querygate=new QueryGate(driver);
	    querygate.connectivity();
	    querygate.ExtractNameAndPasskey();
	    querygate.test();
	    
  }


  
}
