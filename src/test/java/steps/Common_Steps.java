package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common_Steps {

	private WebDriver driver;
	
	@Before(order = 0)
	public void setUp() {
		System.out.println("In Before Global Hook");
		//System.setProperty("webdriver.firefox.driver", "webdrivers/geckodriver.exe");
		//driver = new FirefoxDriver();		
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		/*ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(chromeOptions);*/
		driver = new ChromeDriver();
	}	
	
	@After(order = 1)
	public void tearDown() throws Exception{
		System.out.println("In tearDown After Hook");
		driver.quit();
		Thread.sleep(1000);		
	}	
	
	public WebDriver getDriver() {
		return driver;
	}
}
