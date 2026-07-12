package Selenium.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys("ind");
		List<WebElement> options=driver.findElements(By.cssSelector(".ui-menu-item"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("INDIA")){
				option.click();
				break;
				
			}
		}*/
		
		driver.get("https://rahulshettyacademy.com/client/#/dashboard/order?prop=%5B%226960eac0c941646b7a8b3e68%22%5D");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> options=driver.findElements(By.cssSelector(".ta-results"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		
	}

}
