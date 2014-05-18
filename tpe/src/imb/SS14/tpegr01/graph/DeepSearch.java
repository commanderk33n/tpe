package imb.SS14.tpegr01.graph;

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

	private VisitedList visited = new VisitedList();

	@Override
	public NodeList search(T toSearch, Node<T> start) {
		visited.clear();
		return deepSearch(toSearch, start, new NodeListImpl());
	}

	private NodeList deepSearch(T toSearch, Node<T> start, NodeList result) {
		visited.add(start);
		for (Node<T> n : start.getChildren()) {
			if (visited.contains(n))
				continue;

			if (n.getValue().equals(toSearch)) {
				result.add(n);
			}
			deepSearch(toSearch, n, result);
		}
		return result;
	}

	@Override
	public VisitedList getPath() {
		return this.visited;
	}

}
