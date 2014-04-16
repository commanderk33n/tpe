package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.interfaces.Helden.Held;

public class Farseer extends Ork implements Helden {

	public Held name;

	public Farseer() {
		super(true, Held.FARSEER.getBonusfaktor());
		this.name = Held.FARSEER;
	}

	// public void doppelschlag(Sqaud s)
	public double attacke(Kaempfer r) {
		if (r instanceof Wesen) {
			Wesen ziel = (Wesen) r;
			double verursachterSchaden = berechneSchaden()
					* name.getBonusfaktor();
			if (ziel.istHeld()) {
				verursachterSchaden = verursachterSchaden
						* kampfGegenHeld((Helden) ziel);
			}
			verursachterSchaden -= verursachterSchaden * ziel.getRuestung();
			return verursachterSchaden;
		} else {
			return 0;
		}
	}

	public double kampfGegenHeld(Helden gegner) {
		String feindlichesElement = gegner.getElement();
		if (feindlichesElement == "Wasser") {
			return 2;
		} else {
			return 1;
		}
	}

	public String getElement() {
		return name.getElement();
	}
}
