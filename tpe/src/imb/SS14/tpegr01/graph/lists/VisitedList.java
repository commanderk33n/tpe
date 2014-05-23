package imb.SS14.tpegr01.graph.lists;

import imb.SS14.tpegr01.graph.Node;

public class VisitedList<T> extends NodeListImpl<T> {

	/**
	 * Die Klasse <code>VisitedList</code> mit der Methode
	 * <code>addOnlyOnce(Node<T> newEntry)</code> dient als Speicherliste eines
	 * besuchten Pfades, da sie keine identischen Knoten speichert, sondern nur
	 * ein Element hinzufügt, falls dieses noch nicht in der Liste vorhanden
	 * ist.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <code>addOnlyOnce(Node<T> newEntry)</code> speichert keine identischen
	 * Knoten, sondern fügt nur ein Element hinzu, falls dieses noch nicht in
	 * der Liste vorhanden ist.
	 * 
	 * @param newEntry
	 *            neues Element das hinzugefügt werden soll
	 * @return <code>true</code>, falls noch nicht vorhanden und hinzugefügt
	 *         wurde oder <code>false</code>, falls bereits vorhanden und nicht
	 *         hinzugefügt
	 */
	public boolean addOnlyOnce(Node<T> newEntry) {
		if (!this.contains(newEntry)) {
			return this.add(newEntry);
		} else {
			return false;
		}
	}

	public String toString() {
		String ausgabe = "[";
		for (int i = 0; i < this.size(); i++) {
			ausgabe += this.get(i).getName();
			if (i + 1 < this.size()) {
				ausgabe += ", ";
			}
		}
		ausgabe += "]";
		return ausgabe;
	}

}
