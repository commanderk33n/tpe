/**
 * 
 */
package imb.SS14.tpegr01.collatz;

import java.util.Iterator;

/**
 * @author Philipp Siebert
 * 
 */
public class Collatz implements Iterable<Long> {
	long startValue;

	public Collatz() {
		this(1);
	}

	public Collatz(long value) {
		setStartValue(value);
	}

	public long getStartValue() {
		return this.startValue;
	}

	public void setStartValue(long value) {
		if (value < 1) {
			this.startValue = 1;
		} else {
			this.startValue = value;
		}
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Long> iterator() {
		Iterator<Long> o = new Iterator<Long>() {

			long n = getStartValue();
			boolean first = true;

			@Override
			public boolean hasNext() {
				if (n > 1) {
					return true;
				}
				return false;
			}

			@Override
			public Long next() {
				if (first) {
					first = false;
					return n;
				}
				if (n % 2 == 0) {
					n = n / 2;
				} else {
					n = 3 * n + 1;
				}

				return n;
			}

			@Override
			public void remove() {
				// not supported

			}

		};
		return o;
	}
}
