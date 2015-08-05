package com.ubs.opsit.interviews.sargis.berlinclock.model;

import com.ubs.opsit.interviews.sargis.berlinclock.exceptions.WrongNumberOfLights;

public class LightsRow {
	private LightType lightsType;
	private int switchedOnLightsNumber;
	private final static String OFF_LIGHT= "O";
	

	public LightsRow(LightType lightsType) {
		this.lightsType = lightsType;
	}

	public void setNumberOfSwitchedOnLights(int switchedOnLightsNumber) throws WrongNumberOfLights {
		validateOnLightsNumber(switchedOnLightsNumber);
		this.switchedOnLightsNumber = switchedOnLightsNumber;
	}

	private void validateOnLightsNumber(int switchedOnLightsNumber) throws WrongNumberOfLights {
		if (switchedOnLightsNumber < 0 || switchedOnLightsNumber > lightsType.getMaxNumberOfLightsOnClock()){
			throw new WrongNumberOfLights(switchedOnLightsNumber,lightsType.getName());
		}
	}
	
	@Override
	public String toString(){
		StringBuilder lightsRow = new StringBuilder(lightsType.getAllLightsSwitchedOnString());
		String offLights = generateOffLighthsString();
		lightsRow = lightsRow.replace(switchedOnLightsNumber, lightsRow.length(), offLights);
		return lightsRow.toString();
	}
	
	private String generateOffLighthsString(){
		StringBuilder offLighths = new StringBuilder("");
		int switchedOffLightsNumber =  lightsType.getMaxNumberOfLightsOnClock() - switchedOnLightsNumber;
		for(int i = 0; i < switchedOffLightsNumber ; i++){
			offLighths.append(OFF_LIGHT);
		}
		return offLighths.toString();
	}

}
