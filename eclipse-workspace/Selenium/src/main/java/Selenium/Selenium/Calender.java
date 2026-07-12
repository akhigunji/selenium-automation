package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String month="06";
		String date="05";
		String year="1977";
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.name("month")).click();
		
		

	}

}
