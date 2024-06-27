package automationQA.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;

public class orderPage extends abstractComponent{
	WebDriver driver;
	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	By findby=By.cssSelector("div h1");
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productsList;

	
	//action method
	public boolean verifyProductDisplayInOrderpage(String productName) {
		
		boolean match = productsList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}

}
