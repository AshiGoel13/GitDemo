package TestingPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.abstractComponents.abstractComponents;

public class confirmationPage extends abstractComponents {
	
	WebDriver driver;
	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement msg;
	
	public String confirmationMessage()
	{
		return msg.getText();
	}
	
	//String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
}
