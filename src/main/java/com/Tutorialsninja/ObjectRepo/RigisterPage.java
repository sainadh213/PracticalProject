package com.Tutorialsninja.ObjectRepo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Tutorialsninja.Base.JavaUtil;

public class RigisterPage {
	WebDriver driver;
	JavaUtil ju=new JavaUtil();

	public RigisterPage(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtn;
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement rigisterBtn;
	@FindBy(name = "firstname")
	private WebElement firstNameTb;
	@FindBy(name = "lastname")
	private WebElement lastNameTb;
	@FindBy(name = "email")
	private WebElement emailTb;
	@FindBy(name = "telephone")
	private WebElement telephoneTb;
	@FindBy(name = "password")
	private WebElement passwordTb;
	@FindBy(name = "confirm")
	private WebElement confirmPasswordTb;
	@FindBy(name = "agree")
	private WebElement privacyCb;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement warningMessage;

	public WebElement getMyAccountBtn() {
		return myAccountBtn;
	}

	public WebElement getRigisterBtn() {
		return rigisterBtn;
	}

	public WebElement getFirstNameTb() {
		return firstNameTb;
	}

	public WebElement getLastNameTb() {
		return lastNameTb;
	}

	public WebElement getEmailTb() {
		return emailTb;
	}

	public WebElement getTelephoneTb() {
		return telephoneTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getConfirmPasswordTb() {
		return confirmPasswordTb;
	}

	public WebElement getPrivacyCb() {
		return privacyCb;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getWarningmessage() {
		return warningMessage;
	}
	
	public void registerAccount()
	{
		getMyAccountBtn().click();
		getRigisterBtn().click();
		getFirstNameTb().sendKeys(ju.getFirstname());
		getLastNameTb().sendKeys(ju.getLastName());
		getEmailTb().sendKeys(ju.getEmailAddress());
		getTelephoneTb().sendKeys(ju.getPhoneNo());
		String password = ju.getPassword();
		getPasswordTb().sendKeys(password);
		getConfirmPasswordTb().sendKeys(password);
		getPrivacyCb().click();
		getContinueBtn().click();
		
		
	}
	
	public void registerAccountWithoutPrivacyCheckbox()
	{
		getMyAccountBtn().click();
		getRigisterBtn().click();
		getFirstNameTb().sendKeys(ju.getFirstname());
		getLastNameTb().sendKeys(ju.getLastName());
		getEmailTb().sendKeys(ju.getEmailAddress());
		getTelephoneTb().sendKeys(ju.getPhoneNo());
		String password = ju.getPassword();
		getPasswordTb().sendKeys(password);
		getConfirmPasswordTb().sendKeys(password);
		getContinueBtn().click();
		
		
	}
	
	public void registerAccountWithRegistredEmail()
	{
		getMyAccountBtn().click();
		getRigisterBtn().click();
		getFirstNameTb().sendKeys(ju.getFirstname());
		getLastNameTb().sendKeys(ju.getLastName());
		getEmailTb().sendKeys("sai@mailinator.com");
		getTelephoneTb().sendKeys(ju.getPhoneNo());
		String password = ju.getPassword();
		getPasswordTb().sendKeys(password);
		getConfirmPasswordTb().sendKeys(password);
		getPrivacyCb().click();
		getContinueBtn().click();
		
		
	}
	
}
