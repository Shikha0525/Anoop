package tatocwithtestng;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import java.util.ArrayList;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Tatoc_maven{
	
	WebDriver driver;
	
	public Tatoc_maven(){
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		//driver.findElement(By.linkText("Basic Course")).click();
		
	}
	
	@Test(priority=1)
	public void GreenBox() {
		driver.findElement(By.className("greenbox")).click();
	}
	
	@Test(dependsOnMethods = {"GreenBox"})
    public void frameDungeon() {
		driver.switchTo().frame("main");
		String box1 = new String();
		box1 = driver.findElement(By.id("answer")).getAttribute("class");
		
		driver.switchTo().frame("child");
		String box2 = new String();
		box2 = driver.findElement(By.id("answer")).getAttribute("class");
		
		
		boolean condition = true;
		while(condition){
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			box2 = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			if(box2.equals(box1)) {
				condition = false;
			}
			
			
		}
		driver.findElement(By.linkText("Proceed")).click();
		
	}
	
	@Test(dependsOnMethods = {"frameDungeon"})
    public void drag() {
		WebElement element = driver.findElement(By.id("dragbox"));
		WebElement target = driver.findElement(By.id("dropbox"));

		(new Actions(driver)).dragAndDrop(element, target).perform();
		driver.findElement(By.linkText("Proceed")).click();
		
	}
	
	@Test(dependsOnMethods = {"drag"})
    public void popup() {
		driver.findElement(By.linkText("Launch Popup Window")).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("name")).sendKeys("Automation");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	@Test(dependsOnMethods = {"popup"})
    public void cookie() {
		driver.findElement(By.linkText("Generate Token")).click();
		String value = new String();
		value = driver.findElement(By.id("token")).getText();
		//System.out.print(value);
		String value1 = value.substring(7);
		//System.out.print("\n"+value1);
		Cookie cookie = new Cookie("Token", value1);
		driver.manage().addCookie(cookie);
		driver.findElement(By.linkText("Proceed")).click();
		
	}


	
	
}