package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;

public abstract class Wesen implements Kaempfer {

	private final String RASSE;
	private final boolean istHeld;
	private final double RUESTUNG;
	private final double SCHADEN;
	private final double GESCHWINDIGKEIT;
	private final double SPEZIALATTRIBUT;
	private final double BONUS;
	private int lebenspunkte;

	protected Wesen(String rasse, boolean istHeld, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut, double bonus) {
		this.RASSE = rasse;
		this.istHeld = istHeld;
		this.GESCHWINDIGKEIT = geschwindigkeit;
		this.RUESTUNG = ruestung;
		this.SCHADEN = schaden;
		this.SPEZIALATTRIBUT = spezialattribut;
		this.lebenspunkte = (int) (lebenspunkte * bonus);
		this.BONUS = bonus;
	}

	public boolean isLebendig() {
		return (this.lebenspunkte <= 0) ? false : true;
	}

	protected double berechneSchaden() {
		double damage = (GESCHWINDIGKEIT * SCHADEN * SPEZIALATTRIBUT * BONUS);
		damage = this.beschraenkeSchaden(damage);
		return damage;
	}

	public double attacke(Kaempfer r) {
		if (r instanceof Wesen) {
			Wesen ziel = (Wesen) r;
			double schaden = berechneSchaden();
			if (ziel.istHeld) {
				schaden *= elementBonus((Helden) ziel);
			}
			schaden -= schaden * ziel.getRuestung();
			schaden=Math.round(schaden);
			ziel.bekommtSchaden(schaden);
			return schaden;
		} else {
			return 0;
		}
	}

	protected double beschraenkeSchaden(double damage) {
		return damage;
	}

	protected double elementBonus(Helden ziel) {
		return 1;
	}

	public void bekommtSchaden(double schaden) {
		this.setLebenspunkte((int) (this.lebenspunkte - schaden));
	}

	protected void setLebenspunkte(int wert) {
		this.lebenspunkte = wert;
	}

	public String toString() {
		String details = "Wesen ist von der Rasse: " + getRasse() + " hat "
				+ getLebenspunkte() + " Lebenspunkte, " + getRuestung()
				+ " Rüstung und verursacht " + getSchaden() + " Schaden.";
		return details;
	}

	protected void ausslöschen() {
		this.lebenspunkte = 0;
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

	public String getName() {
		return this.getRasse();
	}
}
