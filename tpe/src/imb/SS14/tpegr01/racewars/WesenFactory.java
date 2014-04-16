package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.wesen.*;

public class WesenFactory {

	public static enum Rasse {
		ORK(150), MENSCH(110), UNTOTER(70), NACHTELF(145);

		private final int KOSTEN;

		private Rasse(int kosten) {
			this.KOSTEN = kosten;
		}

		public int getKosten() {
			return this.KOSTEN;
		}

		public int getKostenAnfuehrer() {
			return this.KOSTEN * 2;
		}

	};

	public static Wesen[] erschaffe(int invest, Rasse rasse) {
		int truppenAnzahl = ermittleAnzahl(rasse.getKostenAnfuehrer(),
				rasse.getKosten(), invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		if (rasse == Rasse.ORK) {
			armee = erschaffeOrks(armee);
		} else if (rasse == Rasse.MENSCH) {
			armee = erschaffeMenschen(armee);
		} else if (rasse == Rasse.UNTOTER) {
			armee = erschaffeUntote(armee);
		} else {
			armee = erschaffeNachtelfen(armee);
		}
		return armee;
	}

	private static Wesen[] erschaffeOrks(Wesen[] armee) {
		armee[0] = new Farseer();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Ork();
		}
		return armee;
	}

	private static Wesen[] erschaffeMenschen(Wesen[] armee) {
		armee[0] = new Erzmagier();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Mensch();
		}
		return armee;
	}

	private static Wesen[] erschaffeUntote(Wesen[] armee) {
		armee[0] = new Lich();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Untoter();
		}
		return armee;
	}

	private static Wesen[] erschaffeNachtelfen(Wesen[] armee) {
		armee[0] = new Daemonenjaeger();
		for (int i = 1; i < armee.length; i++) {
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
