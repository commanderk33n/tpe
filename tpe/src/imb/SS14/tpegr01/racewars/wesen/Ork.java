package imb.SS14.tpegr01.racewars.wesen;

public class Ork extends Wesen {

	public Ork() {
		this(false, 1.0);
	}

	protected Ork(boolean istHeld, double bonusfaktor) {
		super("Ork", istHeld, 100.0, 0.3, 33.0, 1.0, 4.0, bonusfaktor);
	}

}
