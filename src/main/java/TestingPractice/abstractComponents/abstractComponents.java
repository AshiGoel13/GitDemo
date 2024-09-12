package TestingPractice.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestingPractice.pageObjects.cartPage;
import TestingPractice.pageObjects.orderPage;

public class abstractComponents {
	
	WebDriver driver;
	public abstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForElementToBeVisible(WebElement findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public void waitForElementToDisappear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	
	public cartPage cartPage()
	{
		cart.click();
		cartPage cartPage = new cartPage(driver);
		return cartPage;
	}
	
	public orderPage orderHistory()
	{
		orderHeader.click();
		orderPage orderPage = new orderPage(driver);
		return orderPage;
	}
}

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));
//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
