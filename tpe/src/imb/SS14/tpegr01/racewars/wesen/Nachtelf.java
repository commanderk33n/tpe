package imb.SS14.tpegr01.racewars.wesen;

public class Nachtelf extends Wesen {

	public Nachtelf() {
		this(false, 145, 120.0);
	}

	public Nachtelf(boolean istHeld, int kosten, double lebenspunkte) {
		super("Nachtelf", istHeld, kosten, lebenspunkte,  0.2, 15.0, 3.0, 2.9);
	}

}
