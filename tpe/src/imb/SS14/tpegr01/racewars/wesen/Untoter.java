package imb.SS14.tpegr01.racewars.wesen;

/**
 * Die  Klasse <code>Untoter</code> modelliert die Einheiten "Untoter" für das
 * Spiel RaceWars - mit ihren Eigenschaften und Fähigkeiten - und ist von der 
 * abstrakten Klasse <code>Wesen</code> abgeleitet
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 02/05/2014
 * 
 */

public class Untoter extends Wesen {
	/**
	 * Konstruktor der Klasse <code>Untoter</code>
	 */

	public Untoter() {
		this(false, 1.0);
	}

	protected Untoter(boolean istHeld, double bonusfaktor) {
		super("Untoter", istHeld, 120.0, 0.3, 16.0, 2.0, 1.6, bonusfaktor);
	}

}
