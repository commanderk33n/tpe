package imb.SS14.tpegr01.racewars;

public class GameController {

	private int runde;
	private int kontoSpieler1;
	private int kontoSpieler2;
	private Squad squadSpieler1;
	private Squad squadSpieler2;
	private boolean istSpieler1AnDerReihe;

	public GameController() {
		this.runde = 0;
		this.kontoSpieler1 = 2000;
		this.kontoSpieler2 = 2000;
		this.istSpieler1AnDerReihe = true;
		this.squadSpieler1 = erstelleSquad("The walking dead", "untote", 2000);
		this.squadSpieler2 = erstelleSquad("Orks aus dem Nebelgebirge", "ork",
				2000);
	}

	public void runGame() {
		// Spiel beginnt und endet erst wenn ein Squad tot ist
	}

	private Squad erstelleSquad(String name, String rasse, int invest) {
		if (invest > 2000) {
			return new Squad(name, rasse, 2000);
		} else {
			return new Squad(name, rasse, invest);
		}
	}

	private Squad erstelleSquad(String name, String rasse1, int invest1,
			String rasse2, int invest2) {
		if ((invest1 + invest2) > 2000) {
			return new Squad(name, rasse1, 1000, rasse2, 1000);
		} else {
			return new Squad(name, rasse1, invest1, rasse2, invest2);
		}
	}

	public int getRunde() {
		return this.runde;
	}

	public String getsquad(int spieler) {
		Squad ausgabe = squadSpieler1;
		if (spieler == 2) {
			ausgabe = squadSpieler2;
		}
		String info ="'"+ ausgabe.getName() + "' besitzt " + ausgabe.getLebendige()
				+ " lebendige Wesen.";
		return info;
	}
	
	
	public static void main(String[] args) {
		GameController gameONE = new GameController();
		GameViewer.printGame(gameONE);

	}

}
