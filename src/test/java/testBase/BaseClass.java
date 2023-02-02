package testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle bundel;
	
		@BeforeClass(groups = {"Master", "Sanity", "Regression"})
		@Parameters("browser")
		public void setup(String br) {
		
		logger = LogManager.getLogger(this.getClass());
		bundel = ResourceBundle.getBundle("config");
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",  new String[] {"enable-automation"});
		
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(br.equals("edge")) {
			driver = new EdgeDriver() ;
		}else{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//driver.get("http://localhost:7882/opencart/upload/");  
		driver.get(bundel.getString("appURL1"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
		@AfterClass(groups = {"Master", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
		
		}
	
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		}	
		
		
	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return generatedString2;
		}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st+ "@" +num);    // add both & get string with number.
		
		}
	
	
	public  String captureScreen(String tname) throws IOException
	{	
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\"  + tname  + "-" + timeStamp + ".png";
		
		try {
				FileUtils.copyFile(source, new File(destination));
				
				}catch(Exception e){
					e.getMessage();
				}
				return destination;
	}
	
	}
