package imb.SS14.tpegr01.graph;

/**
 * Die Klasse <code>Node</code> vom generischen Typ T zur speicherung beliebiger
 * Datentypen. Jeder Knoten hat einen Namen und einen Wert beliebigen Typs, und
 * beliebig viele Kinder
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
	private NodeListImpl<T> children;

	/**
	 * Konstruktor erstellt einen Knoten
	 * 
	 * @param name
	 * @param value
	 * @param n
	 */

	public Node(String name, T value, NodeListImpl<T> n) {
		this(name, value);
		this.children = n;
	}

	/**
	 * Konstruktor erstellt einen Knoten
	 * 
	 * @param name
	 * @param value
	 */

	public Node(String name, T value) {
		this.name = name;
		this.value = value;
		this.children = new NodeListImpl<T>();
	}

	/**
	 * Hinzufügen eines Kindknotens.
	 * 
	 * @param newChild
	 *            Wert der gespeichert wird.
	 */
	public void addChild(Node<T> newChild) {
		children.add(newChild);
	}

	/**
	 * Auslesen aller Kindknoten
	 * 
	 * @return Liste aller Kindknoten
	 */

	public NodeListImpl<T> getChildren() {
		return this.children;
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

	/**
	 * Allgeime Ausgabe des Knotens liefert Name und Value, getrennt durch ein
	 * " = "
	 * 
	 * @return Name und Value, getrennt durch ein " = "
	 */
	public String toString() {
		return getName() + " = " + getValue();
	}

}
