//Rameez Arshad


package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		//fail("Not yet implemented");
		double result = Time.getTotalSeconds("05:05:05:0055");
		assertTrue("the seconds were not calculated properly", result == 18305.055);
	}
	@Test
	void testGetTotalSecondsBad() {
		//fail("Not yet implemented");
		assertThrows(
				NumberFormatException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	@Test
	void testGetTotalSecondsBoundary() {
		//fail("Not yet implemented");
		double result = Time.getTotalSeconds("23:59:59:0999");
		assertTrue("the seconds were not calculated properly", result == 86399.999);
	}

	
////-----------------------------//////////////////////////////
	
	@Test
	void testGetSecondsGood() {
		//fail("Not yet implemented");
		double result = Time.getSeconds("00:00:10");
		assertTrue("the seconds were not calculated properly", result == 10);
	}
	@Test
	void testGetSecondsBad() {
		//fail("Not yet implemented");
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("00:00");});
	}
	@Test
	void testGetSecondsBoundary() {
		//fail("Not yet implemented");
		double result = Time.getSeconds("00:00:59");
		assertTrue("the seconds were not calculated properly", result == 59);
	}
	
////-----------------------------//////////////////////////////
	
	
	@Test
	void testGetTotalMinutesGood() {
		//fail("Not yet implemented");
		double result = Time.getTotalMinutes("00:10:00:0000");
		assertTrue("the seconds were not calculated properly", result == 10);
	}
	@Test
	void testGetTotalMinutesBad() {
		//fail("Not yet implemented");
		assertThrows(
				NumberFormatException.class,
				()-> {Time.getTotalMinutes("00");});
	}
	@Test
	void testGetTotalMinutesBoundary() {
		//fail("Not yet implemented");
		double result = Time.getTotalMinutes("00:59:00:0000");
		assertTrue("the seconds were not calculated properly", result == 59);
	}
////-----------------------------//////////////////////////////
	
	
	@Test
	void testGetMilliSecondsGood() {
		//fail("Not yet implemented");
		double result = Time.getMilliSeconds("00:00:00:1000");
		assertTrue("the milli seconds were not calculated properly", result == 1000);
	}
	void testGetMilliSecondsBad() {
		//fail("Not yet implemented");
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getMilliSeconds("12:05");});
	}
	@Test
	void testGetMilliSecondsBoundary() {
		//fail("Not yet implemented");
		double result = Time.getMilliSeconds("00:00:00:5000");
		assertTrue("the seconds were not calculated properly", result == 5000);
	}
	
	
	
	
	
////-----------------------------//////////////////////////////

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:000", "05:15:15:000", "05:59:59:000" })
	void testGetTotalHours(String candidate) {
		double hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly", hours == 5);
	}

}
