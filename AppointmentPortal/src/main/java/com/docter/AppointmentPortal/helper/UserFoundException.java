package com.docter.AppointmentPortal.helper;

public class UserFoundException extends Exception{

	public UserFoundException() {
		super("User with this username is already there in DB");
		// TODO Auto-generated constructor stub
		
	}
	
	public UserFoundException(String msg) {super(msg);}

	
	
	

}
