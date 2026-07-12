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


public class Placeorderfor_multiple_jsontestsets extends Base{
	
	
	@Test
	public void placeorder() throws IOException {

	    JsonNode data = getJsonData();

	    for (JsonNode user : data) {

	        String email = user.get("email").asText();
	        String password = user.get("password").asText();
	        String productname = user.get("product").asText();

	        Loginpage1 loginpage = launchapplication();

	        PlpPage1 plp = loginpage.loginApplication(email, password);

	        CartPage1 cartpage = plp.addProductToCart(productname);

	        cartpage.clickCartButton();

	        Assert.assertTrue(cartpage.comparingProdsToGetRequiredProd(productname));

	        CheckoutPage1 checkoutpage = cartpage.clickCheckoutButton();

	        checkoutpage.selectdropdownoption();

	        ConfirmationPage1 confirmationpage = checkoutpage.clickPlaceOrderButton();

	        Assert.assertTrue(confirmationpage.getMsgInConfirmationPage());

	        driver.quit();   // Close browser after each test data set
	    }
	}

}
