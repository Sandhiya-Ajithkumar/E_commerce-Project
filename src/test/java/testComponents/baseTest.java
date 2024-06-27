package testComponents;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationQA.PageObjects.landingPage;

public class baseTest {
	public WebDriver driver;
	public landingPage landingpage;

	public WebDriver initializeDriver() throws IOException {
		// properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// orelse
		// firefox
		// edge
		return driver;

	}
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//json to string
	String jsoncontent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\purchaseOrder.json"), 
			StandardCharsets.UTF_8);
	//string to hashmap
	ObjectMapper objmap = new ObjectMapper();
	List<HashMap<String, String>> data = objmap.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {});
	return data;
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

	@BeforeMethod
	public landingPage landingApplication() throws IOException {
		driver = initializeDriver();
		landingpage = new landingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
