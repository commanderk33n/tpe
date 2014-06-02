package imb.SS14.tpegr01.cinema.test;
import static org.junit.Assert.*;

import org.junit.Test;

import imb.SS14.tpegr01.cinema.Time;
public class Junit {
	
	@Test
	public void testTime(){
		Time time = new Time("22:15");
		int test = time.getTimeAsMinutes();
		assertTrue(test == 1335);
	}
	
	@Test
	public void testTimetoString(){
		String time = "22:17";
		Time date = new Time(time);
		assertEquals(time.toString(), time);
	}
	
	
	

}
