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
		GameViewer.printGame(this);
		while (spieler1.lebendigeWesen > 0 && spieler2.lebendigeWesen > 0) {
			if (istSpieler1AnDerReihe) {
				spieler2.wirdAngegriffen(spieler1);
			} else {
				spieler1.wirdAngegriffen(spieler2);
			}
			runde++;
			this.istSpieler1AnDerReihe = !this.istSpieler1AnDerReihe;
			// GameViewer.printDetails(this);
			GameViewer.printGame(this);
		}
		GameViewer.printResult(this);
	}

	public int getRunde() {
		return this.runde;
	}

	public static void main(String[] args) {
		Spieler spieler1 = new Spieler("The walking Dead", "untote", 4224);
		Spieler spieler2 = new Spieler("Letzter Bund gegen Sauron",
				"Nachtelfen", 1334, "menschen", 666);
		Spieler spieler3 = new Spieler("Orks von Amon Sûl", "orks", 2000);
		Spieler spieler4 = new Spieler("Hipster-BOYZ", "menschen", 2000);
		GameController gameONE = new GameController(spieler4, spieler1);
		GameController gameTWO = new GameController(spieler3, spieler2);
		gameONE.runGame();
		gameTWO.runGame();

	}

	public Squad[] getSquads() {
		return new Squad[] { this.spieler1, this.spieler2 };
	}

}
