package automationQA.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponent;

public class productCatalogue extends abstractComponent {
	WebDriver driver;

	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pagefactory
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By productby = By.cssSelector(".mb-3");
	By addCart = By.cssSelector(".btn.w-10.rounded");
	By toastmsg = By.cssSelector("#toast-container");
	By findby = By.cssSelector(".ng-animating");

	// action methods
	public List<WebElement> getProductList() {
		waitElementToAppear(productby);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;

	}
	public void addToCart(String productName) {
	WebElement prod = getProductByName(productName);
	prod.findElement(addCart).click();
	waitElementToAppear(toastmsg);
	
		
	}

}
