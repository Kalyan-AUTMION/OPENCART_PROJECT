package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}	
	
	//locators
	
	@FindBy(xpath="//input[@name=\"firstname\"]") WebElement txtFirstName;
	@FindBy(xpath="//input[@name=\"lastname\"]") WebElement txtLastName;
	@FindBy(xpath="//input[@name=\"email\"]") WebElement txtEmail;
	@FindBy(xpath="//input[@name=\"telephone\"]") WebElement txtTelephone;
	@FindBy(xpath="//input[@name=\"password\"]") WebElement txtPassword;
	@FindBy(xpath="//input[@name=\"confirm\"]") WebElement txtconfirmPassword;
	@FindBy(xpath="//input[@type=\"checkbox\"]") WebElement chkPrivacyPolicy;
	@FindBy(xpath="//input[@value=\"Continue\"]") WebElement btnContinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")WebElement confirmMsg;

	//ActionMethods
	
	public void enterFirstName(String fName)
	{
		txtFirstName.sendKeys(fName);
	}
	
	public void enterLastName(String LName)
	{
		txtLastName.sendKeys(LName);
	}
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void enterTelephoneNum(String telephoneNum)
	{
		txtTelephone.sendKeys(telephoneNum);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String confirmPwd)
	{
		txtconfirmPassword.sendKeys(confirmPwd);
	}
	
	public void clkPrivacyPolicy()
	{
		chkPrivacyPolicy.click();
	}
	
	public void clkBtnContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmMsg()
	{
		try {
		return(confirmMsg.getText());
		}catch (Exception e)
		{
			return e.getMessage();
		}
	
	
	}
	
	


	
	
	
	//Action methods
	

}
