package com.qait.tap.hristest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeSheet {

	WebDriver driver;
	public TimeSheet(WebDriver driver) {
		
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String time = driver.findElement(By.cssSelector("input[class='ng-binding']")).getText();
		//String time=element.toString();
		System.out.println(time);
		
	}
	
	

}
