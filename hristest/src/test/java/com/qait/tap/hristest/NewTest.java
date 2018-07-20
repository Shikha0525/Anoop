package com.qait.tap.hristest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class NewTest {
    
    WebDriver driver;
    
    LoginForm loginForm;
    
    @Test(priority=1)
    public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
        Assert.assertTrue(loginForm
                .loginWithIncorrectCredentials("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
    }
    
   @Test(priority=2)
    public void attempt_Login_With_No_Password_Should_Annotate_Blank_Password_Field(){
    	loginForm.login("Shikha", "");
    	// red border in password entry
    	Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
    }
    
    @Test(priority=3)
    public void attemptLoginWithCorrectCredentails()
    {
    	TimeSheet ts=loginForm.loginWithCorrectCredentials("Shikhatyagi","Shikha@321#");
    	
        Assert.assertFalse(loginForm.isPasswordEntryAnnotated()); 
    }
    @BeforeClass
    public void launchBrowser(){
    	String exepath="/home/qainfotech/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver",exepath);
        driver = new ChromeDriver();
        driver.get("https://hris.qainfotech.com/login.php");
        loginForm = new LoginForm(driver);
    }
    
    
    /*@AfterClass
    public void closeBrowser(){
       // driver.quit();
    }*/
    
}