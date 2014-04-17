package imb.SS14.tpegr01.racewars.wesen;

public class Mensch extends Wesen {

	public Mensch() {
		this(false, 1.0);
	}

	protected Mensch(boolean istHeld, double bonusfaktor) {
		super("Mensch", istHeld, 140.0*bonusfaktor, 0.4, 40.0, 2.0, 10.0);
	}


	protected double berechneSchaden() {
		double verursachterSchaden= (this.getGeschwindigkeit() * this.getSchaden() * this
				.getSpezialattribut());
		verursachterSchaden= beschraenkeSchaden(verursachterSchaden);
		return verursachterSchaden;
	}

	protected double beschraenkeSchaden(double damage) {
		return (damage - damage * this.getSpezialattribut());
	}

}
