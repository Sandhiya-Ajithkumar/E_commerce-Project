package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponent {
	WebDriver driver;
	public abstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderButton;
	
	
	public void waitElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	public void waitWebElementToAppear(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
		
	}


		
	
	public void goToCartPage() {
		cartButton.click();
		
	}
	public void goToOrderPage() {
		orderButton.click();
		
	}

}
