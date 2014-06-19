/**
 * 
 */
package imb.SS14.tpegr01.collatz;

import java.util.ArrayList;
import java.util.Date;

/**
 * Die Klasse <code>CollatzRunner</code> findet die länsgte Collatz-Folge
 * innerhalb eines bestimmten Startberreiches und kann dabei mehrere Threads
 * verwenden.
 * 
 * 
 * @author Philipp Siebert
 * 
 */
public class CollatzRunner implements Runnable {

	final long range;
	private long index;
	private ArrayList<Long> longestSequence;

	public CollatzRunner(long range) {
		this.range = range;
		this.index = 0;
		longestSequence = new ArrayList<Long>();
	}

	public CollatzRunner() {
		this(1000000);
	}

	/**
	 * findet die länsgte Collatz-Folge innerhalb eines bestimmten
	 * Werteberreiches und kann dabei mehrere Threads verwenden.
	 * 
	 * @param numberOfThreads
	 *            Anzahl der Threads die verwendet werden sollen
	 */
	public void findLongestSequence(int numberOfThreads) {
		Date startZeit = new Date();
		Thread[] threads = new Thread[numberOfThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
		}
		for (Thread t : threads) {
			t.start();
		}
		try {
			for (Thread t : threads) {
				t.join();
			}
		} catch (InterruptedException e) {
			System.out.println("Fehler! " + e.getMessage());
			e.printStackTrace();
		}
		Date endZeit = new Date();
		index = 0;
		long zeit = endZeit.getTime() - startZeit.getTime();
		System.out.println("Mit " + numberOfThreads + " Thread(s) : " + zeit
				+ " ms");
	}

	/**
	 * Vergleicht die Collatz Folge mit der gespeicherten Folge und übernimmt
	 * diese falls sie mehr elemente also länger ist
	 * 
	 * @param list
	 *            neue Collatz Folge
	 */
	private synchronized void compareToLongestSequence(ArrayList<Long> list) {
		if (longestSequence.size() < list.size()) {
			longestSequence = list;
		}
//		System.out.println(Thread.currentThread().getName() + ": "
//				+ list.get(0));
	}

	/**
	 * Gibt solange neue Startwerte für die Collatz Folge zurück wie der Index
	 * kleiner ist als der angegebene Werteberreiche
	 * 
	 * @return neuer Startwert für die Collatz Folge
	 */
	private synchronized long getNextStartingValue() {
		if (index < range) {
			return index++;
		} else {
			return -1;
		}
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long i = getNextStartingValue();
		while (i != -1) {
			Collatz c = new Collatz(i);
			ArrayList<Long> list = new ArrayList<Long>();
			for (long l : c) {
				list.add(l);
			}
			compareToLongestSequence(list);
			i = getNextStartingValue();
		}

	}

	public ArrayList<Long> getLongestSequence() {
		return this.longestSequence;
	}

	public static void main(String[] args) {
		CollatzRunner runner = new CollatzRunner();
		for (int i = 1; i <= 10; i++) {
			runner.findLongestSequence(i);
		}

	}
}