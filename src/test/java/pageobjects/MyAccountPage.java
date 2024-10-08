package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccountPagetxt;
	
	
	//ActionMethods
	public boolean isMyAccountPageExists()
	{
		try {
		return(myAccountPagetxt.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

}
