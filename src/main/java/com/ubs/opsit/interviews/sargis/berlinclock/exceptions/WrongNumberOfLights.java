package com.ubs.opsit.interviews.sargis.berlinclock.exceptions;

public class WrongNumberOfLights extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MASSAGE_TMEPLATE = " is wrong Number of ";
	String massage;

	public WrongNumberOfLights(int lightsNumber, String lightType) {
		this.massage = generateErrorMasage(lightsNumber, lightType);
	}

	private String generateErrorMasage(int lightsNumber, String lightType) {
		return lightsNumber + ERROR_MASSAGE_TMEPLATE + lightType;
	}
	
	public String getMassage(){
		return massage;
	}
}

