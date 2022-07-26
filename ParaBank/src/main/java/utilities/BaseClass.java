package utilities;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

public class BaseClass {
	
	
	public BaseClass() {
		
		//driver = _driver;
		
		
		
	}
	
	
	public static WebDriver driver;
	

	public void openChromeBrowser()throws Exception {

		//if(driver==null) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src/main/resources\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			
			
		}
		
		
//		else {
//			return driver;
//		}
		
	
		
	
		
		
	
	public void closeChromeBrowser() throws Exception {
		driver.quit();
		
	}
	 
	
	
	
public boolean IsDisplayed(By locator) throws Exception {
		
	/*WebDriverWait wt = new WebDriverWait(driver,2);
	wt.until(ExpectedConditions.visibilityOfElementLocated(locator));*/
	
	driver.findElement(locator).isDisplayed();
	
		return true;
		
	}

public boolean IsEnabled(By locator) throws Exception {
	
	/*WebDriverWait wt = new WebDriverWait(driver,2);
	wt.until(ExpectedConditions.visibilityOfElementLocated(locator));*/
	
	driver.findElement(locator).isEnabled();
	
		return true;
		
	}

public void closeBrowser() throws Exception {
	driver.close();
}

public void clickOnElement(By locator)throws Exception {
	
	WebDriverWait wt = new WebDriverWait(driver,30);
	wt.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	//driver.findElement(locator).click();
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

public static WebElement waitForClickablility(By locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public void javaScriptClick(By WebElement) throws Exception{
	
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WebElement);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", WebElement);
}

public void clickUsingActions(By openNewAccountButton)throws Exception {
	
	Actions builder = new Actions(driver);
	builder.click().build().perform();
}
}
