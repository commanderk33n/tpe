package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;

public class Daemonenjaeger extends Nachtelf implements Helden {

	public Held name;

	public Daemonenjaeger() {
		super(true, Held.DAEMONENJAEGER.getBonusfaktor());
		this.name = Held.DAEMONENJAEGER;
	}
	
	//public void goldschuss(Squad s)
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
		String feindlichesElement=gegner.getElement();
		if (feindlichesElement == "Erde"){
			return 2;
		}else{
			return 1;
		}
	}
	
	public String getElement() {
		return name.getElement();
	}
}
