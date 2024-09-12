package TestingPractice.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestingPractice.TestingComponents.baseTest;
import TestingPractice.pageObjects.cartPage;
import TestingPractice.pageObjects.checkOutPage;
import TestingPractice.pageObjects.confirmationPage;
import TestingPractice.pageObjects.landingPage;
import TestingPractice.pageObjects.productCatalogue;

public class errorValidation extends baseTest {

	

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		
		obj.loginApplication("rahul@smith13.com", "John137");
		Assert.assertEquals("Incorrect email or password.", obj.getErrorMessage());
		
		
		
	}
	
	@Test
	public void submitOrder2() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		
		productCatalogue productCatalogue = obj.loginApplication("john@smith13.com", "John@137");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		Thread.sleep(1000);
		cartPage cartPage = productCatalogue.cartPage();
		Boolean match = cartPage.cartProduct("ZARA COAT 33");
		Assert.assertFalse(match);
		
		
		
	}
}


