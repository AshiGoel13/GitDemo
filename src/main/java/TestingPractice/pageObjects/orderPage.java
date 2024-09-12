package TestingPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.abstractComponents.abstractComponents;

public class orderPage extends abstractComponents{
	
	WebDriver driver;
	
	public orderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> productList;
	
	public Boolean orderDisplay(String productName)
	{
	Boolean match = productList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
	}
	
}

