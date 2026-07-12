package encapsulatedpageobjectmodel;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConfirmationPage1 {

	WebDriver driver;
	WebDriverWait wait;
	public ConfirmationPage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css=".hero-primary")
	WebElement confirmmsg;
	
	public Boolean getMsgInConfirmationPage() {
		wait.until(ExpectedConditions.visibilityOf(confirmmsg));
		String message=confirmmsg.getText();
		System.out.println(message);
		Boolean samemessage=message.equalsIgnoreCase("Thankyou for the order.");
		return samemessage;
	}
	
}
