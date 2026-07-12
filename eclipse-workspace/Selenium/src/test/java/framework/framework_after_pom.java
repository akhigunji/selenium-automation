package framework;

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

import pageobjectmodel.CartPage;
import pageobjectmodel.CheckoutPage;
import pageobjectmodel.ConfirmationPage;
import pageobjectmodel.Loginpage;
import pageobjectmodel.PlpPage;

public class framework_after_pom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//login page
		Loginpage loginpage=new Loginpage(driver);
		loginpage.goTo();
		loginpage.loginApplication("grey2022@gmail.com", "Anna@12345");
		//products page
		PlpPage plp=new PlpPage(driver);
		plp.addProductToCart(productname);
		//clicking cart icon
		CartPage cartpage=new CartPage(driver);
		cartpage.clickCartButton();		
		//comparing product names in cart with the required product
		Assert.assertTrue(cartpage.comparingProdsToGetRequiredProd(productname));
		//clicking on checkout button
		cartpage.clickCheckoutButton();
		//to select india in autosuggestive dropdown
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.selectdropdownoption();			
		//click on place order button
		checkoutpage.clickPlaceOrderButton();
		
		//confirm message in confirmation page
		ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		Assert.assertTrue(confirmationpage.getMsgInConfirmationPage());
		
		
	
		

	}

}
