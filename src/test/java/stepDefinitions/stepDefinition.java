package stepDefinitions;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;
import pageObjects.CreateAccPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


@RunWith(Cucumber.class)
public class stepDefinition{
	WebDriver driver;
	
	@Given("^User is on \"([^\"]*)\"$")
    public void user_is_on_homePage(String homePage) throws Throwable {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\102333781\\Desktop\\Borc\\chromedriver.exe");
		driver = new ChromeDriver();*/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.get(homePage);
    }

    @When("^User navigates to sign in$")
    public void user_navigates_to_sign_in() throws Throwable {
    	HomePage home = new HomePage(driver);
    	home.getLogin().click();
    }

    @Then("^User provides \"([^\"]*)\" and clicks create account button$")
    public void user_provides_email_and_clicks_create_account_button(String email) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getSignUpEmail().sendKeys(email);
		loginPage.getCreateAccBtn().click();
    }

    @And("^User provides information to Register with$")
    public void user_provides_information_to_register_with() throws Throwable {
    	CreateAccPage accPage = new CreateAccPage(driver);
    	accPage.getGender().click();
		accPage.getFirstName().sendKeys("Juan");
		accPage.getLastName().sendKeys("Perez");
		accPage.getPassword().sendKeys("random");
		accPage.getFirstName4Adrs().sendKeys("Juan");
		accPage.getLastName4Adrs().sendKeys("Perez");
		accPage.getAddress().sendKeys("Address 123");
		accPage.getCity().sendKeys("Random City");
		new Select(accPage.getState()).selectByVisibleText("New York");;
		accPage.getZipCode().sendKeys("12345");
		accPage.getMobilePhone().sendKeys("1234567890");
		accPage.getRegisterBtn().click();
    }

    @Then("^page shows success message$")
    public void page_shows_success_message() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
    	String expected = "MY ACCOUNT";
		String actual = loginPage.getPageTitle().getText();
		Assert.assertTrue(expected.equals(actual.toUpperCase()));
    }
    
    @And("^User provides \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void user_provides_email_and_password_to_login(String email, String passwd) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.getLoginEmail().sendKeys(email);
		loginPage.getLoginPasswd().sendKeys(passwd);
		loginPage.getSignInButton().click();
    }
    
    @Then("^User adds some products to cart$")
    public void user_adds_some_products_to_cart() throws Throwable {
    	WebDriverWait w = new WebDriverWait(driver, 10);
    	HomePage home = new HomePage(driver);
    	List<WebElement> addCartBtns = home.getAddCartBtns(); //If you list all addToCart btns, there are some that are hidden
		List<WebElement> productCards = home.getProductCards();//We get the ammount of product cards in order to know how many active addToCart btns are active
		
		//Adding products to cart
		for(int i = 0; i<productCards.size(); i++) {
			w.until(ExpectedConditions.elementToBeClickable(addCartBtns.get(i)));
			addCartBtns.get(i).click();
			w.until(ExpectedConditions.elementToBeClickable(home.getShoppingBtn()));
			home.getShoppingBtn().click();
			w.until(ExpectedConditions.invisibilityOf(home.getShoppingBtn()));
		}
    }

    @Then("^User continues to signin$")
    public void user_continues_to_signin() throws Throwable {
    	WebDriverWait w = new WebDriverWait(driver, 10);
		CheckoutPage choPage = new CheckoutPage(driver);

    	w.until(ExpectedConditions.elementToBeClickable(choPage.getSmryCheckoutBtn()));
		choPage.getSmryCheckoutBtn().click();
    }

    @Then("^User checks address$")
    public void user_checks_address() throws Throwable {
    	WebDriverWait w = new WebDriverWait(driver, 10);
		CheckoutPage choPage = new CheckoutPage(driver);

    	w.until(ExpectedConditions.elementToBeClickable(choPage.getAdrsCheckoutBtn()));
		choPage.getAdrsCheckoutBtn().click();
    }

    @Then("^User sets up shipping$")
    public void user_sets_up_shipping() throws Throwable {
		CheckoutPage choPage = new CheckoutPage(driver);
		choPage.getAgreeToS().click();
    }

    @Then("^proceeds to Payment$")
    public void proceeds_to_payment() throws Throwable {
		CheckoutPage choPage = new CheckoutPage(driver);

		choPage.getShipCheckoutBtn().click();
    }

    @Then("^page returns order confirmation$")
    public void page_returns_order_confirmation() throws Throwable {
		CheckoutPage choPage = new CheckoutPage(driver);

    	Assert.assertTrue(choPage.getOrderSuccess().getText().equals("Your order on My Store is complete."));
    }

    @And("^proceeds to checkout$")
    public void proceeds_to_checkout() throws Throwable {
    	HomePage home = new HomePage(driver);
    	Assert.assertTrue(home.getCart().getText().equals("Cart 7 Products"));
		home.getCart().click();
    }

    @And("^provides \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void provides_something_and_something_to_login(String strArg1, String strArg2) throws Throwable {
		WebDriverWait w = new WebDriverWait(driver, 10);
		LoginPage login = new LoginPage(driver);

    	w.until(ExpectedConditions.elementToBeClickable(login.getLoginEmail()));
		login.getLoginEmail().sendKeys("random@test.com");
		login.getLoginPasswd().sendKeys("random");
		login.getSignInButton().click();
    }


    @And("^User selects payment method to confirm order$")
    public void user_selects_payment_method_to_confirm_order() throws Throwable {
		CheckoutPage choPage = new CheckoutPage(driver);

    	choPage.getPayBankWire().click();
		choPage.getSubmitOrder().click();
    }
    
    @Then("^User clicks sign out button$")
    public void user_clicks_sign_out_button() throws Throwable {
    	HomePage home = new HomePage(driver);
    	home.getSignOut().click();
    }
    
    @And("^page ends session$")
    public void page_ends_session() throws Throwable {
    	HomePage home = new HomePage(driver);
    	Assert.assertNotNull(home.getLogin());
    }
}
