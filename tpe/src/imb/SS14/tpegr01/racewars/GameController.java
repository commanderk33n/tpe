package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;

public class GameController {

	private int runde;
	private Squad spieler1;
	private Squad spieler2;
	private boolean istSpieler1AnDerReihe;

	public GameController(Spieler spieler1, Spieler spieler2) {
		this.runde = 0;
		this.spieler1 = new Squad(spieler1);
		this.spieler2 = new Squad(spieler2);
		istSpieler1AnDerReihe = true;
	}

	public void runGame() {
		// Spiel beginnt und endet erst wenn ein Squad tot ist
	}

	public int getRunde() {
		return this.runde;
	}

	public static void main(String[] args) {
		Spieler spieler1 = new Spieler("The walking Dead", "untote", 4224);
		Spieler spieler2 = new Spieler("Letzter Bund gegen Sauron",
				"Nachtelfen", 1334, "menschen", 666);
		GameController gameONE = new GameController(spieler1, spieler2);
		// GameViewer.printGame(gameONE);
		GameViewer.printDetails(gameONE);

	}

	public String getSpieler(int spieler) {
		Squad ausgabe = spieler1;
		if (spieler == 2) {
			ausgabe = spieler2;
		}
		String info = "'" + ausgabe.getName() + "' besitzt "
				+ ausgabe.getLebendige() + " lebendige Wesen.";
		return info;

	}

	public String getDetailsSpieler(int spieler) {
		Squad ausgabe = spieler1;
		if (spieler == 2) {
			ausgabe = spieler2;
		}
		String info = ausgabe.toString();
		return info;
	}

}
