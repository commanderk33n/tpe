package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.Squad;



public class Lich extends Untoter implements Helden {

	public Held name;
	private int spezialangriffRunde;

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
