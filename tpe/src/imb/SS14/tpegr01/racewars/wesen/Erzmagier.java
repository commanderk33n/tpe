package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.interfaces.Helden.Held;

public class Erzmagier extends Mensch implements Helden {

	public Held name;

	public Erzmagier() {
		super(true, Held.ERZMAGIER.getBonusfaktor());
		this.name = Held.ERZMAGIER;
	}

	// public void absorption()

	protected double berechneSchaden() {
		double verursachterSchaden= (this.getGeschwindigkeit() * this.getSchaden() * this
				.getSpezialattribut())*name.getBonusfaktor();
		verursachterSchaden= beschraenkeSchaden(verursachterSchaden);
		return verursachterSchaden;
	}

	public double kampfGegenHeld(Held gegner) {
		if (gegner.getElement() == "Luft") {
			return 2;
		} else {
			return 1;
		}
	}


}
