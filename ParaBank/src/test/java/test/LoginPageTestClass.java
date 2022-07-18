package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.BaseClass;

public class LoginPageTestClass {

	WebDriver driver;
	LoginPage loginPage;
	BaseClass base;

	@BeforeTest

	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src/main/resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

	}

	@Test(priority = 0)
	public void userLoggedIn() throws Exception {

		loginPage.login();
	}

	@Test(priority = 1)
	public void verifyThatUserLoggedInSuccessfully() throws Exception {

		String customerName = loginPage.loginSuccessfully();

		System.out.println("Account Holder Name = " + customerName);

		Assert.assertTrue(customerName.contains("Welcome"));
	}

	@Test(priority = 2)
	public void verifyThatUserCanOpenANewAccount() throws Exception {

		String accountOpeningMessage = loginPage.openANewAccount();
		System.out.println(accountOpeningMessage);

		Assert.assertTrue(accountOpeningMessage.contains("Congratulations"));
	}

	@Test(priority = 3)
	public void verifyThatTheNewAccountNumberIsDisplayed() throws Exception {

		String accountNumber = loginPage.getNewAccountNumber();

		System.out.println("New Account Number is :" + accountNumber);

	}

	@Test(priority = 4)
	public void verifyTotalAmountWithTheUser() throws Exception {
		String totalAmount = loginPage.verifyTotalAmountInAccountsOverview();

		System.out.println("Total Amount With User :" + totalAmount);
	}

	@Test(priority = 5)
	public void getTheTotalTransactionsInADateRange() throws Exception {

		String transactionTable = loginPage.findTheTotalTransactionsInATimeRange();

		System.out.println("Transaction Table is displayed :" + transactionTable);
	}

	@Test(priority = 6)
	public void verifyThatTheUserCanVerifyForLoan() throws Exception {
		String loanApprovingOrganisation = loginPage.applyForLoan();
		System.out.println("Loan Provider :" + loanApprovingOrganisation);

		Assert.assertTrue(loanApprovingOrganisation.equalsIgnoreCase("Wealth Securities Dynamic Loans (WSDL)"));
	}

	@Test(priority = 7)
	public void verifyTheLoanStatus() throws Exception {
		String loanApprovalMessage = loginPage.loanApprovalConfirmation();

		System.out.println("Loan approval staus :" + loanApprovalMessage);

		Assert.assertTrue(loanApprovalMessage.equalsIgnoreCase("Congratulations, your loan has been approved."));
	}

	@Test(priority = 8)
	public void clickOnLogOutLink() throws Exception {
		loginPage.logOut();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) throws Exception {
		base.captureScreenshot(result);
	}

	public void tearDown() throws Exception {
		driver.quit();

	}
}