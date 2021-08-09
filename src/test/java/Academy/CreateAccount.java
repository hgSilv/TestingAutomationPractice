package Academy;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.CreateAccPage;

public class CreateAccount extends base{
	@Test
	public void createAccountTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		//WebElement declaration
		HomePage home = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		CreateAccPage accPage = new CreateAccPage(driver);
		//Home page
		home.getLogin().click();
		//Login page
		loginPage.getSignUpEmail().sendKeys("another@test.com");
		loginPage.getCreateAccBtn().click();
		//Account creation Page
		accPage.getGender().click();
		accPage.getFirstName().sendKeys("Random");
		accPage.getLastName().sendKeys("Random");
		accPage.getPassword().sendKeys("rand123");
		accPage.getFirstName4Adrs().sendKeys("Random");
		accPage.getLastName4Adrs().sendKeys("Random");
		accPage.getAddress().sendKeys("Address 123");
		accPage.getCity().sendKeys("Random City");
		new Select(accPage.getState()).selectByVisibleText("New York");;
		accPage.getZipCode().sendKeys("12345");
		accPage.getMobilePhone().sendKeys("1234567890");
		accPage.getRegisterBtn().click();
		//Submited Account for creation
		String expected = "MY ACCOUNT";
		String actual = loginPage.getPageTitle().getText();
		AssertJUnit.assertTrue(expected.equals(actual.toUpperCase()));
		
	}
	
}
