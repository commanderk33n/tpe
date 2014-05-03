package imb.SS14.tpegr01.racewars.wesen;

/**
 * Die  Klasse <code>Ork</code> modelliert die Einheiten "Orks" für das
 * Spiel RaceWars - mit ihren Eigenschaften und Fähigkeiten - und ist von der 
 * abstrakten Klasse <code>Wesen</code> abgeleitet
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 02/05/2014
 * 
 */


public class Ork extends Wesen {

	public Ork() {
		this(false, 1.0);
	}

	protected Ork(boolean istHeld, double bonusfaktor) {
		super("Ork", istHeld, 100.0, 0.3, 33.0, 1.0, 4.0, bonusfaktor);
	}

}
