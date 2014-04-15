package imb.SS14.tpegr01.racewars.wesen;

public class Ork extends Wesen {

	public Ork() {
		this("Ork", false, 150, 100.0, 0.3, 33.0, 1.0, 4.0);
	}

	public Ork(String rasse, boolean istHeld, int kosten, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut) {
		super(rasse, istHeld, kosten, lebenspunkte, ruestung, schaden,
				geschwindigkeit, spezialattribut);
	}

}
