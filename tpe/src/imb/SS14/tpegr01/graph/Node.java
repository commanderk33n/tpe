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
	private NodeList n;
	
	
	public Node(String name, T value, NodeList n){
		this.name = name;
		this.value = value;
		this.n = n;
	}

	/**
	 * Hinzufügen eines Kindknotens.
	 * 
	 * @param newChild
	 *            Wert der gespeichert wird.
	 */
	public void addChild(Node<T> newChild) {
		n.add(newChild);
	}

	/**
	 * Auslesen aller Kindknoten
	 * 
	 * @return Liste aller Kindknoten
	 */

	public NodeList getChildren() {
		
		return this.n;
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
