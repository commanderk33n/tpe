package imb.SS14.tpegr01.racewars.wesen;

public class Ork extends Wesen {

	public Ork() {
		this(false, 150, 100.0);
	}

	public Ork(boolean istHeld, int kosten, double lebenspunkte) {
		super("Ork", istHeld, kosten, lebenspunkte, 0.3, 33.0, 1.0, 4.0);
	}

}
