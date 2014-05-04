package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.Kaempfer;

/**
 * Die Klasse <code>Geist</code> modelliert einen nicht Spielbaren Geist
 * Geister haben keine Attribute und können nur 1 Schaden verursachen
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 */

public class Geist implements Kaempfer { 
	/**
	 * Konstruktor der Klasse <code>Geist</code>
	 */

	public Geist() {

	}

	public double attacke(Kaempfer r) {
		return 1;
	}

}
