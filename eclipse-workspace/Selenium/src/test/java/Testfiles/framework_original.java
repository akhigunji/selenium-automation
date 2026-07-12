package Testfiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testcomponents.Retry;

public class framework_original {

	@Test(groups={"smoke"},retryAnalyzer=Retry.class)
	public void framework() throws InterruptedException {
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//login page
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("grey2022@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Anna@12345");
		driver.findElement(By.cssSelector("#login")).click();
		//products page
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#products")));
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		 WebElement prod= products.stream()
		        .filter(product ->product.findElement(By.tagName("b"))
		                       .getText()
		                       .equals(productname))
		        			   .findFirst()
		        			   .orElse(null);
		    prod.findElement(By.cssSelector("button:last-of-type")).click();
		//clicking cart icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//comparing product names in cart with the required product
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartproducts.stream()
		        .anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		//clicking on checkout button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		//to select india in autosuggestive dropdown
			driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
			List<WebElement> options=driver.findElements(By.cssSelector(".ta-results"));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			/*for(WebElement option:options) {
				if(option.getText().equalsIgnoreCase("india")) {
					option.click();
					break;
				}
			}*/
		//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	
		//click on place order button
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));	
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//confirm message in confirmation page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String confirmmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmmsg);
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
		
		
	
		

	}

}
