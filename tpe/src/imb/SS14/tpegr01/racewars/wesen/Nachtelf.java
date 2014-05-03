package imb.SS14.tpegr01.racewars.wesen;

/**
 * Die  Klasse <code>Nachtelf</code> modelliert die Einheiten "Nachtelf" für das
 * Spiel RaceWars - mit ihren Eigenschaften und Fähigkeiten - und ist von der 
 * abstrakten Klasse <code>Wesen</code> abgeleitet
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 02/05/2014
 * 
 */


public class Nachtelf extends Wesen {

	public Nachtelf() {
		this(false, 1.0);
	}

	protected Nachtelf(boolean istHeld, double bonusfaktor) {
		super("Nachtelf", istHeld, 120.0, 0.2, 15.0, 3.0, 2.9,bonusfaktor);
	}

}
