package com.ubs.opsit.interviews.sargis.berlinclock.model;

public enum LightType {
	TWO_SECOND_LIGHT("Y", "2 seconds lights"),
	FIVE_HOURS_LIGHT("RRRR", "5 hours lights"),
	ONE_HOUR_LIGHT("RRRR", "1 hour lights"),
	FIVE_MINUTES_LIGHT("YYRYYRYYRYY", "5 minutes lights"),
	ONE_MINUTE_LIGHT("YYYY", "1 minute lights");
	
	private String allLightsSwitchedOnOnString;
	private String name;
	
	private LightType(String allLightsSwitchedOnOnString ,String typeName){
		this.name = typeName;
		this.allLightsSwitchedOnOnString = allLightsSwitchedOnOnString;
	}
	
	public String getAllLightsSwitchedOnString(){
		return allLightsSwitchedOnOnString;
	}
	
	public int getMaxNumberOfLightsOnClock(){
		return allLightsSwitchedOnOnString.length();
	}
	
	public String getName(){
		return name;
	}

}
