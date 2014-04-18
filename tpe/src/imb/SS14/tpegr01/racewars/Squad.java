package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;
import imb.SS14.tpegr01.racewars.wesen.Wesen;

public class Squad {

	private String name;
	private Wesen[] armee;
	int lebendigeWesen;

	public Squad(String name, String klasse, int invest) {
		this.name = name;
		this.armee = rekrutiereArmee(klasse, invest);
		this.lebendigeWesen = this.armee.length;
	}

	public Squad(String name, String klasse1, int invest1, String klasse2,
			int invest2) {
		this.name = name;
		Wesen[] truppe1 = rekrutiereArmee(klasse1, invest1);
		Wesen[] truppe2 = rekrutiereArmee(klasse2, invest2);
		this.armee = new Wesen[truppe1.length + truppe2.length];
		for (int i = 0; i < armee.length; i++) {
			if (i < truppe1.length) {
				this.armee[i] = truppe1[i];
			} else {
				this.armee[i] = truppe2[i - truppe1.length];
			}
		}
		this.lebendigeWesen = this.armee.length;
	}

	private Wesen[] rekrutiereArmee(String klasse, int invest) {
		Rasse rasse = ermittleKlasse(klasse.toUpperCase());
		Wesen[] armee = WesenFactory.erschaffe(invest, rasse);
		return armee;
	}

	private Rasse ermittleKlasse(String klasse) {
		switch (klasse) {
		case "ORKS":
		case "ORK":
			return Rasse.ORK;
		case "MENSCH":
		case "MENSCHEN":
			return Rasse.MENSCH;
		case "UNTOTER":
		case "UNTOTE":
			return Rasse.UNTOTER;
		case "NACHTELF":
		case "NACHTELFEN":
			return Rasse.NACHTELF;
		default:
			return Rasse.MENSCH;

		}
	}

	public void entferneWesenAusSquad(int index) {
		if (!armee[index].isLebendig()) {
			Wesen gestorbenesWesen = armee[index];
			armee[index] = armee[lebendigeWesen];
			armee[lebendigeWesen] = gestorbenesWesen;
			lebendigeWesen--;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getLebendige() {
		return this.lebendigeWesen;
	}

}
