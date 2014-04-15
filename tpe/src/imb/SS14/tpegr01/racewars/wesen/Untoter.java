package imb.SS14.tpegr01.racewars.wesen;

public class Untoter extends Wesen {

	public Untoter() {
		this("Untoter", false, 70, 120.0, 0.3, 16.0, 2.0, 1.6);
	}

	public Untoter(String rasse, boolean istHeld, int kosten, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut) {
		super(rasse, istHeld, kosten, lebenspunkte, ruestung, schaden,
				geschwindigkeit, spezialattribut);
	}

}
