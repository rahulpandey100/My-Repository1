package utilities;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

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

public void sendKeys(By locator,String a)throws Exception{
	driver.findElement(locator).sendKeys(a);
	
}

public WebElement sendKeys(By loc) {
	
	return null;
}

public void clickOnElement(String loc) throws Exception {
	
	driver.findElement(By.xpath(loc)).click();
}

public void logOutButton(By logOut)throws Exception {
	
	driver.findElement((logOut)).click();
}

public void captureScreenshot(ITestResult result) throws Exception{
	if(ITestResult.FAILURE == result.getStatus()) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source,new File("./Screenshots/"+result.getName()+".png"));
		System.out.println(result.getName()+"method()Screenshot Captured");
	}
}
}
