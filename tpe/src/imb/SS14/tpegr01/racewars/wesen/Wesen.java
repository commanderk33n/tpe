package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.Kaempfer;

public abstract class Wesen implements Kaempfer {

	private final String rasse;
	private final boolean istHeld;
	private final int kosten;
	private double lebenspunkte;
	private final double ruestung;
	private final double schaden;
	private final double geschwindigkeit;
	private final double spezialattribut;

	protected Wesen(String rasse, boolean istHeld, int kosten,
			double lebenspunkte, double ruestung, double schaden,
			double geschwindigkeit, double spezialattribut) {
		this.rasse = rasse;
		this.istHeld = istHeld;
		this.kosten = kosten;
		this.lebenspunkte = lebenspunkte;
		this.geschwindigkeit = geschwindigkeit;
		this.ruestung = ruestung;
		this.schaden = schaden;
		this.spezialattribut = spezialattribut;
	}

	public boolean isLebendig() {
		return (this.lebenspunkte <= 0)? false : true; 
	}

	protected double berechneSchaden() {
		return (geschwindigkeit * schaden * spezialattribut);
	}

	public double attacke(Kaempfer r) {
		if (r instanceof Wesen) {
			Wesen ziel = (Wesen) r;
			double verursachterSchaden = berechneSchaden();
			// Schaden von Menschen reduzieren!
			// Anführer Schaden erhöhen (bonusfaktor)
			// Anführer Schaden an element anpassen
			verursachterSchaden -= verursachterSchaden * ziel.getRuestung();
			return verursachterSchaden;
		} else {
			return 0;
		}
	}

	public String toString() {
		String details = getRasse() + istHeld() + getKosten()
				+ getLebenspunkte() + getRuestung() + getSchaden()
				+ getGeschwindigkeit() + getSpezialattribut();
		return details;
	}

	public String getRasse() {
		return this.rasse;
	}

	public boolean istHeld() {
		return this.istHeld;
	}

	public int getKosten() {
		return this.kosten;
	}

	public double getLebenspunkte() {
		return this.lebenspunkte;
	}

	public double getRuestung() {
		return this.ruestung;
	}

	public double getSchaden() {
		return this.schaden;
	}

	public double getGeschwindigkeit() {
		return this.geschwindigkeit;
	}

	public double getSpezialattribut() {
		return this.spezialattribut;
	}

}
