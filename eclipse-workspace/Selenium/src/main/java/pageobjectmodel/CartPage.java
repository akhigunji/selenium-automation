package pageobjectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public CartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
 
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement minicartbutton;
    
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutbutton;
	
	//clicking cart icon
	public void clickCartButton() {
		 wait.until(ExpectedConditions.elementToBeClickable(minicartbutton));
		minicartbutton.click();
		
	}
	
	public boolean comparingProdsToGetRequiredProd(String productname) {
		wait.until(ExpectedConditions.visibilityOfAllElements(cartproducts));
		boolean match = cartproducts.stream()
		        .anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase(productname));
		return match;
	}
			
	public void clickCheckoutButton() {
		checkoutbutton.click();		
	}
}
