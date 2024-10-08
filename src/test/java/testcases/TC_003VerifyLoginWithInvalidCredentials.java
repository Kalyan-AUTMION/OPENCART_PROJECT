package testcases; // Ensure this package matches the folder structure

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.DataProviders;

public class TC_003VerifyLoginWithInvalidCredentials extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class,groups= {"datadriven","master"})
	public void verifyLoginWithInvalidCredentials(String email, String password, String expectedMessage) {
	    try {
	        HomePage hp = new HomePage(driver);
	        hp.clkMyAccount();
	        hp.clkLogin();

	        LoginPage lp = new LoginPage(driver);
	        lp.enterEmail(email);
	        lp.enterPassword(password);
	        lp.clickLoginButton();

	        String actualMessage = lp.getLoginErrorMessage();
	        Assert.assertEquals(actualMessage, expectedMessage);
	    } catch (Exception e) {
	        System.err.println("An error occurred: " + e.getMessage());
	    }
	}
}