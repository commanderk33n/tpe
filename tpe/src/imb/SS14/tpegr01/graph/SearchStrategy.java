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
	 * Suche nach einem bestimmten Wert, ausgehend von einem Startknoten
	 * 
	 * @param toSearch
	 *            Wert nachdem gesucht werden soll
	 * @param start
	 * 			  Startknoten
	 * @return Liste der Knotennamen
	 */
	public NodeList<T> search(T toSearch,Node<T> start);

	/**
	 * Ausgabe des Weges den die Suche beim letzten Durchlauf genommen hat
	 * 
	 * @return Liste der Knotennamen
	 */
	public VisitedList<T> getPath();

}
