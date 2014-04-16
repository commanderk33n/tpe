package imb.SS14.tpegr01.racewars.wesen;

public class Untoter extends Wesen {

	public Untoter() {
		this(false, 1.0);
	}

	public Untoter(boolean istHeld, double bonusfaktor) {
		super("Untoter", istHeld, 120.0 * bonusfaktor, 0.3, 33.0, 1.0, 4.0);
	}

}
