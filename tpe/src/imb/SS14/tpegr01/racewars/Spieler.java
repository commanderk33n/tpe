package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;

public class Spieler {
	public static final int konto = 2000;
	public Squad squad;
	
	public Spieler(String name, Rasse rasse1, int investRasse1) {
		squad = new Squad(name, rasse1, investRasse1);
	}
	
	public Spieler(String name, Rasse rasse1, int investRasse1, Rasse rasse2, int investRasse2) {
		squad = new Squad(name, rasse1, investRasse1, rasse2, investRasse2);
	}
	
	public String toString(int spieler) {
		Squad ausgabe = squad;
		if (spieler == 2) {
			ausgabe = squad;
		}
		String info ="'"+ ausgabe.getName() + "' besitzt " + ausgabe.getLebendige()
				+ " lebendige Wesen.";
		return info;
	}
	
	public String getName() {
		return squad.getName();
	}

	public int getLebendige() {
		return squad.getLebendige();
	}
	
	public String getSquad() {
		return squad.toString();
	}
}
