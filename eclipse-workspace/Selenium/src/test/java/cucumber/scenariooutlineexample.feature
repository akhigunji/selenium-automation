@placeorder
Feature: Place order

Background: 
	Given i landed on the ecommerce website

Scenario Outline: Placing order with a product
	Given Login to the user with <username> and <password>
	When click on the product with name <productname>
	And Click on the minicart button
	When Compare product in cart with given product name <productname>
	And select india in checkout page and click on place order button
	Then check the confirm message is matching with <confirmmessage>
	
Examples:
	|username|password|productname|confirmmessage|
	|grey2022@gmail.com|Anna@12345|ZARA COAT 3|THANKYOU FOR THE ORDER.|
	|grey2028@gmail.com|Anna@12345|ZARA COAT 3|THANKYOU FOR THE ORDER.|