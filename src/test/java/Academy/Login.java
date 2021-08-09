package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Login extends base{

	@Test(dataProvider="getData")
	public void loginTest(String Username, String Password) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		//WebElement declaration
		HomePage home = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		//Home Page
		home.getLogin().click();
		//Trying to log in
		loginPage.getLoginEmail().sendKeys(Username);
		loginPage.getLoginPasswd().sendKeys(Password);
		loginPage.getSignInButton().click();
		//Logged in
		String expected = "MY ACCOUNT";
		String actual = loginPage.getPageTitle().getText();
		Assert.assertTrue(expected.equals(actual.toUpperCase()));
	
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		
		data[0][0] = "random@test.com";
		data[0][1] = "random";
		
		//data[1][0] = "another@test.com";
		//data[1][1] = "passwd";
		
		return data;
		
	}
}
