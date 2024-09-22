package Test;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import utility.BaseClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EntrataTests extends BaseClass {

	//Invokes browser before every test
	@BeforeMethod       
	public void openBrowser() {
		driver = Browser.launchChrome();
	}

	@Test (description = "This test validates some of the Entrata products")
	public void findProductTest() throws InterruptedException {

		//accepting allow cookies popup
		WebElement acceptCookiesButton = driver.findElement(By.xpath("//a[@id=\'cookie-accept\']"));
		acceptCookiesButton.click();

		//getting product from list
		WebElement residentPayProduct = driver.findElement(By.xpath("(//a[text()='ResidentPay'])[3]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", residentPayProduct);

		String actualProduct1 = residentPayProduct.getText();

		WebElement utilityExpenseManagementProduct = driver.findElement(By.xpath("(//a[text()='Utility Expense Management'])[3]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", utilityExpenseManagementProduct);
		
		String actualProduct2 = utilityExpenseManagementProduct.getText();
		
		WebElement facilityManagementProdcut = driver.findElement(By.xpath("(//a[text()='Facility Management'])[3]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", facilityManagementProdcut);
		
		String actualProduct3 = facilityManagementProdcut.getText();

		System.out.println(actualProduct1);
		System.out.println(actualProduct2);
		System.out.println(actualProduct3);

		//close the driver
		driver.quit();
	}

	@Test (description = "This test validates how Entrata makes properties more efficient by redirecting to watch video of Entrata webinar")
	public void seeHowItWorksTest() throws InterruptedException {

		//accepting allow cookies popup
		WebElement acceptCookiesButton = driver.findElement(By.xpath("//a[@id=\'cookie-accept\']"));
		
		acceptCookiesButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement seeHowItWorksButton = driver.findElement(By.xpath("//div[text()='See How it Works']"));
		
		//explicit wait for see how it works button
		wait.until(ExpectedConditions.visibilityOf(seeHowItWorksButton));

		// mouse hover on seehowitworks button
		Actions actions = new Actions(driver);
		
		actions.moveToElement(seeHowItWorksButton).perform();

		//explicitly clicking on seehowitworks button using JavascriptExecutor 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeHowItWorksButton);
		
		js.executeScript("arguments[0].click();", seeHowItWorksButton);

		WebElement watchNowButton = driver.findElement(By.xpath("//div[text()='Watch Now']"));
		
		wait.until(ExpectedConditions.visibilityOf(watchNowButton));

		//explicitly clicking on watchNowButton button using JavascriptExecutor 
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchNowButton);
		
		js1.executeScript("arguments[0].click();", watchNowButton);

		//getwindowhandles will return Set(Interface) of String
		Set<String> handles = driver.getWindowHandles();
		
		//by using iterator method of set, it will return iterator interface
		Iterator<String> i = handles.iterator();

		//handling child browser element and validating it
		while (i.hasNext()) {
			String handle = i.next();
			driver.switchTo().window(handle);
			String expectedTitle = "The Total Economic Impact™ of Entrata";
			String actualTitle = driver.getTitle();

			if (expectedTitle.equals(actualTitle)) {
				//expected page element and assertion
				String actualPageText = driver.findElement(By.xpath("//*[@id=\"lsgkdasd\"]/div/p[1]")).getText();
				String expectedPageText = "In 2023, Entrata commissioned Forrester Consulting, a leading global market research firm, to examine the potential return on investment enterprises may realize by deploying Entrata.";
				Assert.assertEquals(actualPageText, expectedPageText);
			}
		}
        //close the driver
		driver.quit();
	}

	@Test (description = "This test validates the form submission for watching the demo")
	public void watchDemo() throws InterruptedException {

		//acccepting allow cookies popup
		WebElement acceptCookiesButton = driver.findElement(By.xpath("//a[@id=\'cookie-accept\']"));
		
		acceptCookiesButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		WebElement watchDemoButton = driver.findElement(By.xpath("//div[text()='Watch Demo']"));

		wait.until(ExpectedConditions.visibilityOf(watchDemoButton));

		//explicitly clicking on watch demo button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchDemoButton);
		
		js.executeScript("arguments[0].click();", watchDemoButton);

		//submission form for demo
		driver.findElement(By.id("FirstName")).sendKeys("Balu");
		driver.findElement(By.id("LastName")).sendKeys("Sonawane");
		driver.findElement(By.id("Email")).sendKeys("balusonawane132@gmail.com");
		driver.findElement(By.id("Company")).sendKeys("Entrata");
		driver.findElement(By.id("Phone")).sendKeys("8433516813");
		driver.findElement(By.id("Title")).sendKeys("SDET");
		driver.findElement(By.xpath("//button[@type='submit']"));

		//verifying the error validation message after form submission
		WebElement element = driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		String msg = element.getAttribute("validationMessage");
		
		System.out.println(msg);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		js.executeScript("arguments[0].click();", element);

		//close the driver
		driver.quit();

	}
}
