package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement accountConfirmationMsg;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]")
	WebElement linkLogout;
	
	public boolean isMyAccountPageExists() {
	
		try {
			return (msgHeading.isDisplayed());
		} catch(Exception e) {
			return(false);
		}
		
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	

}
