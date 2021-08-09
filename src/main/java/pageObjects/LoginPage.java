package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

public WebDriver driver;
	
	//Selectors
	By email = By.cssSelector("input[id='email']");
	By passwd = By.cssSelector("input[id='passwd']");
	By signUpEmail = By.cssSelector("[id='email_create']");
	By signInBtn = By.cssSelector("button[id='SubmitLogin']");
	By signOutBtn = By.cssSelector("a[class='logout']");
	By pageTitle = By.cssSelector("h1[class='page-heading']");
	By createAccBtn = By.cssSelector("button[id='SubmitCreate']");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Getters
	public WebElement getLoginEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getLoginPasswd()
	{
		return driver.findElement(passwd);
	}
	
	public WebElement getSignUpEmail()
	{
		return driver.findElement(signUpEmail);
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(signInBtn);
	}
	
	public WebElement getPageTitle() {
		return driver.findElement(pageTitle);
	}
	
	public WebElement getSignOutbtn() {
		return driver.findElement(signOutBtn);
	}
	
	public WebElement getCreateAccBtn() {
		return driver.findElement(createAccBtn);
	}
}
