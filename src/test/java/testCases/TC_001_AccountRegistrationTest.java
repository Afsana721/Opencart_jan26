package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = { "Regression", "Master"})
	public void test_account_Registration() {
		
		logger.info("Starting TC_AccountRegistration Test  *****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on  Myaccount  menu");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("providing customer data");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLirstName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		
	String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on Continue");	
		
		String confirmationmsg= regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");	
		Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!" ,  "not getting expected message");
		
		}catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info(" *** Finsihed TC_001_AccountRegistration Test  ***");
		}
		
	}
	
	
	
	
	