package com.ubs.opsit.interviews.sargis.berlinclock.exceptions;

public class WrongTimeFormat extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	final String errorMassageTemplate = "Wrong Time Formate: Expected Fromate is (HH:MM:SS). Inputed String is: ";
	String massage;

	public WrongTimeFormat(String aTime) {
		this.massage = generateErrorMasage(aTime);
	}

	private String generateErrorMasage(String aTime) {
		return errorMassageTemplate + aTime;
	}
	
	public String getMassage(){
		return massage;
	}
}