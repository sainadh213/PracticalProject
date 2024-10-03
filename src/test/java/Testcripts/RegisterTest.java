package Testcripts;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Tutorialsninja.Base.Base;
import com.Tutorialsninja.Base.Constants;
import com.Tutorialsninja.ObjectRepo.RegisterPage;

//@Listeners(com.Tutorialsninja.Base.Listeners.class)
public class RegisterTest extends Base {

	RegisterPage rp;

	@Test(priority = 1)
	public void registerWithoutFillingTest() throws Throwable {
		rp = new RegisterPage(driver);
		rp.registerWithoutFilling();

		Assert.assertEquals(rp.getFirstNameWarning().getText(), Constants.actualFirstNameWarning);
		Assert.assertEquals(rp.getLastNameWarning().getText(), Constants.actualLastNameWarning);
		Assert.assertEquals(rp.getEmailWarning().getText(), Constants.actualEmailWarning);
		Assert.assertEquals(rp.getTelephoneWarning().getText(), Constants.actualTelephoneWarning);
		Assert.assertEquals(rp.getPasswordWarning().getText(), Constants.actualPasswordWarning);
		Assert.assertEquals(rp.getWarningmessage().getText(), Constants.privacyWarningMessage);
		//Thread.sleep(10000);

	}

	@Test(priority = 2)
	public void rigisterTest() throws Throwable {
		rp = new RegisterPage(driver);
		rp.registerAccount();
		Assert.assertEquals(driver.getTitle(), Constants.accountCreatedPageTitle);

	}

	@Test(priority = 3)
	public void registerWithoutPrivacyCheckBoxTest() throws InterruptedException {
		rp = new RegisterPage(driver);
		rp.registerAccountWithoutPrivacyCheckbox();

		Assert.assertEquals(rp.getWarningmessage().getText(), Constants.privacyWarningMessage);
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void registerWithUsedEmailTest() throws Throwable {
		rp = new RegisterPage(driver);
		rp.registerAccountWithRegistredEmail();
		Assert.assertEquals(rp.getWarningmessage().getText(), Constants.emailWarningMessage);
		Thread.sleep(5000);
	}

}
