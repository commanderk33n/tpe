package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;

public class Spieler {
	public static final int konto = 2000;
	public Rasse rasse1;	 // vvv
	public int investRasse1; // Vllt brauchen wir
	public Rasse rasse2;	 // des hier gar nicht speichern
	public int investRasse2; // Aber durch printer vllt besser auszugeben
	public Squad squad;
	
	public Spieler(String name, Rasse rasse1, int investRasse1) {
		this.investRasse1 = investRasse1;
		this.investRasse2 = 0;
		this.rasse1 = rasse1;
		this.rasse2 = null;
		squad = new Squad(name, rasse1, investRasse1);
	}
	
	public Spieler(String name, Rasse rasse1, int investRasse1, Rasse rasse2, int investRasse2) {
		this.investRasse1 = investRasse1;
		this.investRasse2 = investRasse2;
		this.rasse1 = rasse1;
		this.rasse2 = rasse2;
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
