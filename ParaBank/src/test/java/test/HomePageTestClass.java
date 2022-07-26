package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import utilities.BaseClass;

public class HomePageTestClass {

	public HomePageTestClass() {

		base = new BaseClass();
		hp = new HomePage();

	}

	HomePage hp;
	BaseClass base;

	Logger logger = LogManager.getLogger(HomePageTestClass.class);

	@BeforeTest
	public void openBrowser() throws Exception {
		base.openChromeBrowser();
	}

	@Test
	public void verifyTheHomePageTitle() throws Exception {

		String homePageTitle = hp.getHomePageTitle();

		logger.info(homePageTitle);

		Assert.assertTrue(homePageTitle.contains("Welcome"));

	}

	@Test
	public void verifyTheTextOnHomePage() throws Exception {

		String homePageText = hp.verifyTextOnHomePage();

		logger.info(homePageText);

		Assert.assertTrue(homePageText.contains("Customer Login"));

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
