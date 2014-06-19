/**
 * 
 */
package imb.SS14.tpegr01.collatz;

import java.util.Iterator;

/**
 * Klasse Collatz, die man mit einem Startwert parametrieren kann und aus der
 * man dann über einen Iterator die Elemente der Collatz-Folge nacheinander
 * auslesen kann. Den Iterator ist als anonyme innere Klasse in Collatz
 * implementiert. Die iterative Collatz-Folge ist für natürliche Zahlen wie
 * folgt definiert:
 * 
 * 
 * <p>
 * <blockquote>
 * 
 * <pre>
 * f : N ! N; f(n) = wenn n gerade: ( n : 2); wenn n ungerade: 3n + 1
 * 
 * 
 * </p>
 * </blockquote>
 * 
 * </pre>
 * 
 * @author Philipp Siebert
 * 
 */
public class Collatz implements Iterable<Long> {
	long startValue;

	/**
	 * Konstruktor ohne parametrierten Startwert bekommt den Startwert 1
	 */
	public Collatz() {
		this(1);
	}

	/**
	 * Konstruktor mit parametrierten Startwert
	 * 
	 * @param value
	 *            parametrierter Startwert (sollte sinngemäß >= 1 sein)
	 */
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
	 * Mit der Methode <code>iterator()</code> wird der Iterator als anonyme
	 * innere Klasse in Collatz erstellt
	 * 
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
