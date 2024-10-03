package com.Tutorialsninja.Base;

public interface Constants {

	String propertiesFilePath = "C:\\Users\\SaiNadh\\eclipse-workspace\\Hybrid_Framework\\Resources\\config.properties";
	String excelFilePath = "C:\\Users\\SaiNadh\\eclipse-workspace\\Hybrid_Framework\\Resources\\TutorialsNinja.xlsx";
	String screenshotPath = "C:\\Users\\SaiNadh\\eclipse-workspace\\Hybrid_Framework\\Screenshots\\";
	String extentReportsFilePath = "C:\\Users\\SaiNadh\\eclipse-workspace\\Hybrid_Framework\\ExtentReports";
	String emailWarningMessage = "Warning: E-Mail Address is already registered!";
	String accountCreatedPageTitle = "Your Account Has Been Created!";
	String invalidCredentialsWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
	String myAccountPageTitle = "My Account";
	String wrongCredentialsWarningMessage="Warning: No match for E-Mail Address and/or Password.";
	int implicitTime=20;
	int pageLoadTime=10;
	
	//Register page validations
	String actualFirstNameWarning="First Name must be between 1 and 32 characters!";
	String actualLastNameWarning="Last Name must be between 1 and 32 characters!";
	String actualEmailWarning="E-Mail Address does not appear to be valid!";
	String actualTelephoneWarning="Telephone must be between 3 and 32 characters!";
	String actualPasswordWarning="Password must be between 4 and 20 characters!";
	String privacyWarningMessage = "Warning: You must agree to the Privacy Policy!";
}
