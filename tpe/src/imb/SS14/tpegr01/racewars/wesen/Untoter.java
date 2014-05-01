package imb.SS14.tpegr01.racewars.wesen;

public class Untoter extends Wesen {

	public Untoter() {
		this(false, 1.0);
	}

	protected Untoter(boolean istHeld, double bonusfaktor) {
		super("Untoter", istHeld, 120.0, 0.3, 16.0, 2.0, 1.6, bonusfaktor);
	}

}
