package imb.SS14.tpegr01.racewars.wesen;

public class Mensch extends Wesen {

	public Mensch() {
		this("Mensch", false, 110, 140.0, 0.4, 40.0, 2.0, 10.0);
	}

	public Mensch(String rasse, boolean istHeld, int kosten,
			double lebenspunkte, double ruestung, double schaden,
			double geschwindigkeit, double spezialattribut) {
		super(rasse, istHeld, kosten, lebenspunkte, ruestung, schaden,
				geschwindigkeit, spezialattribut);
	}

}
