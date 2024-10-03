package Testcripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Tutorialsninja.Base.Base;
import com.Tutorialsninja.Base.Constants;
import com.Tutorialsninja.Base.FileUtil;
import com.Tutorialsninja.Base.JavaUtil;
import com.Tutorialsninja.ObjectRepo.LoginPage;

@Listeners(com.Tutorialsninja.Base.Listeners.class)
public class LoginTest extends Base {
	LoginPage lp;
	FileUtil fu = new FileUtil();
	JavaUtil ju = new JavaUtil();

	@Test(priority =1)
	public void loginWithoutCredentialsTest() throws Throwable {
		lp = new LoginPage(driver);
		lp.loginWithoutDetails();
		Assert.assertEquals(lp.getWarningMessage().getText(), Constants.invalidCredentialsWarningMessage);
	}

	@Test(priority = 3)
	public void loginWithValidCredentialsTest() {
		lp = new LoginPage(driver);
		try {
			lp.loginWithValidDetails(fu.readDataFromPropertiesFile("userEmail"),
					fu.readDataFromPropertiesFile("password"));
		} catch (Throwable e) {

			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), Constants.myAccountPageTitle);
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentialsTest() {
		lp=new LoginPage(driver);
		lp.loginWithInValidDetails(ju.getEmailAddress(), ju.getPassword());
		Assert.assertEquals(lp.getWarningMessage().getText(), Constants.invalidCredentialsWarningMessage);
	}
	@Test(dataProvider = "credentials")
	public void loginWIthDataProviderTest(String email,String password) throws Throwable
	{
		lp=new LoginPage(driver);
		lp.loginWithInValidDetails(email, password);
		Assert.assertEquals(lp.getWarningMessage().getText(), Constants.invalidCredentialsWarningMessage);
		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] credentials() throws Throwable
	{
		Object [][] data=fu.getDataFromExcelToDataProvider("Login");
		//Object [][] data= {{"email1@gmail.com","123456789"},{"email2@gmail.com","856622258"},{"email3@gmail.com","5555589102"}};
		return data;
	}
}
