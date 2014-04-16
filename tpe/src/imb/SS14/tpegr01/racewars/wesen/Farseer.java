package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.interfaces.*;
import imb.SS14.tpegr01.racewars.interfaces.Helden.Held;

public class Farseer extends Ork implements Helden {

	public Held name;

	public Farseer() {
		super(true, Held.FARSEER.getBonusfaktor());
		this.name = Held.FARSEER;
	}
	
	//public void doppelschlag(Sqaud s)

			public double kampfGegenHeld(Held gegner) {
				if (gegner.getElement()=="Wasser"){
					return 2;
				}else{
					return 1;
				}
			}

}
