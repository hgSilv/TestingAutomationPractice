package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

	public WebDriver driver;
	
	By checkoutBtn = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	By address_checkoutBtn = By.cssSelector("button[name='processAddress']");
	By agreeToS = By.cssSelector("input[id='cgv']");
	By shipping_checkoutBtn = By.cssSelector("button[name='processCarrier']");
	By payBankWire = By.cssSelector("a[title='Pay by bank wire']");
	By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button");
	By orderComplete = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
	
	
	public CheckoutPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSmryCheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
	
	public WebElement getAdrsCheckoutBtn() {
		return driver.findElement(address_checkoutBtn);
	}
	
	public WebElement getAgreeToS() {
		return driver.findElement(agreeToS);
	}
	
	public WebElement getShipCheckoutBtn() {
		return driver.findElement(shipping_checkoutBtn);
	}
	
	public WebElement getPayBankWire() {
		return driver.findElement(payBankWire);
	}
	
	public WebElement getSubmitOrder() {
		return driver.findElement(confirmOrder);
	}
	
	public WebElement getOrderSuccess() {
		return driver.findElement(orderComplete);
	}
}
