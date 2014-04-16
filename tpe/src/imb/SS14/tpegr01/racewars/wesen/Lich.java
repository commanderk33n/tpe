package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.interfaces.Helden.Held;

public class Lich extends Untoter implements Helden {

	public Held name;

	public Lich() {
		super(true, Held.LICH.getBonusfaktor());
		this.name = Held.LICH;
	}
	
	//public void verwesung(Squad s)

	public double kampfGegenHeld(Held gegner) {
		if (gegner.getElement()=="Feuer"){
			return 2;
		}else{
			return 1;
		}
	}
}
