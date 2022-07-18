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

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		return;
	}

	public void login() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		driver.findElement(By.xpath(pro.getProperty("userName"))).sendKeys(pro.getProperty("UserName"));
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pro.getProperty("Password"));

		lp.clickOnElement(By.xpath(pro.getProperty("loginButton")));

	}

	public String loginSuccessfully() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		return driver.findElement(By.xpath(pro.getProperty("accountHolderName"))).getText();
	}

	public String openANewAccount() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		lp.clickOnElement(By.xpath(pro.getProperty("openNewAccountLink")));
		lp.clickOnElement(By.xpath(pro.getProperty("accountTypeSavings")));
		lp.clickOnElement(By.xpath(pro.getProperty("existingAccountToTransferFunds")));
		lp.clickOnElement(By.xpath(pro.getProperty("openNewAccountButton")));
		return driver.findElement(By.xpath(pro.getProperty("accountOpeningMessage"))).getText();

	}

	public String getNewAccountNumber() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		return driver.findElement(By.xpath(pro.getProperty("newAccountNumber"))).getText();

	}

	public String verifyTotalAmountInAccountsOverview() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		lp.clickOnElement(By.xpath(pro.getProperty("accountsOverviewLink")));
		return driver.findElement(By.xpath(pro.getProperty("totalAmountWithUser"))).getText();

	}

	public String findTheTotalTransactionsInATimeRange() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		lp.clickOnElement(By.xpath(pro.getProperty("findTransactionsLink")));
		driver.findElement(By.xpath(pro.getProperty("findByDateRangeFrom")))
				.sendKeys(pro.getProperty("FindByDateRangeFrom"));
		driver.findElement(By.xpath(pro.getProperty("findByDateRangeTo")))
				.sendKeys(pro.getProperty("FindByDateRangeTo"));
		lp.clickOnElement(By.xpath(pro.getProperty("findTransactionsButton")));
		return driver.findElement(By.xpath(pro.getProperty("getTransactionTable"))).getText();
	}

	public void applyForLoan() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		lp.clickOnElement(By.xpath(pro.getProperty("requestLoanLink")));
		driver.findElement(By.xpath(pro.getProperty("loanAmount"))).sendKeys(pro.getProperty("LoanAmount"));
		driver.findElement(By.xpath(pro.getProperty("downPayment"))).sendKeys(pro.getProperty("DownPayment"));
		lp.clickOnElement(By.xpath(pro.getProperty("applyNowButton")));
	}
	
	public void logOut()throws Exception{
		
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);
		
		clickOnElement(By.xpath(pro.getProperty("logOutLink")));
	}

}
