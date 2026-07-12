
Feature: Place order

Background: 
	Given i landed on the ecommerce website

Scenario: Placing order with a product
	Given Login to the user with "grey2022@gmail.com" and "Anna@12345"
	When click on the product with name "ZARA COAT 3"
	And Click on the minicart button
	When Compare product in cart with given product name "ZARA COAT 3"
	And select india in checkout page and click on place order button
	Then check the confirm message is matching with "THANKYOU FOR THE ORDER."

