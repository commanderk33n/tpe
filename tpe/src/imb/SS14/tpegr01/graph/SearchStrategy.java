package imb.SS14.tpegr01.graph;

/**
 * Interface zur Implementierung verschiedener Suchstrategien
 * 
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 * @param <T>
 *            Datentyp der gesucht werden soll
 */
public interface SearchStrategy<T> {
	/**
	 * Wendet Suchstrategie an um alle Knoten mit einem bestimmten Wert.
	 * 
	 * @param value
	 *            Wert nachdem gesucht werden soll
	 * @return Liste der Knotennamen
	 */
	public NodeList search(T toSearch,Node<T> start);

	/**
	 * Ausgabe des Weges den die Suche beim letzten Durchlauf genommen hat
	 * 
	 * @return Liste der Knotennamen
	 */
	public VisitedList getPath();

}
