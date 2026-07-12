package encapsulatedpageobjectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlpPage1 {
	
	WebDriver driver;
	WebDriverWait wait;
	public 	PlpPage1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	By productbyproductname = By.tagName("b");
	By addToCart = By.cssSelector("button:last-of-type");	
	By loader=By.cssSelector("#toast-container");
	By disappereanceOfLoader=By.cssSelector(".ng-animating");
	//get products --search required product -- click on the add to cart of that product

	public List<WebElement> getProductsList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		return products;
	}
	
	public WebElement getRequiredProduct(String productname) {
		WebElement prod= (WebElement) getProductsList().stream()
		        		.filter(product ->product.findElement(productbyproductname)
		                       .getText()
		                       .equals(productname))
		        		.findFirst()
		        		.orElse(null);
		        
		        return prod;
	}
	
	public CartPage1 addProductToCart(String productname) {
		WebElement prod=getRequiredProduct(productname);
		prod.findElement(addToCart).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(disappereanceOfLoader));
		CartPage1 cartpage=new CartPage1(driver);
		return cartpage;
		
	}
	
}
