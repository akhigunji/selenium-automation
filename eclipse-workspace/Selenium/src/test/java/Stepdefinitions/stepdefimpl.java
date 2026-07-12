package Stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import TestComponents.BaseTest;
import encapsulatedpageobjectmodel.CartPage1;
import encapsulatedpageobjectmodel.CheckoutPage1;
import encapsulatedpageobjectmodel.ConfirmationPage1;
import encapsulatedpageobjectmodel.Loginpage1;
import encapsulatedpageobjectmodel.PlpPage1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefimpl extends BaseTest{
	
	
	public Loginpage1 loginpage;
	public PlpPage1 plp;
	public CartPage1 cartpage;
	public CheckoutPage1 checkoutpage;
	public ConfirmationPage1 confirmationpage;

	@Given("i landed on the ecommerce website")
	public void i_landed_on_the_ecommerce_website() throws IOException {
		loginpage=launchapplication();
	}

	@Given("^Login to the user with (.+) and (.+)$")
	public void login_to_the_user_with_username_and_password(String username, String password) {
		System.out.println("Username received = [" + username + "]");
	    System.out.println("Password received = [" + password + "]");
		plp=loginpage.loginApplication(username, password);
	  
	}
	@When("^click on the product with name (.+)$")
	public void click_on_the_product_with_name_productname(String productName) {
		cartpage=plp.addProductToCart(productName);
	    
	}
	@When("Click on the minicart button")
	public void click_on_the_minicart_button() {
		cartpage.clickCartButton();	
	}
	@When("^Compare product in cart with given product name (.+)$")
	public void compare_product_in_cart_with_given_product_name_productname(String productName) {
		Assert.assertTrue(cartpage.comparingProdsToGetRequiredProd(productName));
	    
	}
	@When("select india in checkout page and click on place order button")
	public void select_india_in_checkout_page_and_click_on_place_order_button() {
		checkoutpage=cartpage.clickCheckoutButton();
		checkoutpage.selectdropdownoption();
		confirmationpage=checkoutpage.clickPlaceOrderButton();
		
	}
	@Then("^check the confirm message is matching with (.+)$")
	public void check_the_confirm_message_is_matching_with_confirmmessage(String confirmmessage) {
		Assert.assertTrue(confirmationpage.getMsgInConfirmationPage());
	}

}
