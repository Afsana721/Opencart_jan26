package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

			
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	WebElement btnsubscribe;
	
	@FindBy(xpath="//h1[text()='Register Account']")
	WebElement printRegisterAccount;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLirstName(String lname) {
		txtlastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);;
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);;
	}

	public void setsubscribe() {
		btnsubscribe.click();
	}

	public void setPrintRegisterAccount() {
		printRegisterAccount.isDisplayed();
	}

	public void setPrivacyPolicy() {
		chkPolicy.click();;
	}

	public void clickContinue() {
		btnContinue.click();
	}
	
	
	public String getConfirmationMsg() {
		
		try {
			return (msgConfirmation.getText());
		} catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	

}
