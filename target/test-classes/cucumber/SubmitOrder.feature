
@tag
Feature: Purchase the order from e-commerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name 						  | password | productName |
      | john@smith13.com	| John@137 | ZARA COAT 3 |
     
