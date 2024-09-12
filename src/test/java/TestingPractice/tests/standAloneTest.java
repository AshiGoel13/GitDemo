package TestingPractice.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestingPractice.TestingComponents.baseTest;
import TestingPractice.pageObjects.cartPage;
import TestingPractice.pageObjects.checkOutPage;
import TestingPractice.pageObjects.confirmationPage;
import TestingPractice.pageObjects.landingPage;
import TestingPractice.pageObjects.orderPage;
import TestingPractice.pageObjects.productCatalogue;

public class standAloneTest extends baseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		productCatalogue productCatalogue = obj.loginApplication(input.get("email"), input.get("pwd"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		Thread.sleep(1000);
		cartPage cartPage = productCatalogue.cartPage();
		Boolean match = cartPage.cartProduct(input.get("productName"));
		Assert.assertTrue(match);
		checkOutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.fillDetails("John", "188", "India");
		confirmationPage cnfrmPg = checkoutPage.GoToSubmit();
		String msg = cnfrmPg.confirmationMessage();
		
		
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"}, retryAnalyzer =Retry.class)
	public void orderHistoryTest()
	{
		productCatalogue productCatalogue = obj.loginApplication("john@smith13.com", "John@137");
		orderPage orderPage = productCatalogue.orderHistory();
		Assert.assertTrue( orderPage.orderDisplay(productName));
		
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>> data =  getJsonData(System.getProperty("user.dir")+"//src//test//java//TestingPractice//data//PurchaseOrder.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };
		}
	
}


