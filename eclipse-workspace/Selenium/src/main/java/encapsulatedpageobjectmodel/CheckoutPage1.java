package encapsulatedpageobjectmodel;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage1 {
 
	WebDriver driver;
	WebDriverWait wait;
	public CheckoutPage1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
    @FindBy(xpath="//input[@placeholder='Select Country']")
    WebElement country;
    
    @FindBy(css=".ta-results")
    List<WebElement> dropdownoptions;
    
    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement optiontobeselected;
    
    @FindBy(css=".action__submit")
    WebElement placeorderbutton;
    
    
    public void selectdropdownoption() {
    	country.sendKeys("ind");
    	
    //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfAllElements(dropdownoptions));

    optiontobeselected.click();
    wait.until(ExpectedConditions.invisibilityOfAllElements(dropdownoptions));
    }
    
    public ConfirmationPage1 clickPlaceOrderButton() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(placeorderbutton));	
    	//JavascriptExecutor js=(JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].scrollIntoView(true);", placeorderbutton);
   	 Actions actions = new Actions(driver);
	    actions.moveToElement(placeorderbutton)
	           .click()
	           .perform();
    	//placeorderbutton.click();
    	
    	// click directly performs the action while actions hovers over the element and does the click
    	ConfirmationPage1 confirmationpage=new ConfirmationPage1(driver);
    	return confirmationpage;
    }
    

}
