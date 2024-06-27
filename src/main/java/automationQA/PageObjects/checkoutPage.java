package automationQA.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;

public class checkoutPage extends abstractComponent{
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//page factory
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement selectCountry;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	By findby= By.cssSelector(".ta-results");
	
	
	//action methods
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitElementToAppear(findby);
		selectCountry.click();
	}
	public void placeOrder() {
		placeOrder.click();
	}

}
