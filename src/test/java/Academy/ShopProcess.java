package Academy;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ShopProcess extends base{
	
	@Test
	public void shopProcessTest() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		WebDriverWait w = new WebDriverWait(driver, 10);
		//WebElement declarations
		
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		CheckoutPage choPage = new CheckoutPage(driver);
		List<WebElement> addCartBtns = home.getAddCartBtns(); //If you list all addToCart btns, there are some that are hidden
		List<WebElement> productCards = home.getProductCards();//We get the ammount of product cards in order to know how many active addToCart btns are active
		//HomePage
		
		//Adding products to cart
		for(int i = 0; i<productCards.size(); i++) {
			w.until(ExpectedConditions.elementToBeClickable(addCartBtns.get(i)));
			addCartBtns.get(i).click();
			w.until(ExpectedConditions.elementToBeClickable(home.getShoppingBtn()));
			home.getShoppingBtn().click();
			w.until(ExpectedConditions.invisibilityOf(home.getShoppingBtn()));
		}
		
		Assert.assertTrue(home.getCart().getText().equals("Cart 7 Products"));
		home.getCart().click();
		w.until(ExpectedConditions.elementToBeClickable(choPage.getSmryCheckoutBtn()));
		choPage.getSmryCheckoutBtn().click();
		//Login
		w.until(ExpectedConditions.elementToBeClickable(login.getLoginEmail()));
		login.getLoginEmail().sendKeys("random@test.com");
		login.getLoginPasswd().sendKeys("random");
		login.getSignInButton().click();
		//Address
		w.until(ExpectedConditions.elementToBeClickable(choPage.getAdrsCheckoutBtn()));
		choPage.getAdrsCheckoutBtn().click();
		//Shipping
		choPage.getAgreeToS().click();
		choPage.getShipCheckoutBtn().click();
		//Payment
		choPage.getPayBankWire().click();
		choPage.getSubmitOrder().click();
		Assert.assertTrue(choPage.getOrderSuccess().getText().equals("Your order on My Store is complete."));
		//System.out.println(choPage.getOrderSuccess().getText());
	}
}
