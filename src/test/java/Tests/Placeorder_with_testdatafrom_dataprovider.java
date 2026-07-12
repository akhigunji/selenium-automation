package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.Base;

import encapsulatedpageobjectmodel.CartPage1;
import encapsulatedpageobjectmodel.CheckoutPage1;
import encapsulatedpageobjectmodel.ConfirmationPage1;
import encapsulatedpageobjectmodel.Loginpage1;
import encapsulatedpageobjectmodel.PlpPage1;


public class Placeorder_with_testdatafrom_dataprovider extends Base{
	
	@Test(dataProvider="getData")
	public void placeorder(String username, String password, String productname) throws IOException{
		//String productname="ZARA COAT 3";
		//login page     
		Loginpage1 loginpage=launchapplication();
		PlpPage1 plp=loginpage.loginApplication(username, password);
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

	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
	        {"grey2022@gmail.com",
	          "Anna@12345",
	          "ADIDAS ORIGINAL"},
	        {"grey2028@gmail.com",
	          "Anna@12345",
	          "ZARA COAT 3"}
	    };
	}


	
}
