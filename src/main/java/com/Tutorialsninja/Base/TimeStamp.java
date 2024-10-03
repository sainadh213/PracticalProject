package com.Tutorialsninja.Base;

import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		String date = dt.toString().replaceAll("[ :]", "_");
		System.out.println(date);
		
	}

}
