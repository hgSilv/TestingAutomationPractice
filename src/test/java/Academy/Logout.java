package Academy;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class Logout extends base{

	@Test
	public void LogoutTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		HomePage home = new HomePage(driver);
		//Logouts from any page
		home.getSignOut().click();
		//
		Assert.assertNotNull(home.getLogin());
	}
}
