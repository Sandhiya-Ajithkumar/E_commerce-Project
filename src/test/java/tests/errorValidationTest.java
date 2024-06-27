package tests;

import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automationQA.PageObjects.cartPage;
import automationQA.PageObjects.checkoutPage;
import automationQA.PageObjects.confirmationPage;
import automationQA.PageObjects.landingPage;
import automationQA.PageObjects.productCatalogue;
import junit.framework.Assert;
import testComponents.baseTest;

public class errorValidationTest extends baseTest{

	@Test
	public void errorValidation() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";
		String countryName = "India";
		landingpage.loginApplication("sandhiyashankar241@gmail.com", "andhiya@26");
		landingpage.getErrorMessage();
		Assert.assertEquals("Incorrect email  password.", landingpage.getErrorMessage());

	}

	
		


}
