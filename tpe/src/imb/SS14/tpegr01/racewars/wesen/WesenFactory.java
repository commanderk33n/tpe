package imb.SS14.tpegr01.racewars.wesen;

/**
 * Die Klasse <code>WesenFactory</code> erstellt Rassen mit gewünschter
 * Investition. Die Kosten für: Ork: 150 Mensch: 110 Untote: 70 Nachtelf: 145
 * Für Anführer betragen die Kosten der Anführerrasse * 2.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 02/05/2014
 * 
 */

public class WesenFactory {

	public static enum Rasse {
		ORKS(150), MENSCHEN(110), UNTOTE(70), NACHTELFEN(145);

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

	/**
	 * Ermittelt wieviel Rasse-Objekte man mit der entsprechenden Investition
	 * anlegen kann und erstellt diese Objekte in ein Array.
	 * 
	 * @param rasse
	 *            Rasse, die zu Erstellen ist.
	 * @param invest
	 *            Entsprechende Investition für die Rasse.
	 * @return Gibt die erstellten Objekte einer Rasse zurück.
	 */

	public static Wesen[] erschaffe(Rasse rasse, int invest) {
		int truppenAnzahl = ermittleAnzahl(rasse.getKostenAnfuehrer(),
				rasse.getKosten(), invest);
		Wesen[] armee = new Wesen[truppenAnzahl];
		if (armee.length < 1) {
			return armee;
		}
		if (rasse == Rasse.ORKS) {
			armee = erschaffeOrks(armee);
		} else if (rasse == Rasse.MENSCHEN) {
			armee = erschaffeMenschen(armee);
		} else if (rasse == Rasse.UNTOTE) {
			armee = erschaffeUntote(armee);
		} else {
			armee = erschaffeNachtelfen(armee);
		}
		return armee;
	}

	/**
	 * Erstellt ein Objekt der Klasse <code>Farseer</code> und entsprechend der
	 * länge des Arrays viele Objecte der Klasse <code>Ork</code>
	 * 
	 * @param armee
	 * @return armee gefülltes Array mit den Wesen Objekten
	 */
	private static Wesen[] erschaffeOrks(Wesen[] armee) {
		armee[0] = new Farseer();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Ork();
		}
		return armee;
	}

	/**
	 * Erstellt ein Objekt der Klasse <code>Erzmagier</code> und entsprechend
	 * der länge des Arrays viele Objecte der Klasse <code>Mensch</code>
	 * 
	 * @param armee
	 * @return armee gefülltes Array mit den Wesen Objekten
	 */
	private static Wesen[] erschaffeMenschen(Wesen[] armee) {
		armee[0] = new Erzmagier();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Mensch();
		}
		return armee;
	}

	/**
	 * Erstellt ein Objekt der Klasse <code>Lich</code> und entsprechend der
	 * länge des Arrays viele Objecte der Klasse <code>Untoter</code>
	 * 
	 * @param armee
	 * @return armee gefülltes Array mit den Wesen Objekten
	 */
	private static Wesen[] erschaffeUntote(Wesen[] armee) {
		armee[0] = new Lich();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Untoter();
		}
		return armee;
	}

	/**
	 * Erstellt ein Objekt der Klasse <code>Farseer</code> und entsprechend der
	 * länge des Arrays viele Objecte der Klasse <code>Ork</code>
	 * 
	 * @param armee
	 * @return armee gefülltes Array mit den Wesen Objekten
	 */
	private static Wesen[] erschaffeNachtelfen(Wesen[] armee) {
		armee[0] = new Daemonenjaeger();
		for (int i = 1; i < armee.length; i++) {
			armee[i] = new Nachtelf();
		}
		return armee;
	}

	/**
	 * Ermittelt anhand der Investition, Truppen- und Anfuehrerkosten die Anzahl
	 * der zuproduzierenden Truppen.
	 * 
	 * @param anfuehrerKosten
	 *            Preis des Anfuehrers
	 * @param truppenKosten
	 *            Preis der normalen Truppen
	 * @param invest
	 *            Geld das zur Truppenproduktion zur Verfügung steht
	 * @return Anzahl der zuproduzierenden Truppen
	 */
	private static int ermittleAnzahl(int anfuehrerKosten, int truppenKosten,
			int invest) {
		int truppenAnzahl = 0;
		int rest = invest - anfuehrerKosten;
		while (rest >= 0) {
			truppenAnzahl++;
			rest -= truppenKosten;
		}
		return truppenAnzahl;

	}

}
