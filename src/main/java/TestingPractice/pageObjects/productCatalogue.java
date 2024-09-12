package TestingPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestingPractice.abstractComponents.abstractComponents;

public class productCatalogue extends abstractComponents {
	
	WebDriver driver;
	
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> list = driver.findElements(By.cssSelector(""));
	
	@FindBy(css=".offset-md-0")
	List<WebElement> list;
	
	By product = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".w-10");
	By toastMessage = By.cssSelector("#toast-container");
	By loading = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(product);
		return list;
	}
	
	public WebElement getProductName(String productName)
	{
		WebElement prod = getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(loading);
	}
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
}
