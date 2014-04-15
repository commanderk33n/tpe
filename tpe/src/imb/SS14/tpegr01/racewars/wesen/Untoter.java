package imb.SS14.tpegr01.racewars.wesen;

public class Untoter extends Wesen {

	public Untoter() {
		this(false, 70, 120.0);
	}

	public Untoter(boolean istHeld, int kosten, double lebenspunkte) {
		super("Untoter", istHeld, kosten, lebenspunkte, 0.3, 33.0, 1.0, 4.0);
	}

}
