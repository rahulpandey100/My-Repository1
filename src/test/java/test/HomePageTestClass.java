package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTestClass {

	WebDriver driver;
	HomePage hp;

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
	public void verifyTheHomePageTitle() throws Exception {

		hp = new HomePage(driver);

		String homePageTitle = hp.getHomePageTitle();

		System.out.println(homePageTitle);

		Assert.assertTrue(homePageTitle.contains("Welcome"));

	}

	@Test(priority = 1)
	public void verifyTheTextOnHomePage() {

		String homePageText = hp.verifyTextOnHomePage();

		System.out.println(homePageText);

		Assert.assertTrue(homePageText.contains("Customer Login"));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
