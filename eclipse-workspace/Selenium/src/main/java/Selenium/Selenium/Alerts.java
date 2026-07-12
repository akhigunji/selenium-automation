package Selenium.Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.name("enter-name")).sendKeys("akhi");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		/*System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();*/
		//using explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
		
	}

}
