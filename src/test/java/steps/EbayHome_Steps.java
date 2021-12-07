package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {
	WebDriver driver;
	
	public EbayHome_Steps(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	@Given("I am on Ebay Home Page")
	public void i_am_on_Ebay_Home_Page() {		
		driver.get("https://www.ebay.com/");

	}

	@When("I click on Advanced Link")
	public void i_click_on_Advanced_Link() {
	    System.out.println("I click on Advanced Link");
	    driver.findElement(By.linkText("Advanced")).click();
	}

	@Then("I Navigate to Advanced Search Page")
	public void i_Navigate_to_Advanced_Search_Page() {
	    System.out.println("I Navigate to Advanced Search Page");
	    String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	    String actUrl = driver.getCurrentUrl();
	    if (!expUrl.equals(actUrl)) {
	    	fail("Page doesn't navigate to expected page");
	    }	   
	}

	@When("I search for {string}")
	public void i_search_for_iphone(String str1) throws Exception {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
	    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	    Thread.sleep(1000);
	}

	@Then("I validate atleast {int} search items")
	public void i_validate_atleast_search_items(int count) {
	   String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText();
	   String itemCount1 = itemCount.replace(",", "");
	   int itemCountInt = Integer.parseInt(itemCount1);
	   if(itemCountInt <= count
			   ) {
		   fail("Less than 1000 search results");
	   }	   
	}

	@When("I search for {string} in {string} Category")
	public void i_search_for_in_Category(String string, String string2) throws Exception{
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
		List<WebElement> categories = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for(WebElement x:categories ) {
			if(x.getText().trim().toLowerCase().equals(string2.toLowerCase())) {
				x.click();
				break;
			}
		}
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	    Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) {
	    driver.findElement(By.linkText(string)).click();
	}

	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
		String actUrl = driver.getCurrentUrl();
		String actTitle = driver.getTitle();
		if(actUrl.trim().toLowerCase().equals(url.toLowerCase())) {
			System.out.println("url validated true");
		}	    
	    if(actTitle.trim().toLowerCase().contains(title.toLowerCase())) {
	    	System.out.println("title validated true");
	    }
	}


}