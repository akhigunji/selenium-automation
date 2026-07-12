package encapsulatedpageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Loginpage1 {
	
	WebDriver driver;

	public Loginpage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="#userEmail")
	WebElement userEmail;
	
	@FindBy(css="#userPassword")
	WebElement userPassword;
	
	@FindBy(css="#login")
	WebElement login;
	
	public void goTo(){
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

	public PlpPage1 loginApplication(String email, String password){
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		PlpPage1 plp=new PlpPage1(driver);
		return plp;
	}
	
	

	
}
