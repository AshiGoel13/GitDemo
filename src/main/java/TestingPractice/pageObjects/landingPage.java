package TestingPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestingPractice.abstractComponents.abstractComponents;

public class landingPage extends abstractComponents {
	
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement email = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	//.ng-tns-c4-2.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	public productCatalogue loginApplication(String email, String pwd)
	{
		username.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		productCatalogue productCatalogue = new productCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForElementToBeVisible(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
