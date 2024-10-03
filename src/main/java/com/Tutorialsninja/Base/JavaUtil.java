package com.Tutorialsninja.Base;

import java.util.Date;

import com.github.javafaker.Faker;

public class JavaUtil {

	Faker fk = new Faker();

	public String getFirstname() {
		String firstName = fk.name().firstName();
		return firstName;
	}

	public String getLastName() {
		String lastName = fk.name().lastName();
		return lastName;
	}

	public String getEmailAddress() {
		String emailId = fk.internet().emailAddress();
		return emailId;
	}

	public String getPhoneNo() {
		String phoneNo = fk.phoneNumber().cellPhone();
		return phoneNo;
	}

	public String getPassword() {
		String password = fk.internet().password(8, 10);
		return password;
	}
    public String getTimestamp()
    {
    	Date dt=new Date();
    	String date = dt.toString().replaceAll("[ :]", "_");
    	return date;
    			
    }
}
