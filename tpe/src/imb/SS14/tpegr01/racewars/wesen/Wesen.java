package imb.SS14.tpegr01.racewars.wesen;

public abstract class Wesen {

	private final String rasse;
	private final boolean istHeld;
	private final int kosten;
	private final double lebenspunkte;
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
		if (this.lebenspunkte > 0) {
			return true;
		} else {
			return false; // todo remove from squad aber nur im Squad- nicht
							// hier!
		}
	}

	public int getKosten() {
		return kosten;
	}

	public double getLebenspunkte() {
		return lebenspunkte;
	}

	public double getSchaden() {
		return schaden;
	}

	public double getGeschwindigkeit() {
		return geschwindigkeit;
	}

	public double getRuestung() {
		return ruestung;
	}

	public double getSpezialattribut() {
		return spezialattribut;
	}

	public String toString() {
		String details = rasse;
		return details;
	}

}
