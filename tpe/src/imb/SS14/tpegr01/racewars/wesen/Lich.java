package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.Squad;

/**
 * Die Klasse <code>Lich</code> stellt den Anführer der Fraktion
 * <code>Untoter</code> und besitzt die Spezialfähigkeit verwesung die allen
 * Wesen des gegnerischen Squads 7 Schadenspunkte zufügt und diese
 * Schadenspunkte seinen eigenen Lebenspunkten zufügt.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 */

public class Lich extends Untoter implements Helden {

	public Held name;
	private int spezialangriffRunde;

	/**
	 * Konstruktor der Klasse <code>Lich</code>
	 */
	public Lich() {
		super(true, Held.LICH.getBonusfaktor());
		this.name = Held.LICH;
		this.spezialangriffRunde = 0;
	}

	public void spezialfunktion(Squad s, int runde) {
		if (runde > spezialangriffRunde) {
			verwesung(s);
			spezialangriffRunde = runde;
		}
	}

	/**
	 * Spezialfähigkeit verwesung die allen Wesen des gegnerischen Squads 7
	 * Schadenspunkte zufügt und diese Schadenspunkte seinen eigenen
	 * Lebenspunkten zufügt.
	 * 
	 * @param s
	 *            das Gegnerische Squad das angegriffen wird
	 */
	private void verwesung(Squad s) {
		for (int i = 0; i < s.getLebendige(); i++) {
			s.getWesen(i).bekommtSchaden(7);
		}
		this.bekommtSchaden(-7 * s.getLebendige());

	}

	public double elementBonus(Helden ziel) {
		String feindlichesElement = ziel.getElement();
		if (feindlichesElement == "Feuer") {
			return 2;
		} else {
			return 1;
		}
	}

	public String getElement() {
		return name.getElement();
	}

	public String getName() {
		return "Lich";
	}

}
