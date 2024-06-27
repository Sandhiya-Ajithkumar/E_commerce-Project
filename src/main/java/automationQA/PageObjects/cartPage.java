package automationQA.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;


public class cartPage extends abstractComponent {
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//page factory
	@FindBy(css=".cartSection h3")
	List<WebElement> productTittles;
	
	@FindBy(css=".subtotal.cf.ng-star-inserted ul li button")
	WebElement checkout;
	By findby=By.cssSelector(".cart");
	
	//action methods
	public boolean verifyProductDisplay(String productName) {
		waitElementToAppear(findby);
		boolean match = productTittles.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}
	public void goToCheckoutPage() {
		checkout.click();
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
