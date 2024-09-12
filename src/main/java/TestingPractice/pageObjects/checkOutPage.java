package TestingPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestingPractice.abstractComponents.abstractComponents;

public class checkOutPage extends abstractComponents{
	
	WebDriver driver;
	public checkOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Name on Card ']/following-sibling::input")
	WebElement NameOnCard;
	
	@FindBy(xpath="//div[text()='CVV Code ']/following-sibling::input")
	WebElement cvvCode;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement CountrySelection;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By countryLoad =By.cssSelector(".list-group-item");
	
	public void fillDetails(String Name, String code, String countryName )
	{
		NameOnCard.sendKeys(Name);
		cvvCode.sendKeys(code);
		country.sendKeys(countryName);
		waitForElementToAppear(countryLoad);
		CountrySelection.click();
	}
	
	public confirmationPage GoToSubmit()
	{
		submit.click();
		confirmationPage cnfrmPg = new confirmationPage(driver);
		return cnfrmPg;
	}
	
	//driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys("John");
	//driver.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input")).sendKeys("188");
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
	//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
}
