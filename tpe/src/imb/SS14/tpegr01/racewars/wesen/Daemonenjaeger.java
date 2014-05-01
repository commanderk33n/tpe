package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.Squad;

public class Daemonenjaeger extends Nachtelf implements Helden {

	public Held name;
	private int spezialangriffRunde;

	public Daemonenjaeger() {
		super(true, Held.DAEMONENJAEGER.getBonusfaktor());
		this.name = Held.DAEMONENJAEGER;
		this.spezialangriffRunde = 0;
	}

	public void spezialfunktion(Squad s, int runde) {
		if (runde > spezialangriffRunde) {
			goldschuss(s);
			spezialangriffRunde = runde;
		}
	}

	public void goldschuss(Squad s) {
		for (int i = 0; i < s.getLebendige(); i++) {
			s.getWesen(i).bekommtSchaden(25);
		}
	}

	public double elementBonus(Helden ziel) {
		String feindlichesElement = ziel.getElement();
		if (feindlichesElement == "Erde") {
			return 2;
		} else {
			return 1;
		}
	}

	public String getElement() {
		return name.getElement();
	}

	public String getName() {
		return "Dämonenjäger";
	}
}
