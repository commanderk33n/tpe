package imb.SS14.tpegr01.graph;

/**
 * Eine Implementierung der SearchStrategy Breitensuche.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 * @param <T>
 *            Datentyp der gesucht werden soll
 */
public class BreadthFirstSearch<T> implements SearchStrategy<T> {
	private VisitedList<T> visited = new VisitedList<T>();


	@Override
	public NodeList<T> search(T toSearch, Node<T> start) {
		visited.clear();
		NodeList<T> startLevel = new NodeListImpl<T>();
		startLevel.add(start);
		return breadthSearch(toSearch, startLevel, new NodeListImpl<T>());
	}

	/**
	 * Für jede nächste Ebene wird eine neue Liste erzeugt - Mit der äußeren
	 * for-Schleife suchen wir auf der aktuellen Ebene nach dem gesuchten
	 * Element - In der inneren holen wir uns die nächsten Kindknoten von der
	 * jetzigen Ebene - Die Rekursion ruft sich immer mit der nächsten Ebene auf
	 * sobald ein in der aktuellen das Ende erreicht wird.
	 * 
	 * @param toSearch
	 * @param startLevel
	 * @param result
	 * @return Liste der gefundenen Knoten
	 */

	private NodeList<T> breadthSearch(T toSearch, NodeList<T> startLevel,
			NodeList<T> result) {
		NodeList<T> nextLevel = new NodeListImpl<T>();
		for (Node<T> n : startLevel) {
			if (visited.contains(n))
				continue;
			if (n.getValue().equals(toSearch)) {
				result.add(n);
			}
			visited.add(n);

			for (Node<T> child : n.getChildren()) {
				nextLevel.add(child);
			}
		}

		if (!nextLevel.isEmpty()) {
			breadthSearch(toSearch, nextLevel, result);
		}

		return result;
	}

	@Override
	public VisitedList<T> getPath() {

		return visited;
	}

}
