package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	By signin = By.cssSelector("a[class*='login']");
	By signOutBtn = By.cssSelector("a[class='logout']");
	By pageLogo = By.cssSelector("a[title='My Store']");
	By productCards = By.xpath("//*[@id=\"homefeatured\"]/li");
	By addCartBtn = By.cssSelector("a[title='Add to cart']");
	By continueShoppingBtn = By.cssSelector("span[title='Continue shopping']");
	By cartDropDown = By.cssSelector("a[title='View my shopping cart']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getSignOut() {
		return driver.findElement(signOutBtn);
	}
	
	public WebElement getPageLogo() {
		return driver.findElement(pageLogo);
	}
	
	public WebElement getShoppingBtn() {
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCart() {
		return driver.findElement(cartDropDown);
	}
	
	public List<WebElement> getAddCartBtns() {
		return driver.findElements(addCartBtn);
	}
	
	public List<WebElement> getProductCards() {
		return driver.findElements(productCards);
	}
}
