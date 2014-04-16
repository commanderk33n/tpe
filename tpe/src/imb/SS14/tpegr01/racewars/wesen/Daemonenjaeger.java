package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.interfaces.Helden.Held;

public class Daemonenjaeger extends Nachtelf implements Helden {

	public Held name;

	public Daemonenjaeger() {
		super(true, Held.DAEMONENJAEGER.getBonusfaktor());
		this.name = Held.DAEMONENJAEGER;
	}
	
	//public void goldschuss(Squad s)

	public double kampfGegenHeld(Held gegner) {
		if (gegner.getElement()=="Erde"){
			return 2;
		}else{
			return 1;
		}
	}
}
