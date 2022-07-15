package test;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.RegistrationPage;


public class RegistrationPageTestClass {

	WebDriver driver;
	RegistrationPage reg;
	

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
	public void clickOnRegister() throws Exception {

		
			reg=new RegistrationPage(driver);
			
				reg.clickOnRegisterOnHomePage();
		
			
			
		}
		
	

	@Test(priority = 1)
	public void verifyThatTheUserIsOnRegistrationPage() throws Exception {
		String pageTitle = reg.verifyThatTheUserIsOnRegistrationPage();

		Assert.assertTrue(pageTitle.contains("ParaBank"));
	}

	@Test(priority = 2)
	public void enterUserDetails() throws IOException {
		reg.readProperty();
	}
	
	@Test(priority = 3)
	public void verifyUserRegisteredSuccessfully()throws Exception {
		reg.verifyThatUserRegisteredSuccessfully();
	}
	
	@Test(priority = 4)
	public void userClicksOnLogoutButton() throws Exception {
		
		reg.clickOnlogOutButton();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
