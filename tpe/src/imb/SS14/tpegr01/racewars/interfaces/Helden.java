package imb.SS14.tpegr01.racewars.interfaces;

import imb.SS14.tpegr01.racewars.Squad;

/**
 * Interface für alle Anführer(Helden) mit Methoden die alle Helden besitzten
 * müssen um Helden zu sein. (getElement(),getName(), elementBonus(Helden ziel),
 * spezialfunktion(Squad s, int runde))
 * 
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 */
public interface Helden {

	public static enum Held {
		FARSEER(1.2, "Erde"), LICH(2.3, "Wasser"), DAEMONENJAEGER(3.0, "Luft"), ERZMAGIER(
				5.0, "Feuer");

		private final double BONUSFAKTOR;
		private final String ELEMENT;

		private Held(double bonusfaktor, String element) {
			this.BONUSFAKTOR = bonusfaktor;
			this.ELEMENT = element;
		}

		public double getBonusfaktor() {
			return this.BONUSFAKTOR;
		}

		public String getElement() {
			return this.ELEMENT;
		}

	}

	/**
	 * Gibt Element des Helden aus
	 * 
	 * @return Element des Helden
	 */
	public abstract String getElement();

	/**
	 * Methode zur Ermittlung von zusätzlichen Elementbonus bei der
	 * Schadensberechnung
	 * 
	 * @param ziel
	 *            Gegnerischer Held, dessen Elemnt ausschlaggebend ist
	 * @return Parameter zur weiteren Schadensberechnung 1 bei keinem
	 *         Elementbonus, 2 bei Elementbonus
	 */
	public abstract double elementBonus(Helden ziel);

	/**
	 * Ruft die entsprechende Spezialfähigkeit der Helden auf
	 * 
	 * @param s
	 *            das gegnerische Squad, auf das die Spezialfähigkeit angewendet
	 *            wird
	 * @param runde
	 *            aktuelle Runde um zu ermitteln ob die Spezialfähigkeit
	 *            einsatzbereit ist
	 */
	public abstract void spezialfunktion(Squad s, int runde);

	/**
	 * Gibt Name des Helden aus
	 * 
	 * @return Name des Helden
	 */
	public abstract String getName();
}
