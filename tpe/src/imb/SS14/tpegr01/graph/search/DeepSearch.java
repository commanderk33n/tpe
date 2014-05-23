package imb.SS14.tpegr01.graph.search;

import imb.SS14.tpegr01.graph.Node;
import imb.SS14.tpegr01.graph.lists.NodeList;
import imb.SS14.tpegr01.graph.lists.NodeListImpl;
import imb.SS14.tpegr01.graph.lists.VisitedList;

/**
 * Eine Implementierung der SearchStrategy Tiefensuche.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 * @param <T>
 *            Datentyp der gesucht werden soll
 */
public class DeepSearch<T> implements SearchStrategy<T> {

	private VisitedList<T> visited = new VisitedList<T>();

	@Override
	public NodeList<T> search(T toSearch, Node<T> start) {
		visited.clear();
		return deepSearch(toSearch, start, new NodeListImpl<T>());
	}

	/**
	 * Rekursive Tiefensuche
	 * 
	 * @param toSearch
	 *            Wert nachdem gesucht wird
	 * @param start
	 *            Startknoten
	 * @param result
	 *            Liste in der die gefundenen passenden Knoten gespeichert
	 *            werden
	 * @return result Liste mit den gefundenen passenden Knoten
	 */

	private NodeList<T> deepSearch(T toSearch, Node<T> start, NodeList<T> result) {
		visited.addOnlyOnce(start);
		for (Node<T> n : start.getChildren()) {
			if (n.getValue().equals(toSearch)) {
				result.add(n);
			}
			if (visited.addOnlyOnce(n)) {
				deepSearch(toSearch, n, result);
			}
		}
		return result;
	}

	@Override
	public VisitedList<T> getPath() {
		return this.visited;
	}

}
