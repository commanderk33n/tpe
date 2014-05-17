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

public class Graph {

	private Node<?> first;

	public Graph(Node<?> first) {
		this.first = first;
	}

	public Node<?> getFirst() {
		return first;
	}

	public void search() {
		// TODO
	}

	public NodeList copyInto() {
		return copyIntoRek(this.first, new NodeListImpl());

	}

	public NodeList copyIntoRek(Node<?> first, NodeListImpl e) {
		e.add(first);
		for (Node<?> n : first.getChildren()) {
			copyIntoRek(n, e);
		}
		return e;
	}

	public String toString() {
		String ausgabe = this.getFirst().toString();
		NodeListImpl children = this.first.getChildren();
		ausgabe += "[";
		for (Node<?> next : children) {
			Graph graph = new Graph(next);
			ausgabe += graph.toString();
		}
		ausgabe += "] ";
		return ausgabe;

	}

}
