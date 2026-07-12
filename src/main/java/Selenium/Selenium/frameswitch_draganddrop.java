package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameswitch_draganddrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		WebElement iframe=driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframe);
		WebElement source=driver.findElement(By.cssSelector("#draggable"));
		WebElement Target=driver.findElement(By.cssSelector("#droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(source, Target).build().perform();
		//going back to mainframe
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("[type='search']")).sendKeys("hi");
		
		
	}

}
