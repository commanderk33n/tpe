package imb.SS14.tpegr01.racewars.wesen;

public class Mensch extends Wesen {

	public Mensch() {
		this(false, 110, 140.0);
	}

	public Mensch(boolean istHeld, int kosten, double lebenspunkte) {
		super("Mensch", istHeld, kosten, lebenspunkte, 0.4, 40.0, 2.0, 10.0);
	}

}
