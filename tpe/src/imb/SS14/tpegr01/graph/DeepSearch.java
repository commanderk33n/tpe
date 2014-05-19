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
	 * @param start
	 * @param result
	 * @return result
	 */


	private NodeList<T> deepSearch(T toSearch, Node<T> start, NodeList<T> result) {
		visited.add(start);
		for (Node<T> n : start.getChildren()) {
			if (n.getValue().equals(toSearch)) {
				result.add(n);
			}


			if (visited.contains(n)){
				continue;
			}




			deepSearch(toSearch, n, result);
		}
		return result;
	}


	@Override
	public VisitedList<T> getPath() {
		return this.visited;
	}


}
