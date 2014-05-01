package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;

/**
 * Die Klasse <code>Spieler</code> erstellt einen neuen Speiler, der max. zwei
 * Rassen und die dazugehörigen Investitionen sowie den Squadnamen wählen kann.
 * Die einggaben werden direkt geprüft und falls nötig angepasst.
 * 
 * 
 * @author Philipp Siebert
 * 
 */
public class Spieler {
	private int konto;
	private Rasse[] gewaehlteKlassen;
	private int[] gewaehlteInvestitionen;
	private String squadname;

	/**
	 * Kostruktor der Klasse <code>Spieler</code> mit nur einer gewählten Rasse.
	 * 
	 * @param name
	 *            Name des Squads
	 * @param rasse1
	 *            Rasse der Wesen
	 * @param investRasse1
	 *            Menge an Elfendollar die für das Rekrutieren der Rasse
	 *            ausgegeben werden sollen
	 */
	public Spieler(String name, String rasse1, int investRasse1) {
		this(name, rasse1, investRasse1, null, 0);
	}

	/**
	 * Kostruktor der Klasse <code>Spieler</code> mit zwei gewählten Rassen.
	 * 
	 * @param name
	 *            Name des Squads
	 * @param rasse1
	 *            Rasse der ersten Wesen
	 * @param investRasse1
	 *            Menge an Elfendollar die für das Rekrutieren der ersten Rasse
	 *            ausgegeben werden sollen
	 * @param rasse2
	 *            Rasse der zweiten Wesen
	 * @param investRasse2
	 *            Menge an Elfendollar die für das Rekrutieren der zweiten Rasse
	 *            ausgegeben werden sollen
	 */
	public Spieler(String name, String rasse1, int investRasse1, String rasse2,
			int investRasse2) {
		this.squadname = name;
		setKonto();
		if (rasse2 != null) {
			this.gewaehlteKlassen = new Rasse[] { pruefeKlasse(rasse1),
					pruefeKlasse(rasse2) };
			this.gewaehlteInvestitionen = new int[] {
					pruefeInvestition(investRasse1),
					pruefeInvestition(investRasse2) };
		} else {
			this.gewaehlteKlassen = new Rasse[] { pruefeKlasse(rasse1) };
			this.gewaehlteInvestitionen = new int[] { pruefeInvestition(investRasse1) };
		}
	}

	/**
	 * Konto des Spielers wird standartmäßig auf 2000 Elfendolar gesetzt.
	 */
	private void setKonto() {
		this.konto = 2000;
	}

	/**
	 * Eingabe der Rasse wird geprüft und falls keine zulässige Rasse gewählt
	 * wurde wird die Rasse "Menschen" gewählt.
	 * 
	 * @param rasse
	 *            die zu überprüfende Rasse
	 * @return Rassenname der weiterhin verwendet wird
	 */
	private Rasse pruefeKlasse(String rasse) {
		switch (rasse.toUpperCase()) {
		case "ORKS":
			return Rasse.ORKS;
		case "UNTOTE":
			return Rasse.UNTOTE;
		case "NACHTELFEN":
			return Rasse.NACHTELFEN;
		case "MENSCHEN":
		default:
			return Rasse.MENSCHEN;
		}
	}

	/**
	 * Die gewählte Investition wird vom Konto abgezogen und falls mehr Geld
	 * gewählt wurde als zulässig ist wird die Investition angepasst, da im
	 * Krieg keine Kredite gewährt werden! Seiteneffekt erwünscht, da Konto Geld
	 * verliert!
	 * 
	 * @param invest
	 *            die zu überprüfende Investition
	 * @return Investition die weiterhin verwendet wird
	 */
	private int pruefeInvestition(int invest) {
		int rest = this.konto - invest;
		if (rest < 0) {
			rest = this.konto;
			this.konto = 0;
			return rest;
		} else {
			this.konto = rest;
			return invest;
		}
	}

	/**
	 * Ausgabe der verwendeten Rasse(n), Investition(en) und der Squadname des
	 * Spielers, hilfreich um Eingabe mit tatsächlich verwendeten Werten zu
	 * vergleichen.
	 */
	public String toString() {
		String info = "Der Spieler wählt in das Team '" + this.squadname + "' "
				+ this.gewaehlteKlassen[0] + " mit "
				+ this.gewaehlteInvestitionen[0] + " Elfendoller";
		if (this.gewaehlteKlassen.length == 2) {
			info += " und " + this.gewaehlteKlassen[1] + " mit "
					+ this.gewaehlteInvestitionen[1] + " Elfendoller";
		}
		return info;
	}

	/**
	 * Ausgabe des Squadnamens
	 * 
	 * @return gewählter Name für das Squads
	 */
	public String getSquadName() {
		return this.squadname;
	}

	/**
	 * Ausgabe der Investitionen in einem Int[] Array
	 * 
	 * @return gewählte Investitionen
	 */
	public int[] gewaehlteInvestitionen() {
		return this.gewaehlteInvestitionen;
	}

	/**
	 * Ausgabe der Rassen in einem Rassen[] Array
	 * 
	 * @return gewählte Rassen
	 */
	public Rasse[] getGewaehlteKlassen() {
		return this.gewaehlteKlassen;
	}
}
