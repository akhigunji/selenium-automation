package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class switching_windows_tabs_withouthandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriver newwindow=driver.switchTo().newWindow(WindowType.WINDOW);
		newwindow.get("https://www.google.com");
		newwindow.findElement(By.name("q")).sendKeys("hi");
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get("https://www.google.com");
		newTab.findElement(By.name("q")).sendKeys("hehehe");

	}

}
