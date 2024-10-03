package com.Tutorialsninja.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Tutorialsninja.Base.JavaUtil;

public class RegisterPage {
	WebDriver driver;
	JavaUtil ju = new JavaUtil();

	public RegisterPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtn;
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerBtn;
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

	

	public WebElement getFirstNameWarning() {
		return firstNameWarning;
	}

	public WebElement getLastNameWarning() {
		return lastNameWarning;
	}

	public WebElement getEmailWarning() {
		return emailWarning;
	}

	public WebElement getTelephoneWarning() {
		return telephoneWarning;
	}

	public WebElement getPasswordWarning() {
		return passwordWarning;
	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public WebElement getMyAccountBtn() {
		return myAccountBtn;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
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

	public void registerWithoutFilling() {
		getMyAccountBtn().click();
		getRegisterBtn().click();
		getContinueBtn().click();

	}

	public void registerAccount() {
		getMyAccountBtn().click();
		getRegisterBtn().click();
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

	public void registerAccountWithoutPrivacyCheckbox() {
		getMyAccountBtn().click();
		getRegisterBtn().click();
		getFirstNameTb().sendKeys(ju.getFirstname());
		getLastNameTb().sendKeys(ju.getLastName());
		getEmailTb().sendKeys(ju.getEmailAddress());
		getTelephoneTb().sendKeys(ju.getPhoneNo());
		String password = ju.getPassword();
		getPasswordTb().sendKeys(password);
		getConfirmPasswordTb().sendKeys(password);
		getContinueBtn().click();

	}

	public void registerAccountWithRegistredEmail() {
		getMyAccountBtn().click();
		getRegisterBtn().click();
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
