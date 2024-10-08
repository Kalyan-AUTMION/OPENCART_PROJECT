package testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public Properties p;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setUp(String os,String br) throws IOException
	{
		//Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		switch(br.toLowerCase())
		{
		case "chrome" :driver = new ChromeDriver();
		break;
		case "edge"   :driver = new EdgeDriver();
		break;
		case "firefox":driver = new FirefoxDriver();
		break;
		default     : System.out.println("invalid browser");return;

		}
		
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Adjust wait time
		
		//Reading Url from properties file
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();

	}


	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		 if (driver != null) {
		        driver.quit(); // This will close all browser windows and end the WebDriver session.
		    }
	}
	
	public String generateRandomEmail() {
		String randomEmail = "user" + UUID.randomUUID().toString().substring(0, 5) + "@testmail.com";
		return randomEmail;
	}

	public String generateRandomPhoneNumber() {
		Random random = new Random();
		StringBuilder phoneNumber = new StringBuilder("9");
		for (int i = 0; i < 9; i++) {
			phoneNumber.append(random.nextInt(10));
		}
		return phoneNumber.toString();
	}

	public String generateRandomPassword() {
		return "Pass" + UUID.randomUUID().toString().substring(0, 5) + "@123";
	}

	public String generateRandomName() {
		return "User" + UUID.randomUUID().toString().substring(0, 5);
	}
	
	public String captureScreen(String tname) {

            String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot takeScreenshot =(TakesScreenshot)driver;
            File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
            
            String targetFilePath = System.getProperty("user.dir")+"\\screnshots\\"+ tname+"_" +timeStamp +".png";
            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);
            
		return targetFilePath;
	}

}
