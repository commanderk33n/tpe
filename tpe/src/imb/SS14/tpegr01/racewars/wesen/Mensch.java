package imb.SS14.tpegr01.racewars.wesen;

public class Mensch extends Wesen {

	public Mensch() {
		this(false, 1.0);
	}

	protected Mensch(boolean istHeld, double bonusfaktor) {
		super("Mensch", istHeld, 140.0, 0.4, 40.0, 2.0, 10.0, bonusfaktor);
	}

	protected double beschraenkeSchaden(double damage) {
		return (damage * this.getSpezialattribut() / 100);
	}

}
