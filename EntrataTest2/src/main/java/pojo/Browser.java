package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

   public static WebDriver launchChrome () {
	   
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver = new ChromeDriver ();
	   driver.get("https://www.entrata.com");
	   driver.manage().window().maximize();
	   return driver;    
   }
	
}
