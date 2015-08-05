package com.ubs.opsit.interviews.sargis.berlinclock.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.sargis.berlinclock.exceptions.WrongNumberOfLights;



public class LightsRowTest {
	
	private LightsRow twoSecondsRow;
	private LightsRow fiveHoursRow;
	private LightsRow oneHoursRow;
	private LightsRow fiveMinutesRow;
	private LightsRow oneMinutesRow;
	
	@Before
	public void setUp(){
		twoSecondsRow = new LightsRow(LightType.TWO_SECOND_LIGHT);
		fiveHoursRow = new LightsRow(LightType.FIVE_HOURS_LIGHT);
		oneHoursRow = new LightsRow(LightType.ONE_HOUR_LIGHT);
		fiveMinutesRow = new LightsRow(LightType.FIVE_MINUTES_LIGHT);
		oneMinutesRow = new LightsRow(LightType.ONE_MINUTE_LIGHT);
	}
	
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateNegativeLightsNumber(){
		twoSecondsRow.setNumberOfSwitchedOnLights(-1);
	}
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateExceedMaxNumberOfSecondLights(){
		twoSecondsRow.setNumberOfSwitchedOnLights(LightType.TWO_SECOND_LIGHT.getMaxNumberOfLightsOnClock()+1);
	}
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateExceedMaxNumberOfFiveHourLights(){
		fiveHoursRow.setNumberOfSwitchedOnLights(LightType.FIVE_HOURS_LIGHT.getMaxNumberOfLightsOnClock()+1);
	}
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateExceedMaxNumberOfOneHourLights(){
		oneHoursRow.setNumberOfSwitchedOnLights(LightType.ONE_HOUR_LIGHT.getMaxNumberOfLightsOnClock()+1);
	}
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateExceedMaxNumberOfFiveMinute(){
		fiveMinutesRow.setNumberOfSwitchedOnLights(LightType.FIVE_MINUTES_LIGHT.getMaxNumberOfLightsOnClock()+1);
	}
	
	@Test(expected = WrongNumberOfLights.class)
	public void setNumberOfOnLightsValidateExceedMaxNumberOfOneMinuteLights(){
		oneMinutesRow.setNumberOfSwitchedOnLights(LightType.ONE_MINUTE_LIGHT.getMaxNumberOfLightsOnClock()+1);
	}


	
	
	@Test
	public void toStringTwoSecondsRowAllLightsOn(){
		twoSecondsRow.setNumberOfSwitchedOnLights(LightType.TWO_SECOND_LIGHT.getMaxNumberOfLightsOnClock());
		assertEquals("2 seconds row all lights on representation is wrong","Y",twoSecondsRow.toString());
	}
	@Test
	public void toStringTwoSecondsRowAllLightsOff(){
		twoSecondsRow.setNumberOfSwitchedOnLights(0);
		assertEquals("2 seconds row all lights off representation is wrong","O",twoSecondsRow.toString());
	}
	
	
	
	@Test
	public void toStringFiveHoursRowAllLightsOn(){
		fiveHoursRow.setNumberOfSwitchedOnLights(LightType.FIVE_HOURS_LIGHT.getMaxNumberOfLightsOnClock());
		assertEquals("5 Hours row all lights on representation is wrong","RRRR",fiveHoursRow.toString());
	}
	@Test
	public void toStringFiveHoursRowAllLightsOff(){
		fiveHoursRow.setNumberOfSwitchedOnLights(0);
		assertEquals("5 Hours row all lights off representation is wrong","OOOO",fiveHoursRow.toString());
	}
	@Test
	public void toStringFiveHoursRowSomeLightsOn(){
		fiveHoursRow.setNumberOfSwitchedOnLights(LightType.FIVE_HOURS_LIGHT.getMaxNumberOfLightsOnClock()-1);
		assertEquals("5 Hours row some lights on representation is wrong","RRRO",fiveHoursRow.toString());
	}
	
	
	
	@Test
	public void toStringOneHoursRowAllLightsOn(){
		oneHoursRow.setNumberOfSwitchedOnLights(LightType.ONE_HOUR_LIGHT.getMaxNumberOfLightsOnClock());
		assertEquals("1 Hours row all lights on representation is wrong","RRRR",oneHoursRow.toString());
	}
	@Test
	public void toStringOneHoursRowAllLightsOff(){
		oneHoursRow.setNumberOfSwitchedOnLights(0);
		assertEquals("1 Hours row all lights off representation is wrong","OOOO",oneHoursRow.toString());
	}
	@Test
	public void toStringOneHoursRowSomeLightsOn(){
		oneHoursRow.setNumberOfSwitchedOnLights(LightType.ONE_HOUR_LIGHT.getMaxNumberOfLightsOnClock()-1);
		assertEquals("1 Hours row some lights on representation is wrong","RRRO",oneHoursRow.toString());
	}
	
	
	
	@Test
	public void toStringFiveMinutesAllLightsOn(){
		fiveMinutesRow.setNumberOfSwitchedOnLights(LightType.FIVE_MINUTES_LIGHT.getMaxNumberOfLightsOnClock());
		assertEquals("5 minutues row all lights on representation is wrong","YYRYYRYYRYY",fiveMinutesRow.toString());
	}
	@Test
	public void toStringFiveMinutesAllLightsOff(){
		fiveMinutesRow.setNumberOfSwitchedOnLights(0);
		assertEquals("5 minutues row all lights off representation is wrong","OOOOOOOOOOO",fiveMinutesRow.toString());
	}
	@Test
	public void toStringFiveMinutesSomeLightsOn(){
		fiveMinutesRow.setNumberOfSwitchedOnLights(LightType.FIVE_MINUTES_LIGHT.getMaxNumberOfLightsOnClock()-1);
		assertEquals("5 minutues row some lights on representation is wrong","YYRYYRYYRYO",fiveMinutesRow.toString());
	}
	
	
	
	@Test
	public void toStringOneMinutesAllLightsOn(){
		oneMinutesRow.setNumberOfSwitchedOnLights(LightType.ONE_MINUTE_LIGHT.getMaxNumberOfLightsOnClock());
		assertEquals("1 minutues row all lights on representation is wrong","YYYY",oneMinutesRow.toString());
	}
	@Test
	public void toStringOneMinutesAllLightsOf(){
		oneMinutesRow.setNumberOfSwitchedOnLights(0);
		assertEquals("1 minutues row all lights off representation is wrong","OOOO",oneMinutesRow.toString());
	}
	@Test
	public void toStringOneMinutesSomeLightsOn(){
		oneMinutesRow.setNumberOfSwitchedOnLights(LightType.ONE_MINUTE_LIGHT.getMaxNumberOfLightsOnClock()-1);
		assertEquals("1 minutues row some lights on representation is wrong","YYYO",oneMinutesRow.toString());
	}
}
