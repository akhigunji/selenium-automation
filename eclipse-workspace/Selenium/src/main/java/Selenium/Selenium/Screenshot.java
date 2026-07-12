package Selenium.Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("Downloads//google.png"));
		System.out.println("File created");
		
	}

}
