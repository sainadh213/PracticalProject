package Testcripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Tutorialsninja.Base.Base;
import com.Tutorialsninja.Base.Constants;
import com.Tutorialsninja.ObjectRepo.RigisterPage;

//@Listeners(com.Tutorialsninja.Base.Listeners.class)
public class RigisterTest extends Base {

	RigisterPage rp;

	@Test(priority = 1)
	public void rigister() throws Throwable {
		rp = new RigisterPage(driver);
		rp.registerAccount();
		Assert.assertEquals(driver.getTitle(), Constants.accountCreatedPageTitle);
	}

	@Test(priority = 2)
	public void registerWithoutPrivacyCheckBox() {
		rp = new RigisterPage(driver);
		rp.registerAccountWithoutPrivacyCheckbox();
		
		Assert.assertEquals(rp.getWarningmessage().getText(), Constants.privacyWarningMessage);
	}
	
	@Test(priority = 3)
	public void registerWithUsedEmail()
	{
		rp=new RigisterPage(driver);
		rp.registerAccountWithRegistredEmail();
		Assert.assertEquals(rp.getWarningmessage().getText(), Constants.emailWarningMessage);
	}

}
