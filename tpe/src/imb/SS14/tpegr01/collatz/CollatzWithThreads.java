/**
 * 
 */
package imb.SS14.tpegr01.collatz;

import java.util.ArrayList;

/**
 * @author Philipp Siebert
 * 
 */
public class CollatzWithThreads {

	volatile ArrayList<Long> longestSequence = new ArrayList<Long>();

	final long range = 1000000;

	public synchronized void check(ArrayList<Long> list) {
		if (longestSequence.size() < list.size()) {
			longestSequence = list;
		}
	}

	public static void main(String[] args) {
		CollatzWithThreads test = new CollatzWithThreads();
		long start = test.range;
		long end = start - (test.range / 4);
		Thread t1 = new Thread(test.new CollatzRunner(start, end));
		start = end;
		end = start - (test.range / 4);
		Thread t2 = new Thread(test.new CollatzRunner(start, end));
		start = end;
		end = start - (test.range / 4);
		Thread t3 = new Thread(test.new CollatzRunner(start, end));
		start = end;
		end = start - (test.range / 4);
		Thread t4 = new Thread(test.new CollatzRunner(start, end));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			System.out.println("Fehler! " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(test.longestSequence);
	}

	public class CollatzRunner implements Runnable {

		private long startValue;
		private long endValue;

		public CollatzRunner(long startValue, long endValue) {
			this.startValue = (startValue);
			this.endValue = (endValue);
		}

		public CollatzRunner(long startValue) {
			this(startValue, 1);
		}

		/**
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			for (long i = this.startValue; i > this.endValue; i--) {
				Collatz c = new Collatz(i);
				ArrayList<Long> list = new ArrayList<Long>();
				for (long l : c) {
					list.add(l);
				}
				check(list);
			}

		}

	}
}