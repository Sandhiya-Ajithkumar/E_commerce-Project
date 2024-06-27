package automationQA.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;

public class landingPage extends abstractComponent {
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement submit;
    @FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	//action methods
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
	}
	public String getErrorMessage() {
		waitWebElementToAppear(errorMessage);
		String message = errorMessage.getText();
		return message;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	

}
