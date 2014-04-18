package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;

public class Spieler {
	private int konto;
	private Rasse[] gewählteKlassen;
	private int[] gewählteInvestitionen;
	private String squadname;

	public Spieler(String name, String rasse1, int investRasse1) {
		this(name, rasse1, investRasse1, null, 0);
	}

	public Spieler(String name, String rasse1, int investRasse1, String rasse2,
			int investRasse2) {
		this.squadname = name;
		setKonto();
		if (rasse2 != null) {
			this.gewählteKlassen = new Rasse[] { pruefeKlasse(rasse1),
					pruefeKlasse(rasse2) };
			this.gewählteInvestitionen = new int[] {
					pruefeInvestition(investRasse1),
					pruefeInvestition(investRasse2) };
		} else {
			this.gewählteKlassen = new Rasse[] { pruefeKlasse(rasse1) };
			this.gewählteInvestitionen = new int[] { pruefeInvestition(investRasse1) };
		}
	}

	private void setKonto() {
		this.konto = 2000;
	}

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

	// Seiteneffekt erwünscht, da Konto Geld verliert!
	private int pruefeInvestition(int invest) {
		int rest = this.konto - invest;
		if (invest < 0) {
			rest = this.konto;
			this.konto = 0;
			return rest;
		} else {
			this.konto = rest;
			return invest;
		}
	}

	public String toString(int spieler) {
		String info = "Der Spieler wählt in das Team '" + this.squadname + "' "
				+ this.gewählteKlassen[0] + " mit "
				+ this.gewählteInvestitionen[0] + " Elfendoller";
		if (this.gewählteKlassen.length == 2) {
			info += " und " + this.gewählteKlassen[1] + " mit "
					+ this.gewählteInvestitionen[1] + " Elfendoller";
		}
		return info;
	}

	public String getSquadName() {
		return this.squadname;
	}

	public int[] gewählteInvestitionen() {
		return this.gewählteInvestitionen;
	}

	public Rasse[] getGewählteKlassen() {
		return this.gewählteKlassen;
	}
}
