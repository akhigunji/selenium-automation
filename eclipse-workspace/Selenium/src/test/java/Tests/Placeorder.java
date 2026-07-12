package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import TestComponents.Base;
import encapsulatedpageobjectmodel.CartPage1;
import encapsulatedpageobjectmodel.CheckoutPage1;
import encapsulatedpageobjectmodel.ConfirmationPage1;
import encapsulatedpageobjectmodel.Loginpage1;
import encapsulatedpageobjectmodel.PlpPage1;


public class Placeorder extends Base{
	
	@Test
	public void placeorder() throws IOException{
		//String productname="ZARA COAT 3";
		//login page
		
		String username = null;
        String password=null;
        String productname=null;
		JsonNode data = getJsonData();
		JsonNode user = data.get(1);

      

            username = user.get("email").asText();
            password = user.get("password").asText();
            productname = user.get("product").asText();

            System.out.println(username);
            System.out.println(productname);
        
        
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


}
