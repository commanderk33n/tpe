package imb.SS14.tpegr01.racewars;

public class GameViewer {

	public static void printGame(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		System.out.println(game.getsquad(1));
		System.out.println(game.getsquad(2));
	}
	
	public static void printDetails(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		System.out.println(game.getsquad(1));
		System.out.printf("%s%17s%\n", "Klasse", "Lebenspunkte");
		//ausgabe aller wesen des squads
		System.out.println(game.getsquad(2));
		System.out.printf("%s%17s%\n", "Klasse", "Lebenspunkte");
		//ausgabe aller wesen des squads
	}
}
