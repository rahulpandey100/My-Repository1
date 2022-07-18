package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	// By customerLoginText = By.xpath("//h2[text()='Customer Login']");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getHomePageTitle() throws Exception {

		return driver.getTitle();
	}

	public String verifyTextOnHomePage() throws Exception {

		File src = new File("C:\\Users\\Rahul Pandey\\eclipse-workspace\\ParaBank\\Repository\\TestData.properties");

		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();

		pro.load(fis);
		return driver.findElement(By.xpath(pro.getProperty("customerLoginText"))).getText();

	}

}
