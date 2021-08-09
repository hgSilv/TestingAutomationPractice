package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

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
		AssertJUnit.assertNotNull(home.getLogin());
	}
}
