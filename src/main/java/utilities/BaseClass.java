package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public BaseClass() {
		
	}
	
	static WebDriver driver;
	
	
	
public boolean IsDisplayed(By locator) throws Exception {
		
	/*WebDriverWait wt = new WebDriverWait(driver,2);
	wt.until(ExpectedConditions.visibilityOfElementLocated(locator));*/
	
		return true;
		
	}

public void closeBrowser() {
	driver.close();
}

public void clickOnElement(By locator)throws Exception {
	driver.findElement(locator).click();
}

public String sendKeys(By locator,String a)throws Exception{
	driver.findElement(locator).sendKeys(a);
	return a;
}

public void clickOnElement(String loc) throws Exception {
	
	driver.findElement(By.xpath(loc)).click();
}

public void logOutButton(By logOut)throws Exception {
	
	driver.findElement((logOut)).click();
}
}
