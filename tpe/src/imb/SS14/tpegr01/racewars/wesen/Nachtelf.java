package imb.SS14.tpegr01.racewars.wesen;

public class Nachtelf extends Wesen {

	public Nachtelf() {
		this(false, 1.0);
	}

	protected Nachtelf(boolean istHeld, double bonusfaktor) {
		super("Nachtelf", istHeld, 120.0 * bonusfaktor, 0.2, 15.0, 3.0, 2.9);
	}

}
