package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity", "Master"})
	public void test_Login()
	{
		try
		{
			logger.info("Starting TC_002_LoginTest ******");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			hp.clickLogin();
			logger.info("Clicked on Login Link ");
		
			LoginPage lp = new LoginPage(driver);
			logger.info("Providing loging details");
			
			lp.setEmail(bundel.getString("email"));
					
			lp.setPassword(bundel.getString("password"));
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage  macc = new MyAccountPage(driver);
			
			boolean targetpage =macc.isMyAccountPageExists();
			Assert.assertEquals(targetpage, true,  "Invalid Login data");
		} 
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info(" ******* Finshed  TC_0002_LoginTest");
		}

	}
