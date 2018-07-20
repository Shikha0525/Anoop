package com.qait.automation.BingTranslator;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
  
  WebDriver driver;	
  Bing_Translator bing;
  String ExpectedResult;
	
  @BeforeClass
  public void beforeClass() {
	  
	  String exepath="/home/qainfotech/Downloads/chromedriver";
      System.setProperty("webdriver.chrome.driver",exepath);
      driver = new ChromeDriver();
      driver.get("https://www.bing.com/translator");
      driver.manage().window().maximize();
	  bing=new Bing_Translator(driver);
  }
  
  @Test
  public void test01Drop_Down() {
	  
	  WebElement dropdown=bing.verifyDropDown();
	  Assert.assertTrue(dropdown.isEnabled());
  }
  
  @Test
  public void test02Language_Selection() throws InterruptedException {
	  
	  String ActualResult = bing.WhenNoLanguageIsSelectedFromDropDown();
	  String ExpectedResult="Good";
	  Assert.assertEquals(ActualResult, ExpectedResult);
      
	  
  }
   
  @Test
  public void test03AutoDetectWhenNoLanguageIsSelectedFromDropDown() throws InterruptedException {
	  
	  
	  String actual= bing.AutoDetectWhenNoLanguageIsSelectedFromDropDown();
	  Assert.assertEquals(actual, "English (detected)");
	  
  }
  
  @Test
  public void test04SelectLanguageFromDropdown() throws InterruptedException {
	  
	  String actual= bing.SelectLanguageFromDropdown();
	  Assert.assertEquals(actual, "Thank you");
	  
  }
  
  @Test
  public void test05Exchange() throws InterruptedException {
	  
	  String actual=bing.Exchange();
	  Assert.assertEquals("Thank you", actual);
	  
  }
  
 @Test
  public void test06close() {
	  
	  
	  String actual= bing.close();
	  Assert.assertEquals(actual,"");
	  
  }
  
 @Test
 public void test07checkLimit() {
	 
	 bing.checkLimit();
	 
	 
 }
 
 }
