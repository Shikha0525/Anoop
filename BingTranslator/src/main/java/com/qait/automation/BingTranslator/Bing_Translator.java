package com.qait.automation.BingTranslator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Bing_Translator {
	
	WebDriver driver;
	
	public Bing_Translator(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement verifyDropDown() {
		
		WebElement dropdownPresent = driver.findElement(By.id("t_sl"));
		return dropdownPresent;
    }
	
	public String WhenNoLanguageIsSelectedFromDropDown() throws InterruptedException {
		
		WebElement WriteText=driver.findElement(By.id("t_sv"));
		WebElement ReadOnly=driver.findElement(By.id("t_tv"));
		String ExpectedResult="Good";
		WriteText.sendKeys(ExpectedResult);
        Thread.sleep(1000);
		String ActualResult=ReadOnly.getAttribute("value");
		Thread.sleep(1000);
		System.out.println(ExpectedResult);
		System.out.println(ActualResult);
		return (ActualResult);
		
		
	}
	
	public String AutoDetectWhenNoLanguageIsSelectedFromDropDown() throws InterruptedException {
	
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"t_sl\"]")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;
		
	}
	
	public String SelectLanguageFromDropdown() throws InterruptedException {
		
		driver.navigate().refresh();
		Select dropdown = new Select(driver.findElement(By.id("t_sl")));
		dropdown.selectByVisibleText("French");
		WebElement WriteText=driver.findElement(By.id("t_sv"));
		WebElement ReadOnly=driver.findElement(By.id("t_tv"));
		WriteText.sendKeys("Merci");
		Thread.sleep(1000);
		String ActualResult=ReadOnly.getAttribute("value");
		return(ActualResult);
		
	}
	public String Exchange() throws InterruptedException {
		
		WebElement exchange=driver.findElement(By.id("t_revIcon"));
		WebElement ReadOnly=driver.findElement(By.id("t_tv"));
		Thread.sleep(1000);
		String ActualResult=ReadOnly.getAttribute("value");
		exchange.click();
		return ActualResult;
	}

	public String close() {
		
		WebElement ReadOnly=driver.findElement(By.id("t_tv"));
		WebElement closeID=driver.findElement(By.id("t_edc"));
		closeID.click();
		String ActualResult=ReadOnly.getAttribute("value");
		
		return ActualResult;
		
	}
	
	public void checkLimit() {
		
		WebElement WriteText=driver.findElement(By.id("t_sv"));
		for(int i=0;i<5001;i++) {
			WriteText.sendKeys("a");
		}
		
		WebElement tooLong=driver.findElement(By.id("t_long"));
		String ActualResult=tooLong.getAttribute("value");
		Assert.assertEquals(ActualResult, "That’s too much text to translate at once. Try entering less");
	}
	
	
	
	

	
}