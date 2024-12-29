package testRunner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.cucumber.core.cli.Main;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"stepDefenations"},
plugin= {"pretty","html:target/cucumber-reports/CucumberReport.html",
		           "json:target/cucumber-reports/CucumberReport.json"},
             monochrome=true)
public class TestRunner  {

}
