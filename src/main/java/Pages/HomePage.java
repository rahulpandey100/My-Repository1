package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By customerLoginText = By.xpath("//h2[text()='Customer Login']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() throws Exception {

		return driver.getTitle();
	}

	public String verifyTextOnHomePage() {
		return driver.findElement(customerLoginText).getText();

	}

}
