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
public class DeepSearch extends SearchStrategyNode {
	
	protected NodeList searchNode(Node<?> n, Object value) {
		NodeList result = new NodeListImpl();
		if (visited.check(n)) {
			if (value.equals(n.getValue())) {
				result.add(n);
			}
			for (Node<?> next : n.getChildren())
				result = searchNode(next, value);
		}
		return result;
	}

}
