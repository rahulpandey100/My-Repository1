package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.BaseClass;

public class LoginPageTestClass {

	LoginPage loginPage;
	BaseClass base;

	public LoginPageTestClass() {
		base = new BaseClass();
		loginPage = new LoginPage();
	}
	
	Logger logger = LogManager.getLogger("LoginPageTestClass");

	@BeforeTest

	public void openBrowser() throws Exception {
		base.openChromeBrowser();
	}

	@Test(priority = 0)
	public void userLoggedIn() throws Exception {

		loginPage.login();
	}

	@Test(priority = 1)
	public void verifyThatUserLoggedInSuccessfully() throws Exception {

		String customerName = loginPage.loginSuccessfully();

		logger.info("Account Holder Name = " + customerName);

		Assert.assertTrue(customerName.contains("Welcome"));
	}

	@Test(priority = 2)
	public void verifyThatUserCanOpenANewAccount() throws Exception {

		String accountOpeningMessage = loginPage.openANewAccount();
		logger.info(accountOpeningMessage);

		Assert.assertTrue(accountOpeningMessage.contains("Congratulations"));
	}

	@Test(priority = 3)
	public void verifyThatTheNewAccountNumberIsDisplayed() throws Exception {

		String accountNumber = loginPage.getNewAccountNumber();

		logger.info("New Account Number is :" + accountNumber);

	}

	@Test(priority = 4)
	public void verifyTotalAmountWithTheUser() throws Exception {
		String totalAmount = loginPage.verifyTotalAmountInAccountsOverview();

		logger.info("Total Amount With User :" + totalAmount);
	}

	@Test(priority = 5)
	public void getTheTotalTransactionsInADateRange() throws Exception {

		String transactionTable = loginPage.findTheTotalTransactionsInATimeRange();

		logger.info("Transaction Table is displayed :" + transactionTable);
	}

	@Test(priority = 6)
	public void verifyThatTheUserCanApplyForLoan() throws Exception {
		String loanApprovingOrganisation = loginPage.applyForLoan();
		logger.info("Loan Provider :" + loanApprovingOrganisation);

		//Assert.assertTrue(loanApprovingOrganisation.equalsIgnoreCase("Wealth Securities Dynamic Loans (WSDL)"));
	}

	@Test(priority = 7)
	public void verifyTheLoanStatus() throws Exception {
		String loanStatusMessage = loginPage.loanApprovalConfirmation();

		logger.info("Loan approval staus :" + loanStatusMessage);

		Assert.assertTrue(loanStatusMessage.equalsIgnoreCase("Congratulations, your loan has been approved."));
	}

	@Test(priority = 8)
	public void clickOnLogOutLink() throws Exception {
		loginPage.logOut();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) throws Exception {
		base.captureScreenshot(result);
	}

	@AfterTest
	public void closeBrowser() throws Exception {
		base.closeChromeBrowser();
	}
}