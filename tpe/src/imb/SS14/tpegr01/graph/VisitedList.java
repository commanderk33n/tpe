package imb.SS14.tpegr01.graph;

public class VisitedList<T> extends NodeListImpl<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean check(Node<T> newEntry) {
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
