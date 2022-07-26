package Pages;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import utilities.BaseClass;


public class RegistrationPage extends BaseClass {

	By register = By.xpath("//*[text()='Register']");
	By firstName = By.xpath("//*[@id='customer.firstName']");
	By lastName = By.xpath("//*[@id='customer.lastName']");
	By address = By.xpath("//*[@id='customer.address.street']");
	By city = By.xpath("//*[@id='customer.address.city']");

	By state = By.xpath("//*[@id='customer.address.state']");

	By zipCode = By.xpath("//*[@id='customer.address.zipCode']");

	By phoneNumber = By.xpath("//*[@id='customer.phoneNumber']");

	By ssn = By.xpath("//*[@id='customer.ssn']");

	By userName = By.xpath("//*[@id='customer.username']");

	By password = By.xpath("//*[@id = 'customer.password']");

	By confirm = By.xpath("//*[@id = 'repeatedPassword']");

	By submitButton = By.xpath("(// input[@type='submit'])[2]");
	By registeredSuccessfully = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");

	By logOutLink = By.xpath("// *[text()='Log Out']");

	public RegistrationPage() {

	}

	public void clicksOnRegisterOnHomePage() throws Exception {

		clickOnElement(register);

	}

	public String verifyThatTheUserIsOnRegistrationPage() throws Exception {

		return driver.getTitle();

	}

	public void readProperty() throws IOException {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		driver.findElement(firstName).sendKeys(pro.getProperty("FirstName"));
		driver.findElement(lastName).sendKeys(pro.getProperty("LastName"));
		driver.findElement(address).sendKeys(pro.getProperty("Address"));
		driver.findElement(city).sendKeys(pro.getProperty("City"));
		driver.findElement(state).sendKeys(pro.getProperty("State"));
		driver.findElement(zipCode).sendKeys(pro.getProperty("ZipCode"));
		driver.findElement(phoneNumber).sendKeys(pro.getProperty("Phone"));
		driver.findElement(ssn).sendKeys(pro.getProperty("SSN"));
		driver.findElement(userName).sendKeys(pro.getProperty("UserName"));
		driver.findElement(password).sendKeys(pro.getProperty("Password"));
		driver.findElement(confirm).sendKeys(pro.getProperty("Confirm"));
		driver.findElement(submitButton).click();

	}

	public void verifyThatUserRegisteredSuccessfully() throws Exception {

		driver.findElement(registeredSuccessfully).getText();
	}

	public void clickOnlogOutButton() throws Exception {

		logOutButton(logOutLink);
	}

}
