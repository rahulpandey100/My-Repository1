package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginPageTestClass {
	
	WebDriver driver;
	LoginPage lp;
	
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

}
