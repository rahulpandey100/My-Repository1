package Pages;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;
	LoginPage lp = new LoginPage(driver);

	By accountHolderName = By.xpath("//p[@class='smallText']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public void login() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		driver.findElement(By.xpath(pro.getProperty("userName"))).sendKeys("UserName");
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys("Password");

		lp.clickOnElement(pro.getProperty("loginButton"));

	}

	public String loginSuccessfully() throws Exception {

		return driver.findElement(accountHolderName).getText();
	}

	public String openANewAccount() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		lp.clickOnElement(pro.getProperty("openNewAccount"));
		lp.clickOnElement(pro.getProperty("accountTypeSavings"));
		lp.clickOnElement(pro.getProperty("existingAccountToTransferFunds"));
		lp.clickOnElement(pro.getProperty("openNewAccountButton"));
		return driver.findElement(By.xpath(pro.getProperty("accountOpeningMessage"))).getText();

	}

	public String getNewAccountNumber() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		return driver.findElement(By.xpath(pro.getProperty("newAccountNumber"))).getText();

	}

}
