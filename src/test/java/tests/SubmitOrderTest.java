package tests;

import java.io.File;

import java.io.IOException;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationQA.PageObjects.cartPage;
import automationQA.PageObjects.checkoutPage;
import automationQA.PageObjects.confirmationPage;
import automationQA.PageObjects.landingPage;
import automationQA.PageObjects.orderPage;
import automationQA.PageObjects.productCatalogue;
import junit.framework.Assert;
import testComponents.baseTest;

public class SubmitOrderTest extends baseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		String countryName = "India";
		landingpage.loginApplication(input.get("email"), input.get("password"));
		// productcatalogue
		productCatalogue product = new productCatalogue(driver);
		List<WebElement> products = product.getProductList();
		product.addToCart(input.get("productName"));
		Thread.sleep(1000);
		landingpage.goToCartPage();
		// cartpage
		cartPage cartpage = new cartPage(driver);
		boolean match = cartpage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		cartpage.goToCheckoutPage();
		checkoutPage checkoutpage = new checkoutPage(driver);
		checkoutpage.selectCountry(countryName);
		checkoutpage.placeOrder();
		confirmationPage confirmpage = new confirmationPage(driver);
		String message = confirmpage.verifyMessage();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {

		landingpage.loginApplication("sandhiyashankar24@gmail.com", "Sandhiya@26");
		landingpage.goToOrderPage();
		orderPage orderpage = new orderPage(driver);
		Assert.assertTrue(orderpage.verifyProductDisplayInOrderpage(productName));

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		 List<HashMap<String, String>> data = getJsonDataToMap();
		 return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	

}
