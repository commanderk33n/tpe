package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;
import imb.SS14.tpegr01.racewars.Squad;

public class GameController {

	private static int runde = 0;
	private Spieler spieler1;
	private Spieler spieler2;
	private boolean istSpieler1AnDerReihe;

	public GameController() {
		
		// ggf. Ermittlung von String in Rasse hier mit Methode ("Untote" -> Rasse.UNTOTER)
		this.spieler1 = new Spieler("The walking Dead", Rasse.UNTOTER, 2000);
		this.spieler2 = new Spieler("Homo-Truppe", Rasse.NACHTELF, 1700, Rasse.MENSCH, 300);
	}

	public void runGame() {
		// Spiel beginnt und endet erst wenn ein Squad tot ist
	}

	public int getRunde() {
		return this.runde;
	}
	
	
	public static void main(String[] args) {
		GameController gameONE = new GameController();
		//GameViewer.printGame(gameONE);
		GameViewer.printDetails(gameONE);

	}
	
	public String getSpieler(int spieler) {
		Spieler ausgabe = spieler1;
		if (spieler == 2) {
			ausgabe = spieler2;
		}
		String info ="'"+ ausgabe.getName() + "' besitzt " + ausgabe.getLebendige()
				+ " lebendige Wesen.";
		return info;
	}
	
	public String getDetailsSpieler(int spieler) {
		Spieler ausgabe = spieler1;
		if (spieler == 2) {
			ausgabe = spieler2;
		}
		String info = ausgabe.getSquad();
		return info;
	}

}
