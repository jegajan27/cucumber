package steps;

import static org.junit.Assert.*;

//import java.util.Collections;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import net.thucydides.core.annotations.findby.By;

public class EbayAdvancedSearch_Steps {
	WebDriver driver;

	public EbayAdvancedSearch_Steps(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	@Given("I am on Ebay Advanced Search Page")
	public void i_am_on_Ebay_Advanced_Search_Page() {
		driver.get("https://www.ebay.com/sch/ebayadvsearch");

	}

	@When("I click on Ebay Logo")
	public void i_click_on_Ebay_Logo() {		
		driver.findElement(By.xpath("//a[@id='gh-la']")).click();		  
	}

	@Then("I navigate to Ebay Home Page")
	public void i_navigate_to_Ebay_Home_Page() {
		String expUrl = "https://www.ebay.com/";
		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
		if(!expUrl.equals(actUrl)) {
			fail("Page doesn't navigate to Home Page");			
		}
	   driver.quit(); 
	}
	

	@When("I Advanced Search an item")
	public void i_Advanced_Search_an_item(io.cucumber.datatable.DataTable dataTable) throws Exception {
		driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		driver.findElement(By.xpath("//input[@name='_udlo']")).sendKeys(dataTable.cell(1, 2));
		driver.findElement(By.xpath("//input[@name='_udhi']")).sendKeys(dataTable.cell(1, 3));
		driver.findElement(By.xpath("//button[@id='searchBtnLowerLnk']")).click();
		Thread.sleep(3000);
	}

}
