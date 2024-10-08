package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//a[@title=\"My Account\"]")  WebElement linkMyAccount;
	@FindBy(xpath="//a[text()='Register']")    WebElement linkRegister;
	@FindBy(xpath="//a[text()='Login']/parent::li") WebElement linkLogin;
	
	
	
	
	//Action methods
	public void clkMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void clkRegister()
	{
		linkRegister.click();
	}
	public void clkLogin()
	{
		linkLogin.click();
	}


}
