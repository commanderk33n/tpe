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

	public double attacke(Kaempfer r) {
		if (r instanceof Wesen) {
			Wesen ziel = (Wesen) r;
			double verursachterSchaden = berechneSchaden()*name.getBonusfaktor();
			if (ziel.istHeld()){
				verursachterSchaden=verursachterSchaden*kampfGegenHeld((Helden) ziel);
			}

			verursachterSchaden -= verursachterSchaden * ziel.getRuestung();
			return verursachterSchaden;
		} else {
			return 0;
		}
	}
	

	public double kampfGegenHeld(Helden gegner) {
		String feindlichesElement=gegner.getElement();
		if (feindlichesElement == "Luft") {
			return 2;
		} else {
			return 1;
		}
	}
	
	public String getElement() {
		return name.getElement();
	}

}
