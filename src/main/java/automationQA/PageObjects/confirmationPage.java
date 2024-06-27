package automationQA.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;

public class confirmationPage extends abstractComponent {
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// pagefactory
	@FindBy(css = ".hero-primary")
	WebElement finalmessage;


	public String verifyMessage() {
		String message = finalmessage.getText();
		return message;

	}
}
