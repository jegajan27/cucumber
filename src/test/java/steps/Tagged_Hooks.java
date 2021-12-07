package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Tagged_Hooks {
	WebDriver driver;
	
	public Tagged_Hooks(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	@After(value = "@chkAfter", order = 0)
	public void removeCookies(){
		System.out.println("In chkAfter Hook");
	}
	
	@Before(value = "@chkBefore", order = 0)
	public void setCookies() {
		System.out.println("In chkHook setCookies");
	}

}
