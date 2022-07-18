package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import utilities.BaseClass;

public class RegistrationPage extends BaseClass {

	static WebDriver driver;
	
	//RegistrationPage reg = new RegistrationPage(driver);
	// By register = By.xpath("//*[text()='Register']");
//	By registerPageTitle = By.xpath("//h1[text()='Signing up is easy!']");
//	By firstName = By.id("customer.firstName");
//	By lastName = By.id("customer.lastName");
//	By address = By.id("customer.address.street");
//	By city = By.id("customer.address.city");
//	By state = By.id("customer.address.state");
//	By zipCode = By.id("customer.address.zipCode");
//	By phoneNumber = By.id("customer.phoneNumber");
//	By ssn = By.id("customer.ssn");
//	By userName = By.id("customer.username");
//	By password = By.id("customer.password");
//	By confirm = By.id("repeatedPassword");
//	By submitButton = By.xpath("(//input[@type='submit'])[2]");
//	By registeredSuccessfully = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");
	// By logOut = By.xpath("//*[text()='Log Out']");
	
	

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickOnRegisterOnHomePage() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);
		
		Thread.sleep(60000);

		clickOnElement(By.xpath(pro.getProperty("register")));

	}

	public String verifyThatTheUserIsOnRegistrationPage() throws Exception {

		return driver.getTitle();

	}

	public void readProperty() throws IOException {

		RegistrationPage reg = new RegistrationPage(driver);

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		sendKeys(By.xpath(pro.getProperty("firstName"))).sendKeys(pro.getProperty("FirstName"));
		driver.findElement(By.xpath(pro.getProperty("lastName"))).sendKeys(pro.getProperty("LastName"));
		driver.findElement(By.xpath(pro.getProperty("address"))).sendKeys(pro.getProperty("Address"));
		driver.findElement(By.xpath(pro.getProperty("city"))).sendKeys(pro.getProperty("City"));
		driver.findElement(By.xpath(pro.getProperty("state"))).sendKeys(pro.getProperty("State"));
		driver.findElement(By.xpath(pro.getProperty("zipCode"))).sendKeys(pro.getProperty("ZipCode"));
		driver.findElement(By.xpath(pro.getProperty("phoneNumber"))).sendKeys(pro.getProperty("Phone"));
		driver.findElement(By.xpath(pro.getProperty("ssn"))).sendKeys(pro.getProperty("SSN"));
		driver.findElement(By.xpath(pro.getProperty("username"))).sendKeys(pro.getProperty("UserName"));
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pro.getProperty("Password"));
		driver.findElement(By.xpath(pro.getProperty("confirm"))).sendKeys(pro.getProperty("Confirm"));
		driver.findElement(By.xpath(pro.getProperty("submitButton"))).click();

	}

	

	public void verifyThatUserRegisteredSuccessfully() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");
		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		driver.findElement(By.xpath(pro.getProperty("registeredSuccessfully"))).getText();
	}

	public void clickOnlogOutButton() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		logOutButton(By.xpath(pro.getProperty("logOutLink")));
	}

}
