package imb.SS14.tpegr01.graph;

/**
 * Der Graph besteht aus einer beliebigen Anzahl von Knoten, wobei einer der
 * Knoten als Anfangsknoten ausgezeichnet wird. Von diesem Anfangsknoten aus
 * können Sie alle anderen Knoten erreichen.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 * @param <T>
 *            Datentyp der gespeichert werden soll
 */

public class Graph<T> {

	private Node<T> first;

	public Graph(Node<T> first) {
		this.first = first;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void search() {
		// TODO
	}

	public NodeList copyInto() {
		return copyIntoRek(this.first, new NodeListImpl());

	}

	public NodeList copyIntoRek(Node<T> first, NodeListImpl e) {
		e.add(first);
		for (Node<T> n : first.getChildren()) {
			copyIntoRek(n, e);
		}
		return e;
	}

}
