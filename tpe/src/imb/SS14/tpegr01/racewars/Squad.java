package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;
import imb.SS14.tpegr01.racewars.wesen.Wesen;
import imb.SS14.tpegr01.racewars.Spieler;

public class Squad {

	private String name;
	private Wesen[] armee;
	int lebendigeWesen;
	
	public Squad(String name, Rasse rasse, int invest) {
		this.name = name;
		this.armee = rekrutiereArmee(rasse, invest);
		this.lebendigeWesen = this.armee.length;
	}

	public Squad(String name, Rasse rasse1, int investRasse1, Rasse rasse2,
			int investRasse2) {
		this.name = name;
		Wesen[] truppe1 = rekrutiereArmee(rasse1, investRasse1);
		Wesen[] truppe2 = rekrutiereArmee(rasse2, investRasse2);
		this.armee = new Wesen[truppe1.length + truppe2.length];
		for (int i = 0; i < armee.length; i++) {
			if (i < truppe1.length) {
				this.armee[i] = truppe1[i];
			} else {
				this.armee[i] = truppe2[i - truppe1.length];
			}
		}
		this.lebendigeWesen = this.armee.length;
	}

	private Wesen[] rekrutiereArmee(Rasse rasse, int invest) {
		Wesen[] armee = WesenFactory.erschaffe(rasse, invest);
		return armee;
	}

	public void entferneWesenAusSquad(int index) {
		if (!armee[index].isLebendig()) {
			Wesen gestorbenesWesen = armee[index];
			armee[index] = armee[lebendigeWesen];
			armee[lebendigeWesen] = gestorbenesWesen;
			lebendigeWesen--;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getLebendige() {
		return this.lebendigeWesen;
	}
	
	public String toString() {
		String info = "";
		for(int i = 0; i < armee.length; i++) {
			info += armee[i].getRasse() + "   "
					+ armee[i].getLebenspunkte() + "\r";
		}
		
		return info;
	}

}
