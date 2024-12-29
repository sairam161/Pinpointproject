package stepDefenations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	WebDriver driver;
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
