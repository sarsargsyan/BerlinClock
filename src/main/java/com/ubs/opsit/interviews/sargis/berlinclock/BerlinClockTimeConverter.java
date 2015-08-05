package com.ubs.opsit.interviews.sargis.berlinclock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.sargis.berlinclock.exceptions.WrongTimeFormat;
import com.ubs.opsit.interviews.sargis.berlinclock.model.LightType;
import com.ubs.opsit.interviews.sargis.berlinclock.model.LightsRow;

public class BerlinClockTimeConverter implements TimeConverter {
	
	private final static String TIME_FORMAT_PATTERN = "(([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])|24:00:00";
	private int[] splitedTime = new int[3];
	
	private LightsRow twoSecondsRow = new LightsRow(LightType.TWO_SECOND_LIGHT);
	private LightsRow fiveHoursRow = new LightsRow(LightType.FIVE_HOURS_LIGHT);
	private LightsRow oneHoursRow = new LightsRow(LightType.ONE_HOUR_LIGHT);
	private LightsRow fiveMinutesRow = new LightsRow(LightType.FIVE_MINUTES_LIGHT);
	private LightsRow oneMinutesRow = new LightsRow(LightType.ONE_MINUTE_LIGHT);

	@Override
	public String convertTime(String aTime) throws WrongTimeFormat {
		validateTime(aTime);
		parseTimeToIntArray(aTime);
		initLightrows();
		return getBerlinClockFormateTime();
	}

	private void validateTime(String aTime) throws WrongTimeFormat {
		if (aTime == null){
			throw new WrongTimeFormat("NULL");
		}
		Pattern pattern = Pattern.compile(TIME_FORMAT_PATTERN);
		Matcher matcher = pattern.matcher(aTime);
		if (!matcher.matches()) {
			throw new WrongTimeFormat(aTime);
		}
	}

	private void parseTimeToIntArray(String aTime) {
		int timeUnitIndex = 0;
		for (String timeUnit : aTime.split(":")) {
			splitedTime[timeUnitIndex] = (Integer.parseInt(timeUnit));
			timeUnitIndex++;
		}
	}
	
	private void initLightrows(){
		initSecondRow();
		initMintesRows();
		initHourRows();
	}
	
	private void initSecondRow(){
		if (splitedTime[2] % 2 == 0){
			twoSecondsRow.setNumberOfSwitchedOnLights(1);
		}else{
			twoSecondsRow.setNumberOfSwitchedOnLights(0);
		}
	}
	
	private void initHourRows(){
		initModuleFiveRows(fiveHoursRow, oneHoursRow, splitedTime[0]);
	}
	
	private void initMintesRows(){
		initModuleFiveRows(fiveMinutesRow, oneMinutesRow, splitedTime[1]);
	}
	
	private void initModuleFiveRows(LightsRow integerPart ,LightsRow remainder, int lightsNumber){
		int rem =  lightsNumber % 5;
		int intPart = (lightsNumber - rem) / 5;
		integerPart.setNumberOfSwitchedOnLights(intPart);
		remainder.setNumberOfSwitchedOnLights(rem);
	}

	private String getBerlinClockFormateTime(){
		StringBuilder  berlinClockTime =  new StringBuilder();
		berlinClockTime.append(twoSecondsRow).append("\r\n");
		berlinClockTime.append(fiveHoursRow).append("\r\n");
		berlinClockTime.append(oneHoursRow).append("\r\n");
		berlinClockTime.append(fiveMinutesRow).append("\r\n");
		berlinClockTime.append(oneMinutesRow);
		return berlinClockTime.toString();
	}
}
