package Academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\102333781\\eclipse-workspace\\E2EProject\\src\\main\\java\\Academy\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) { // chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\102333781\\Desktop\\Borc\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		else if(browserName == "firefox") { //firefox
			
		}
		
		else if(browserName == "IE") { //IE
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
