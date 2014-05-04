package imb.SS14.tpegr01.racewars;

/**
 * Racewars ist ein Spiel, in dem zwei Kontrahenten maximal 2 aus 4 Rassen
 * wählen können, um Elfendollar (auch ungleiche Gewichtung) in die gewählten
 * Rassen zu investieren, dadurch entsteht ein Squad pro Spieler.
 * Die Armee aus maximal zwei Rassen kämpfen im Folgenden gegeneinander.
 * Der Spieler gewinnt, der den gegnerischen Squad vernichtend schlägt.
 * 
 * Die Klasse <code>GameController</code> erstellt zwei Spieler und startet
 * das Spiel mit diesen.
 * 
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * @version 2 28/04/2014
 *
 */

public class GameController {

	private int runde;
	private Squad spieler1;
	private Squad spieler2;
	private boolean istSpieler1AnDerReihe;
	
	/**
	 * Der Konstruktor <code>GameController</code> erstellt den zwei Spielern
	 * zwei Squads.
	 * 
	 * @param spieler1  Erster Spieler
	 * @param spieler2  Zweiter Spieler
	 */

	public GameController(Spieler spieler1, Spieler spieler2) {
		this.runde = 0;
		this.spieler1 = new Squad(spieler1);
		this.spieler2 = new Squad(spieler2);
		istSpieler1AnDerReihe = true;
	}

	/**
	 * Startet das Spiel. Die zwei Spieler attackieren sich in Runden.
	 * Das Abbild der Kampfhandlung wird in der Klasse <code>GameViewer</code>
	 * dargestellt.
	 */
	
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
			//GameViewer.printDetails(this);
			GameViewer.printGame(this);
		}
		GameViewer.printResult(this);
	}

	/**Gibt die aktuelle Spielrunde zurück
	 * 
	 * @return  Gibt die aktuelle Spielrunde zurück.
	 */
	public int getRunde() {
		return this.runde;
	}
	
	/**
	 * Erstellt die Spieler mit ihrem Squadnamen, den gewünschten Rassen und
	 * deren Investition. Und erstellt daraufhin ein Spiel mit zweier Spieler.
	 */

	public static void main(String[] args) {
		Spieler spieler1 = new Spieler("The walking Dead", "untote", 2000);
		Spieler spieler2 = new Spieler("Letzter Bund gegen Sauron",
				"Nachtelfen", 1000, "menschen", 1200);
		Spieler spieler3 = new Spieler("Orks von Amon Sûl", "orks", 3000);
		Spieler spieler4 = new Spieler("Hipster-Horde", "menschen", 1500,"menschen",500);
		GameController gameONE = new GameController(spieler4, spieler1);
		GameController gameTWO = new GameController(spieler3, spieler2);
		gameONE.runGame();
		gameTWO.runGame();

	}
	
	/**Gibt die Squads der zwei Spieler zurück.
	 * 
	 * @return  Gibt die Squads der zwei Spieler zurück.
	 */

	public Squad[] getSquads() {
		return new Squad[] { this.spieler1, this.spieler2 };
	}

}
