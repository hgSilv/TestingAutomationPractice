package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccPage {
	
	public WebDriver driver;
	
	//Selectors
	By gender = By.cssSelector("input[id='id_gender1']");
	By firstName = By.cssSelector("input[id='customer_firstname']");
	By lastName = By.cssSelector("input[id='customer_lastname']");
	By password = By.cssSelector("input[id='passwd']");
	By addrs_FirstName = By.cssSelector("input[id='firstname']");
	By addrs_LastName = By.cssSelector("input[id='lastname']");
	By address = By.cssSelector("input[id='address1']");
	By city = By.cssSelector("input[id='city']");
	By zipCode = By.cssSelector("input[id='postcode']");
	By mobilePhone = By.cssSelector("input[id='phone_mobile']");
	By state = By.cssSelector("select[id='id_state']");
	By RegisterBtn = By.cssSelector("button[id='submitAccount']");
	
	public CreateAccPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getGender() {
		return driver.findElement(gender);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getFirstName4Adrs() {
		return driver.findElement(addrs_FirstName);
	}
	
	public WebElement getLastName4Adrs() {
		return driver.findElement(addrs_LastName);
	}
	
	public WebElement getAddress() {
		return driver.findElement(address);
	}
	
	public WebElement getCity() {
		return driver.findElement(city);
	}
	
	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}
	
	public WebElement getMobilePhone() {
		return driver.findElement(mobilePhone);
	}
	
	public WebElement getState() {
		return driver.findElement(state);
	}
	
	public WebElement getRegisterBtn() {
		return driver.findElement(RegisterBtn);
	}
}
