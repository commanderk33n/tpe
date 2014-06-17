/**
 * 
 */
package imb.SS14.tpegr01.collatz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Philipp Siebert
 * 
 */
public class CollatzJUnitTest {

	@Test
	public void test13() {
		ArrayList<Long> values = new ArrayList<Long>();
		values.add((long) 13);
		values.add((long) 40);
		values.add((long) 20);
		values.add((long) 10);
		values.add((long) 5);
		values.add((long) 16);
		values.add((long) 8);
		values.add((long) 4);
		values.add((long) 2);
		values.add((long) 1);

		Collatz c = new Collatz(13);
		ArrayList<Long> result = new ArrayList<Long>();
		for (long l : c) {
			result.add(l);
		}
		assertTrue(result.equals(values));
	}

	@Test
	public void test19() {
		ArrayList<Long> values = new ArrayList<Long>();
		values.add((long) 19);
		values.add((long) 58);
		values.add((long) 29);
		values.add((long) 88);
		values.add((long) 44);
		values.add((long) 22);
		values.add((long) 11);
		values.add((long) 34);
		values.add((long) 17);
		values.add((long) 52);
		values.add((long) 26);
		values.add((long) 13);
		values.add((long) 40);
		values.add((long) 20);
		values.add((long) 10);
		values.add((long) 5);
		values.add((long) 16);
		values.add((long) 8);
		values.add((long) 4);
		values.add((long) 2);
		values.add((long) 1);

		Collatz c = new Collatz(19);
		ArrayList<Long> result = new ArrayList<Long>();
		for (long l : c) {
			result.add(l);
		}
		assertTrue(result.equals(values));
	}

	@Test
	public void findLongestSequence() {
		CollatzRunner runner = new CollatzRunner();
		runner.findLongestSequence(4);
		assertTrue(runner.getLongestSequence().get(0) == 837799);
	}

	@Test
	public void test25() {
		ArrayList<Long> values = new ArrayList<Long>();
		values.add((long) 25);
		values.add((long) 76);
		values.add((long) 38);
		values.add((long) 19);
		values.add((long) 58);
		values.add((long) 29);
		values.add((long) 88);
		values.add((long) 44);
		values.add((long) 22);
		values.add((long) 11);
		values.add((long) 34);
		values.add((long) 17);
		values.add((long) 52);
		values.add((long) 26);
		values.add((long) 13);
		values.add((long) 40);
		values.add((long) 20);
		values.add((long) 10);
		values.add((long) 5);
		values.add((long) 16);
		values.add((long) 8);
		values.add((long) 4);
		values.add((long) 2);
		values.add((long) 1);

		Collatz c = new Collatz(25);
		ArrayList<Long> result = new ArrayList<Long>();
		for (long l : c) {
			result.add(l);
		}
		assertTrue(result.equals(values));
	}
}
