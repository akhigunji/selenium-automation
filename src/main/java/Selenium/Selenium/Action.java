package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[text()='Login']"))).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("#autocomplete")))
		.click()
		.keyDown(Keys.SHIFT)
		.sendKeys("india")
		.keyUp(Keys.SHIFT)
		.build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("#dropdown-class-example"))).contextClick()
		.build().perform();
		
		
	}

}
