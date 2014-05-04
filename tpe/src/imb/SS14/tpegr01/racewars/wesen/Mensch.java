package imb.SS14.tpegr01.racewars.wesen;

/**
 * Die  Klasse <code>Mensch</code> modelliert die Einheiten "Mensch" für das
 * Spiel RaceWars - mit ihren Eigenschaften und Fähigkeiten - und ist von der 
 * abstrakten Klasse <code>Wesen</code> abgeleitet
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 02/05/2014
 * 
 */


public class Mensch extends Wesen {
	/**
	 * Konstruktor der Klasse <code>Mensch</code>
	 */

	public Mensch() {
		this(false, 1.0);
	}

	protected Mensch(boolean istHeld, double bonusfaktor) {
		super("Mensch", istHeld, 140.0, 0.4, 40.0, 2.0, 10.0, bonusfaktor);
	}

	protected double beschraenkeSchaden(double damage) {
		return (damage * this.getSpezialattribut() / 100);
	}

}
