package imb.SS14.tpegr01.racewars.wesen;

public class Nachtelf extends Wesen {

	public Nachtelf() {
		this("Nachtelf", false, 145, 120.0, 0.2, 15.0, 3.0, 2.9);
	}

	public Nachtelf(String rasse, boolean istHeld, int kosten, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut) {
		super(rasse, istHeld, kosten, lebenspunkte, ruestung, schaden,
				geschwindigkeit, spezialattribut);
	}

}
