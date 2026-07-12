package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import encapsulatedpageobjectmodel.CartPage1;
import encapsulatedpageobjectmodel.CheckoutPage1;
import encapsulatedpageobjectmodel.ConfirmationPage1;
import encapsulatedpageobjectmodel.Loginpage1;
import encapsulatedpageobjectmodel.PlpPage1;



public class Placeorder_testdata_withhashmaps extends BaseTest{
	
	@Test(dataProvider="gettestdata")
	public void placeorder(HashMap<String, String> input) throws IOException{
		//String productname="ZARA COAT 3";
		//login page
		String username=input.get("email");
		String password=input.get("password");
		String productname=input.get("product");
		
               
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
	
	/*@DataProvider
	public Object[][] gettestdata() {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email" , "grey2022@gmail.com");
		map.put("password", "Anna@12345");
		map.put("product" , "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email" , "grey2028@gmail.com");
		map1.put("password", "Anna@12345");
		map1.put("product" , "ZARA COAT 3");
		
		  return new Object[][] {
		        {map},
		        {map1}
		
		  };
		
	}*/
	
	
	@DataProvider
	public Object[][] gettestdata() throws IOException {
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Testdata\\PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}
	
	
	


}
