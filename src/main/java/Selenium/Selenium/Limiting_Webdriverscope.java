package Selenium.Selenium;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Limiting_Webdriverscope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//total links in page
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link:links) {
			System.out.println(link.getText());
		}
		//count of links in footersection
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		//count links in the first section of the footer
		List<WebElement> collinks=driver.findElements(By.xpath("//tbody/tr/td[1]/ul/li/a"));
		System.out.println(collinks.size());
		//check whether the links in columns are opening or not
		for(int i=0;i<collinks.size();i++) {
			String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
			collinks.get(i).sendKeys(keys);	
		}
		//print titles opened in new tab:
		String parentwindow=driver.getWindowHandle();
		Set<String> windowhandles= driver.getWindowHandles();
		for(String window:windowhandles){
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
			}
		}
			
		
		
		
  
	}

}
