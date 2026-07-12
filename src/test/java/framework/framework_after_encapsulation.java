package framework;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import encapsulatedpageobjectmodel.*;


public class framework_after_encapsulation extends BaseTest{

	@Test(groups= {"smoke"})
	public void framework_after_encapsulation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
		
		//login page
		Loginpage1 loginpage=launchapplication();
		PlpPage1 plp=loginpage.loginApplication("grey2022@gmail.com", "Anna@12345");
		//products page
		
		//clicking cart icon
		CartPage1 cartpage=plp.addProductToCart(productname);
		cartpage.clickCartButton();		
		//comparing product names in cart with the required product
		Assert.assertTrue(cartpage.comparingProdsToGetRequiredProd(productname));

		//clicking on checkout button
		//to select india in autosuggestive dropdown
		CheckoutPage1 checkoutpage=cartpage.clickCheckoutButton();
		checkoutpage.selectdropdownoption();			
		//click on place order button
		
		//confirm message in confirmation page
		
		ConfirmationPage1 confirmationpage=checkoutpage.clickPlaceOrderButton();
		Assert.assertTrue(confirmationpage.getMsgInConfirmationPage());
		
		
	
		

	}

}
