package stepDefenations;
import java.util.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDef {
	 WebDriver driver=new ChromeDriver();
	 Actions action=new Actions(driver);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   
	 
	 LinkedHashMap<String,String> map=new LinkedHashMap();
	
	@Given("I navigate the home page")
	public void homePage() {
		driver.get("https://pinpoint.idearise.co/");
		driver.manage().window().maximize();
	   
	}
	@After
	@Given("I close the window")
	public void close() {
		driver.close();
	}
	@And ("I click on the login button")
	public void loginpage() {
		driver.findElement(By.xpath("//a[@class='btn btn-home btn-outline-primary']")).click();
	}
	@Then ("I Enter email as (.+) and (.+)$")
	public void loginEmail(String email,String pass) {
		WebElement mailid=driver.findElement(By.xpath("//input[@type='email']"));
		mailid.sendKeys(email);
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys(pass);
		js.executeScript("window.scrollBy(0, 1000)");
		
	}
	@Then ("I click on signin button")
	public void signin() {
		WebElement sign=driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Sign In')]"));
		sign.click();
	}
	@Given ("I navigate to the the dashboard page")
	public void dashboardpage() {
		String dashboard=driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]")).getText();
	    String text="Dashboard";
	    Assert.assertEquals(dashboard, text);
	}
	@Then ("I click on the (.+) tab on left side menu$")
	public void userstab(String tab) throws InterruptedException {
		Thread.sleep(5000);
		WebElement userTab=driver.findElement(By.xpath("//a[contains(text(),'"+tab+"')]"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Users')]")));
         userTab.click();
	}
	@Then ("I enter the user details (.+) and (.+) and (.+) and (.+) and (.+) and (.+)$")
	public void EnterName(String userName,String userEmail,String userEmpId,String userType,String userDept,String userDes) {
		WebElement name=driver.findElement(By.xpath("//label[@for='name']//parent::div//input"));
		name.sendKeys(userName);
		WebElement email=driver.findElement(By.xpath("//label[@for='email']//parent::div//input"));
		name.sendKeys(userEmail);
		WebElement empid=driver.findElement(By.xpath("//label[@for='employeeId']//parent::div//input"));
		name.sendKeys(userEmpId);
		WebElement type=driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select=new Select(type);
        select.selectByVisibleText(userType);
		WebElement dept=driver.findElement(By.xpath("//label[@for='Department']//parent::div//input"));
		name.sendKeys(userDept);
		WebElement des=driver.findElement(By.xpath("//label[@for='Designation']//parent::div//input"));
		name.sendKeys(userDes);
	}
	
	@Then ("I click on create button")
	public void createUser() {
		WebElement createUser=driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		createUser.click();
	}
	
	@Then ("I click on the first record view icon")
		public void firstRecord() throws InterruptedException {
		Thread.sleep(5000);
			WebElement firstRecoed=driver.findElement(By.xpath("(//button[@type='button'])[7]"));
			firstRecoed.click();
		}
	
	@Then ("I update the phone number")
	public void phNumber() {
		WebElement updatePhoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-first-name")));
		updatePhoneNumber.clear();
		updatePhoneNumber.sendKeys("9876543210");
	    String num=updatePhoneNumber.getText();
	    map.put("updatePhoneNumber", num);
	}
	@Then ("I update the Designation")
	public void updateDis() {
		WebElement updateDis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-designation")));
		updateDis.clear();
		updateDis.sendKeys("QA");
		String dis=updateDis.getText();
		map.put("updateDisignation", dis);
	}
	
	@Then ("I click on the update (.+)$")
	public void saveChanges(String update) throws InterruptedException {
		Thread.sleep(2000);
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		 Thread.sleep(4000);
		 WebElement save=driver.findElement((By.xpath("//button[contains(text(),'"+update+"')]")));
		 save.click();
	}
	@Then ("I validate the phone number and Designation")
	public void validateUpdateChanges() {
		WebElement updatePhoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-first-name")));
		WebElement diss=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-designation")));
		String PhoneNumber=updatePhoneNumber.getText();
		String Disignation=diss.getText();
		String Dis=map.get("updateDisignation");
		String ph=map.get("updatePhoneNumber");
		Assert.assertEquals(PhoneNumber, ph);
		Assert.assertEquals(Disignation, Dis);
	}
	
	@Then ("I select the user as (.+)$")
	public void setUser(String user) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='select__input-container css-19bb58m']"));
        ele.click();
	}
	@Then ("I update the company name")
	public void updateCompany() {
		WebElement ele=driver.findElement(By.xpath("//input[@id='input-company-name']"));
		ele.clear();
		ele.sendKeys("Apple");
	}
	
	@Then ("I update the new location")
	public void AddNewlocation() {
		WebElement loc=driver.findElement(By.xpath("//input[@placeholder='Location Name']"));
		loc.clear();
		loc.sendKeys("Hyd");
		WebElement address=driver.findElement(By.xpath("//input[@placeholder='Location Address']"));
		address.clear();
		address.sendKeys("hyd");
	}
	
	@And ("I update the Industry name")
	public void updateInd() {
		WebElement ele=driver.findElement(By.xpath("//input[@id='input-industry']"));
		ele.clear();
		ele.sendKeys("Software");
	}
	@Then ("I save the changes")
	public void savechng() {
		WebElement ele=driver.findElement(By.xpath("//button[contains(text(),'Save All Changes')]"));
		ele.click();
	}
	
	@And ("I click on download button it will downloaded in excel sheet")
	public void downloadbutton() {
		WebElement ele=driver.findElement(By.xpath("//button[contains(text(),'Download')]"));
		ele.click();
	}
	
}