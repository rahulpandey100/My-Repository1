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
	LoginPage lp;
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
	
	@Test(priority=0)
	public void userLoggedIn() throws Exception {
		
		lp.login();
	}
	
	@Test(priority=1)
	public void verifyThatUserLoggedInSuccessfully() throws Exception {
		
		String customerName = lp.loginSuccessfully();
		
		System.out.println("Account Holder Name = "+customerName);
		
		Assert.assertTrue(customerName.contains("Welcome"));
	}
	
	@Test(priority=2)
	public void verifyThatUserCanOpenANewAccount() throws Exception{
		
		String accountOpeningMessage = lp.openANewAccount();
		System.out.println(accountOpeningMessage);
		
		Assert.assertTrue(accountOpeningMessage.contains("Congratulations"));
	}
	
	@Test(priority=3)
	public void verifyThatTheNewAccountNumberIsDisplayed() throws Exception {
		
		String accountNumber = lp.getNewAccountNumber();
		
		System.out.println("New Account Number is :"+accountNumber);
		
		
	}
	
	@Test(priority=4)
	public void verifyTotalAmountWithTheUser()throws Exception{
		String totalAmount=lp.verifyTotalAmountInAccountsOverview();
		
		System.out.println("Total Amount With User :"+totalAmount);
	}
	
	@Test(priority=5)
	public void getTheTotalTransactionsInADateRange()throws Exception{
		
		String transactionTable= lp.findTheTotalTransactionsInATimeRange();
		
		System.out.println("Transaction Table is displayed :"+transactionTable);
	}
	
	@Test(priority=6)
	public void verifyThatTheUserCanVerifyForLoan()throws Exception{
		lp.applyForLoan();
	}
	
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result)throws Exception{
		base.captureScreenshot(result);
	}

}
