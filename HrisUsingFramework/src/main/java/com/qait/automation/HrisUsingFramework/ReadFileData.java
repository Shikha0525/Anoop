package com.qait.automation.HrisUsingFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadFileData {
	WebDriver driver;
	Properties prop;
  		
	public  ReadFileData() {
		
		File file = new File("/home/qainfotech/eclipse-workspace/HrisUsingFramework/FetchData.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	  //this.driver = driver;
		
	}
	
	   public String GetInValidUserName() {
		
		 return prop.getProperty("InvalidUserName");
	   }
	
       public String GetInValidPassword() {
		
		return prop.getProperty("InvalidPassword");
	   }
          
       public String GetValidUserName() {
      		
      	 return prop.getProperty("ValidUserName");
      	   }
       
       public String GetValidPassword() {
   		
   		return prop.getProperty("ValidPassword");
   	   }
	
       public String BlankPassword() {
    	   
    	   return prop.getProperty("BlankPassword");
       }
       
       
	

}
