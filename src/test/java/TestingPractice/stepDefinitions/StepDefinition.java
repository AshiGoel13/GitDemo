package TestingPractice.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestingPractice.TestingComponents.baseTest;
import TestingPractice.pageObjects.cartPage;
import TestingPractice.pageObjects.checkOutPage;
import TestingPractice.pageObjects.confirmationPage;
import TestingPractice.pageObjects.landingPage;
import TestingPractice.pageObjects.productCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends baseTest{
	
	public landingPage landingPage;
	public productCatalogue productCatalogue;
	public confirmationPage cnfrmPg;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		 productCatalogue = obj.loginApplication(username, password);
	}
	
	@When("^I add product (.+) from cart$")
	public void I_add_product_from_cart(String productName)
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		cartPage cartPage = productCatalogue.cartPage();
		Boolean match = cartPage.cartProduct(productName);
		Assert.assertTrue(match);
		checkOutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.fillDetails("John", "188", "India");
		 cnfrmPg = checkoutPage.GoToSubmit();
	}
	
	@Then("{String} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string)
	{
		String msg = cnfrmPg.confirmationMessage();
		Assert.assertTrue(msg.equalsIgnoreCase(string));
	}
}
