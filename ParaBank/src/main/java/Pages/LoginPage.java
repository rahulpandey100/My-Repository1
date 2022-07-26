package Pages;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class LoginPage extends BaseClass {

	By userName = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginButton = By.xpath(" //input[@value='Log In']");
	By accountHolderName = By.xpath("//p[@class='smallText']");
	By openNewAccountLink = By.xpath("//a[text()='Open New Account']");
	By accountTypeSavings = By.xpath("//select[@id='type']/option[2]");
	By existingAccountToTransferFunds = By.xpath("//select[@id='fromAccountId']/option[1]");
	By openNewAccountButton = By.xpath("//div//input[contains(@value,'Open New Account')]");
	By accountOpeningMessage = By.xpath("//p[text()='Congratulations, your account is now open.']");
	By newAccountNumber = By.xpath("//a[@id='newAccountId']");
	By accountsOverviewLink = By.xpath(" //a[text()='Accounts Overview']");
	By totalAmountWithUser = By.xpath("//b[@class='ng-binding']");
	By findTransactionsLink = By.xpath("//a[text()='Find Transactions']");
	By findByDateRangeFrom = By.xpath("//input[@id='criteria.fromDate']");
	By findByDateRangeTo = By.xpath("//input[@id='criteria.toDate']");
	By findTransactionsButton = By.xpath(" (//button[@class='button'])[3]");
	By getTransactionTable = By.tagName("table");
	By requestLoanLink = By.xpath("//a[text()='Request Loan']");
	By loanAmount = By.xpath("//input[@id='amount']");
	By downPayment = By.xpath(" //input[@id='downPayment']");
	By applyNowButton = By.xpath("//input[@value='Apply Now']");
	By loanProvider = By.xpath("//table[@class='form']//tr[1]");
	By loanApprovalConfirmation = By.xpath("//p[text()='Congratulations, your loan has been approved.']");
	By logOutLink = By.xpath("// *[text()='Log Out']");

	public LoginPage() {

	}

	public void login() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		driver.findElement(userName).sendKeys(pro.getProperty("UserName"));
		driver.findElement(password).sendKeys(pro.getProperty("Password"));

		clickOnElement(loginButton);

	}

	public String loginSuccessfully() throws Exception {

		return driver.findElement(accountHolderName).getText();

	}

	public String openANewAccount() throws Exception {

		clickOnElement(openNewAccountLink);
		clickOnElement(accountTypeSavings);
		clickOnElement(existingAccountToTransferFunds);
		// clickOnElement(openNewAccountButton);
		// waitForClickablility(openNewAccountButton, 2);
		// javaScriptClick(openNewAccountButton);
		IsDisplayed(openNewAccountButton); 
		IsEnabled(openNewAccountButton);
		clickOnElement(openNewAccountButton); 
			
//		WebDriverWait wt = new WebDriverWait(driver,30);
//		return wt.until(ExpectedConditions.visibilityOfElementLocated(accountOpeningMessage)).getText();
		return driver.findElement(accountOpeningMessage).getText();

	}

	public String getNewAccountNumber() throws Exception {

		return driver.findElement(newAccountNumber).getText();

	}

	public String verifyTotalAmountInAccountsOverview() throws Exception {

		clickOnElement(accountsOverviewLink);
		return driver.findElement(totalAmountWithUser).getText();

	}

	public String findTheTotalTransactionsInATimeRange() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		clickOnElement(findTransactionsLink);
		driver.findElement(findByDateRangeFrom).sendKeys(pro.getProperty("FindByDateRangeFrom"));
		driver.findElement(findByDateRangeTo).sendKeys(pro.getProperty("FindByDateRangeTo"));
		clickOnElement(findTransactionsButton);
		return driver.findElement(getTransactionTable).getText();
	}

	public String applyForLoan() throws Exception {
		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);

		clickOnElement(requestLoanLink);
		driver.findElement(loanAmount).sendKeys(pro.getProperty("LoanAmount"));
		driver.findElement(downPayment).sendKeys(pro.getProperty("DownPayment"));
		clickOnElement(applyNowButton);
		return driver.findElement(loanProvider).getText();

	}

	public String loanApprovalConfirmation() throws Exception {

		return driver.findElement(loanApprovalConfirmation).getText();

	}

	public void logOut() throws Exception {

		clickOnElement(logOutLink);
	}

}
