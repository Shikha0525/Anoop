package com.qait.automation.HrisUsingFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	
  WebDriver driver;	
  LoginForm login_form;
  ReadFileData readfiledata;
	
  @BeforeClass
  public void launchBrowser(){
  	String exepath="/home/qainfotech/Downloads/chromedriver";
      System.setProperty("webdriver.chrome.driver",exepath);
      driver = new ChromeDriver();
      driver.get("https://hris.qainfotech.com/login.php");
      login_form = new LoginForm(driver);
  }
  @Test
  public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
	  readfiledata=new ReadFileData();
	  String username=readfiledata.GetInValidUserName();
	  String password=readfiledata.GetInValidPassword();
	  Assert.assertTrue(login_form
              .loginWithIncorrectCredentials(username, password).contains("Invalid Login"));
  }
  
 @Test
  public void attempt_Login_With_No_Password_Should_Annotate_Blank_Password_Field(){
	 String username=readfiledata.GetValidUserName();
	 String Password=readfiledata.BlankPassword();
	 login_form.login(username, Password);
  	 Assert.assertTrue(login_form.isPasswordEntryAnnotated());  
  }
 
  @Test
  public void attemptLoginWithCorrectCredentails()
  {
	  String username=readfiledata.GetValidUserName();
	  String password=readfiledata.GetValidPassword();

  	  TimeSheet ts=login_form.loginWithCorrectCredentials(username,password);
  	  Assert.assertFalse(login_form.isPasswordEntryAnnotated()); 
  }
  
}
