package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.RegistrationPage;
import utilities.BaseClass;

public class RegistrationPageTestClass {

	RegistrationPage reg;
	BaseClass base;
	
	Logger logger = LogManager.getLogger("RegistrationPageTestClass");

	public RegistrationPageTestClass() {
		base = new BaseClass();
		reg = new RegistrationPage();
	}

	@BeforeTest

	public void openBrowser() throws Exception {
		base.openChromeBrowser();
	}

	@Test(priority = 0)
	public void clickOnRegister() throws Exception {

		reg = new RegistrationPage();

		reg.clicksOnRegisterOnHomePage();

	}

	@Test(priority = 1)
	public void verifyThatTheUserIsOnRegistrationPage() throws Exception {
		String pageTitle = reg.verifyThatTheUserIsOnRegistrationPage();
         logger.info(pageTitle);
		Assert.assertTrue(pageTitle.contains("ParaBank"));
	}

	@Test(priority = 2)
	public void enterUserDetails() throws IOException {
		reg.readProperty();
	}

	@Test(priority = 3)
	public void verifyUserRegisteredSuccessfully() throws Exception {
		reg.verifyThatUserRegisteredSuccessfully();
	}

	@Test(priority = 4)
	public void userClicksOnLogoutButton() throws Exception {

		reg.clickOnlogOutButton();
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
