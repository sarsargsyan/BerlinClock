package com.ubs.opsit.interviews.sargis.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.sargis.berlinclock.exceptions.WrongTimeFormat;

public class BerlinClockTimeConverterTest {
	
	BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
	
	@Test(expected = WrongTimeFormat.class)
	public void convertTimeValidateInputEmptyString(){
		berlinClockTimeConverter.convertTime("");
	}
	
	@Test(expected = WrongTimeFormat.class)
	public void convertTimeValidateInputNull(){
		berlinClockTimeConverter.convertTime(null);
	}
	
	@Test(expected = WrongTimeFormat.class)
	public void convertTimeValidateInputCharacters(){
		berlinClockTimeConverter.convertTime("1A:12:12");
	}
	
	@Test(expected = WrongTimeFormat.class)
	public void convertTimeValidateInputWrongTime(){
		berlinClockTimeConverter.convertTime("24:12:12");
	}
	
	@Test(expected = WrongTimeFormat.class)
	public void convertTimeValidateInputWhiteSpace(){
		berlinClockTimeConverter.convertTime("22:12:12 ");
	}
	
	
	
	@Test 
	public void convertTimeMidnightEndOfDay(){
		assertEquals("24:00:00 Midnight representation is wrong",
					"Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO",
					berlinClockTimeConverter.convertTime("24:00:00"));
	}
	
	@Test 
	public void convertTimeMidnightBeginningOfDay(){
		assertEquals("00:00:00 Midnight representation is wrong",
					"Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO",
					berlinClockTimeConverter.convertTime("00:00:00"));
	}
	
	@Test 
	public void convertTimeDayTime(){
		assertEquals("Day time (after 12:00) representation is wrong",
					"Y\r\nRRRR\r\nRROO\r\nYYRYOOOOOOO\r\nYYOO",
					berlinClockTimeConverter.convertTime("22:22:22"));
	}
	
	@Test 
	public void convertTimeNightTime(){
		assertEquals("Night time (before 12:00) representation is wrong",
					"O\r\nROOO\r\nOOOO\r\nYOOOOOOOOOO\r\nOOOO",
					berlinClockTimeConverter.convertTime("05:05:05"));
	}

}
