package Selenium.Selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class switching_windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.cssSelector("#openwindow")).click();
		Set<String> windowhandles=driver.getWindowHandles();
		for(String window:windowhandles) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
			}
		}
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getCurrentUrl());
		WebDriver newwindow=driver.switchTo().newWindow(WindowType.WINDOW);
		newwindow.get("https://www.google.com");
		newwindow.findElement(By.name("q")).sendKeys("hi");
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get("https://www.google.com");
		newTab.findElement(By.name("q")).sendKeys("hehehe");
		

		
		
	}

}
