package com.Tutorialsninja.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtn;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginIcon;
	@FindBy(id = "input-email")
	private WebElement emialAddressTb;
	@FindBy(id = "input-password")
	private WebElement passwordTb;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement warningMessage;

	public WebElement getMyAccountBtn() {
		return myAccountBtn;
	}

	public WebElement getLoginIcon() {
		return loginIcon;
	}

	public WebElement getEmialAddressTb() {
		return emialAddressTb;
	}

	public WebElement getpasswordTb() {
		return passwordTb;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getWarningMessage() {
		return warningMessage;
	}

	public void loginWithoutDetails() throws Throwable {
		/*
		 * WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(20));
		 * WebElement element =
		 * wait.until(ExpectedConditions.elementToBeClickable(getMyAccountBtn()));
		 * element.click();
		 */
		//Thread.sleep(10000);
		getMyAccountBtn().click();
		getLoginIcon().click();
		getLoginBtn().click();
	}

	public void loginWithValidDetails(String emailAddress, String password) {
		getMyAccountBtn().click();
		getLoginIcon().click();
		getEmialAddressTb().sendKeys(emailAddress);
		getpasswordTb().sendKeys(password);
		getLoginBtn().click();
	}

	public void loginWithInValidDetails(String emailAddress, String password) {
		getMyAccountBtn().click();
		getLoginIcon().click();
		getEmialAddressTb().sendKeys(emailAddress);
		getpasswordTb().sendKeys(password);
		getLoginBtn().click();
	}
}
