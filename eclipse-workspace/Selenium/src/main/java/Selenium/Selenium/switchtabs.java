package Selenium.Selenium;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchtabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String parentwindow=driver.getWindowHandle();
		System.out.println(parentwindow);
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowhandles =driver.getWindowHandles();
		//!.equals compares contents while != compares memory objects
		for(String window:windowhandles) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
			}
		}
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailid=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailid);
		driver.switchTo().window(parentwindow);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailid);
		
		

	}

}
