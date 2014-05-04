package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.Squad;
import imb.SS14.tpegr01.racewars.interfaces.*;

public class Farseer extends Ork implements Helden {

	public Held name;
	int spezialangriffRunde;

	public Farseer() {
		super(true, Held.FARSEER.getBonusfaktor());
		this.name = Held.FARSEER;
		this.spezialangriffRunde = 0;
	}

	public void spezialfunktion(Squad s, int runde) {
		if (runde > spezialangriffRunde) {
			doppelschlag(s);
			spezialangriffRunde = runde;
		}
	}

	private void doppelschlag(Squad s) {
		for (int i = 0; i < 2; i++) {
			if (s.getLebendige() > 0) {
				int index = s.zufallsIndex();
				s.getWesen(index).aussloeschen();
				s.kampffaehig(index);
			}
		}

	}

	public double elementBonus(Helden ziel) {
		String feindlichesElement = ziel.getElement();
		if (feindlichesElement == "Wasser") {
			return 2;
		} else {
			return 1;
		}
	}

	public String getElement() {
		return name.getElement();
	}

	public String getName() {
		return "Farseer";
	}
}
