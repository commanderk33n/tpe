package imb.SS14.tpegr01.graph;

/**
 * Einfache Datenstruktur zur Verwaltung einer Reihe von Elementen.
 * 
 * @param <T>
 *            Typ der gespeicherten Elemente.
 */
public interface List<T> extends Iterable<T> {
	/**
	 * Uberpruft, ob ein Element bereits vorhanden ist.
	 * 
	 * @param e
	 *            Element auf das gepruft werden soll
	 * @return true wenn vorhanden, andernfalls false
	 */
	public abstract boolean contains(Object e);

	/**
	 * Fugt am Ende ein Element hinzu.
	 * 
	 * @param e
	 *            Element, das hinzugefugt werden soll.
	 * @return ist immer true
	 */
	public abstract boolean add(T e);

	/**
	 * Fugt am Anfang ein Element hinzu.
	 * 
	 * @param e
	 *            Element, das angefugt werden soll.
	 */
	public abstract void addFirst(T e);

	/**
	 * Liefert das erste Element zuruck, ohne es zu entfernen.
	 * 
	 * @return das erste Element.
	 */
	public abstract T peekFirst();

	/**
	 * Uberpruft, ob Elemente vorhanden sind.
	 * 
	 * @return true wenn die Datenstruktur leer ist, andernlass false
	 */
	public abstract boolean isEmpty();

	/**
	 * Entfernt das erste Element und liefert es zuruck.
	 * 
	 * @return das erste Element
	 */
	public abstract T pollFirst();

	/**
	 * Loscht den Inhalt der List.
	 */
	public abstract void clear();
}
