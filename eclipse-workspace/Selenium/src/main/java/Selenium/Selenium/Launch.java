package Selenium.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Launch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/register");
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Anna");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("grey");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("grey2028@gmail.com");
		driver.findElement(By.cssSelector("#userMobile")).sendKeys("1234567890");
		WebElement dropdown=driver.findElement(By.cssSelector(".custom-select"));
		Select fromdropdown=new Select(dropdown);
		fromdropdown.selectByVisibleText("Engineer");	
		driver.findElement(By.cssSelector("[value='Female']")).click();
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Anna@12345");
		driver.findElement(By.cssSelector("#confirmPassword")).sendKeys("Anna@12345");
		driver.findElement(By.cssSelector("[type='checkbox']")).click();
		driver.findElement(By.cssSelector("#login")).click();		
		boolean status=driver.findElement(By.xpath("//h1[text()='Account Created Successfully']")).isDisplayed();
		System.out.println(status);
		System.out.println("Registered Successfully");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
				
		
		//grey2022@gmail.com
		
		
		
		
		
		

	}

}
