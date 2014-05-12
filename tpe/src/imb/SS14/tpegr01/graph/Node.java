package imb.SS14.tpegr01.graph;

/**
 * Die Klasse <code>Node</code> vom generischen Typ T zur speicherung beliebiger
 * Datentypen. Jeder Knoten hat einen Namen und einen Wert beliebigen Typs,
 * weiterhin hat der Knoten beliebig viele Kinder.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 * @param <T>
 *            Datentyp der gespeichert werden soll
 * 
 */

public class Node<T> {

	private String name;
	private T value;

	/**
	 * Hinzufügen eines Kindknotens.
	 * 
	 * @param newChild
	 *            Wert der gespeichert wird.
	 */
	public void addChild(T newChild) {

	}

	/**
	 * Auslesen aller Kindknoten
	 * 
	 * @return Liste aller Kindknoten
	 */

	public NodeList<T> getChildren() {
		NodeList<T> NodeList = null;
		return NodeList;
	}

	/**
	 * Auslesens des Namens des Knotens
	 * 
	 * @return Name des Knotens
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * Auslesen des Werts des Knotens
	 * 
	 * @return Wert des Knotens
	 */

	public T getValue() {
		return this.value;
	}

}
