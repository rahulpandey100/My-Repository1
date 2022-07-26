package Pages;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class HomePage extends BaseClass {

	By customerLoginText = By.xpath("//h2[text()='Customer Login']");

	public HomePage() {

	}

	public String getHomePageTitle() throws Exception {

		return driver.getTitle();
	}

	public String verifyTextOnHomePage() throws Exception {

		return driver.findElement(customerLoginText).getText();

	}

}
