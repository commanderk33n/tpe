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
	private VisitedList visited;

	/**
	 * Konstruktor zur Klasse <code>Graph</code>
	 * 
	 * @param first
	 *            Anfangsknoten
	 */
	public Graph(Node<?> first) {
		this.first = first;
		this.visited = new VisitedList();
	}

	/**
	 * Liefert das erste Element des Graphen (Anfangsknoten)
	 * 
	 * @return Anfangsknoten
	 */
	public Node<?> getFirst() {
		return first;
	}

	/**
	 * Ruft einen Suchalgorithmus auf, um den Graphen nach Elementen mit dem
	 * gesuchten Wert zu durchzuschen
	 * 
	 * @param value
	 *            Wert nachdem der Graph untersucht wird
	 * @param strategy
	 *            Suchstrategie, die verwendet werden soll
	 * @return Liste aller Knoten mit dem gewünschten Element
	 */
	public NodeList search(Object value, SearchStrategy strategy) {
		return strategy.search(value,this);
	}

	/**
	 * 
	 * Kopieren aller Knoten in eine übergebene Liste
	 * 
	 * @param e
	 *            Liste in die alle Elemente kopiert werden
	 */
	public void copyInto(NodeList e) {
		visited.clear();
		copyIntoRek(this.first, e);

	}

	/**
	 * Kopiert rekursiv alle Elemnte in die übergebene Liste ohne doppelte
	 * Elemente zu übernehmen
	 * 
	 * @param first
	 *            aktuelles Element das kopiert werden soll
	 * @param e
	 *            Liste in die alle Elemente kopiert werden
	 */
	private void copyIntoRek(Node<?> first, NodeList e) {
		if (!e.contains(first)) {
			e.add(first);
			for (Node<?> n : first.getChildren()) {
				copyIntoRek(n, e);
			}
		}
	}

	/**
	 * Ausgabe aller Elemente des Graphens, alle Folge-Elemente eines Elements
	 * werden in eckigen Klammern angegeben, falls ein Element keine
	 * Folge-Elemente besitzt wird "[]" ausgegeben. Bei rekursiven
	 * Wiederholungen wird nur der Name des ersten wiederholenden Elements
	 * ausgegeben.
	 * 
	 */
	public String toString() {
		visited.clear();
		String ausgabe = getAllElements(this.first);
		return ausgabe;

	}

	/**
	 * Ausgabe eines Elements und all seiner Folge-Elemente, die in eckigen
	 * Klammern angegeben werden, falls ein Element keine Folge-Elemente besitzt
	 * wird "[]" ausgegeben. Bei rekursiven Wiederholungen wird nur der Name des
	 * ersten wiederholenden Elements ausgegeben.
	 * 
	 * @param element
	 *            Elements das Ausgelesen werden soll
	 * @return Name und Wert der gefundenen Elemente
	 */
	private String getAllElements(Node<?> element) {
		String ausgabe = "";
		if (visited.check(element)) {
			ausgabe = element.toString();
			NodeListImpl children = element.getChildren();
			ausgabe += "[";
			for (Node<?> next : children) {

				ausgabe += getAllElements(next);
			}

			ausgabe += "] ";
		} else {
			ausgabe = element.getName();
		}
		return ausgabe;
	}

}
