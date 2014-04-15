package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.wesen.*;

public class WesenFactory {

	public static enum Rasse {
		ORKS, MENSCHEN, UNTOTE, NACHTELFEN
	};

	public static Wesen[] erschaffe(int invest, Rasse rasse) {
		Wesen[] armee;
		if (rasse == Rasse.ORKS) {
			armee = erschaffeOrks(invest);
		} else if (rasse == Rasse.MENSCHEN) {
			armee = erschaffeMenschen(invest);
		} else if (rasse == Rasse.UNTOTE) {
			armee = erschaffeUntote(invest);
		} else {
			armee = erschaffeNachtelfen(invest);
		}
		return armee;
	}

	private static Wesen[] erschaffeOrks(int invest) {
		int truppenAnzahl = ermittleAnzahl(300, 150, invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		armee[0] = new Farseer();
		for (int i = 1; i < truppenAnzahl; i++) {
			armee[i] = new Ork();
		}
		return armee;
	}

	private static Wesen[] erschaffeMenschen(int invest) {
		int truppenAnzahl = ermittleAnzahl(220, 110, invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		armee[0] = new Erzmagier();
		for (int i = 1; i < truppenAnzahl; i++) {
			armee[i] = new Mensch();
		}
		return armee;
	}

	private static Wesen[] erschaffeUntote(int invest) {
		int truppenAnzahl = ermittleAnzahl(140, 70, invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		armee[0] = new Lich();
		for (int i = 1; i < truppenAnzahl; i++) {
			armee[i] = new Untoter();
		}
		return armee;
	}

	private static Wesen[] erschaffeNachtelfen(int invest) {
		int truppenAnzahl = ermittleAnzahl(145, 290, invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		armee[0] = new Daemonenjaeger();
		for (int i = 1; i < truppenAnzahl; i++) {
			armee[i] = new Nachtelf();
		}
		return armee;
	}

	private static int ermittleAnzahl(int anfuehrerKosten, int truppenKosten,
			int invest) {
		int truppenAnzahl = 0;
		int rest = invest - anfuehrerKosten;
		while (rest > 0) {
			truppenAnzahl++;
			rest -= truppenKosten;
		}
		return truppenAnzahl;

	}

}
