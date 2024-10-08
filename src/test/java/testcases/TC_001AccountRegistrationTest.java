package testcases;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;

public class TC_001AccountRegistrationTest extends BaseTest{


	@Test(groups = {"regression","master"})
	public void verify_Account_Registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clkMyAccount();
		hp.clkRegister();

		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.enterFirstName(generateRandomName());
		regPage.enterLastName(generateRandomName());
		regPage.enterEmail(generateRandomEmail());
		regPage.enterTelephoneNum(generateRandomPhoneNumber());
		String password = generateRandomPassword();

		regPage.enterPassword(password);
		regPage.enterConfirmPassword(password);
		regPage.clkPrivacyPolicy();
		regPage.clkBtnContinue();

		String ConfirmedMsg=regPage.getConfirmMsg();
		//Validation
		Assert.assertEquals(ConfirmedMsg,"Your Account Has Been Created!");

	}

	


}
