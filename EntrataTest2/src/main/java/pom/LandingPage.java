package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	@FindBy(xpath = "//a[@id='cookie-accept']")	private WebElement acceptCookiesButton;
	@FindBy(xpath = "(//div[@class='button-text'])[1]")	private WebElement watchDemoButton;
	@FindBy(xpath = "//div[text()='Products']")	private WebElement productsButton;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAcceptCookiesButton() {
		acceptCookiesButton.click();
	}

	public void hoverOnProductsButton() {
		productsButton.sendKeys("lg soundbar");
	}

	public void clickOnWatchDemoButton() {
		watchDemoButton.click();
	}

}
