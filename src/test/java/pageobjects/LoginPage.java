package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath ="//input[@name=\"email\"]") WebElement txtEnterEmail;
	@FindBy(xpath="//input[@name=\"password\"]")WebElement txtPassword;
	@FindBy(xpath="//input[@type=\"submit\"]") WebElement btnLogin;
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']") WebElement alertMsg;
	
	
	//Action methods
	public void enterEmail(String emailFiled)
	{
		txtEnterEmail.sendKeys(emailFiled);
	}
	
	public void enterPassword(String pwdField)
	{
		txtPassword.sendKeys(pwdField);
	}
	public void clickLoginButton()
	{
		btnLogin.click();
	}
	public String getLoginErrorMessage()
	{
		try {
            return alertMsg.getText(); // Returns the text of the error message element
        } catch (Exception e) {
            return e.getMessage(); // Return the exception message if something goes wrong
        }
	}
	

}
