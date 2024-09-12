package TestingPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.abstractComponents.abstractComponents;

public class cartPage extends abstractComponents{
	
	WebDriver driver;
	
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> cart = driver.findElements(By.cssSelector(""));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cart;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkout;
	
	public Boolean cartProduct(String productName)
	{
	Boolean match = cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
	}
	public checkOutPage goToCheckOut()
	{
		checkout.click();
		checkOutPage checkoutPage = new checkOutPage(driver);
		return checkoutPage;
	}
}

