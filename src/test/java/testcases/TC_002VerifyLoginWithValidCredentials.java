package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class TC_002VerifyLoginWithValidCredentials extends BaseTest{
	
	
	@Test(groups= {"sanity","master"})
	public void VerifyLoginWithValidCredentials()
	{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clkMyAccount();
		hp.clkLogin();
		
		//LoginPage
		LoginPage lp= new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLoginButton();
		
		//MyAccountPage
		MyAccountPage mp=new MyAccountPage(driver);
		
		//validation		
		boolean targetPage =mp.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true, "testFailed");
		
		
		
		
	}
	

}
