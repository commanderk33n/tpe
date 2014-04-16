package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;

public abstract class Wesen implements Kaempfer {

	private final String RASSE;
	private final boolean istHeld;
	private final double RUESTUNG;
	private final double SCHADEN;
	private final double GESCHWINDIGKEIT;
	private final double SPEZIALATTRIBUT;
	private double lebenspunkte;

	protected Wesen(String rasse, boolean istHeld, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut) {
		this.RASSE = rasse;
		this.istHeld = istHeld;
		this.GESCHWINDIGKEIT = geschwindigkeit;
		this.RUESTUNG = ruestung;
		this.SCHADEN = schaden;
		this.SPEZIALATTRIBUT = spezialattribut;
		this.lebenspunkte = lebenspunkte;
	}

	public boolean isLebendig() {
		return (this.lebenspunkte <= 0)? false : true; 
	}

	protected double berechneSchaden() {
		return (GESCHWINDIGKEIT * SCHADEN * SPEZIALATTRIBUT);
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
		String details = "Wesen ist von der Rasse: " + getRasse() + " und ist "
				+ istHeld() + "hat " + getLebenspunkte() + " Lebenspunkte, "
				+ getRuestung() + " Rüstung, verursacht " + getSchaden()
				+ " Schaden, " + getGeschwindigkeit() + getSpezialattribut();
		return details;
	}

	public String getRasse() {
		return this.RASSE;
	}

	public boolean istHeld() {
		return this.istHeld;
	}

	public double getLebenspunkte() {
		return this.lebenspunkte;
	}

	public double getRuestung() {
		return this.RUESTUNG;
	}

	public double getSchaden() {
		return this.SCHADEN;
	}

	public double getGeschwindigkeit() {
		return this.GESCHWINDIGKEIT;
	}

	public double getSpezialattribut() {
		return this.SPEZIALATTRIBUT;
	}

}
