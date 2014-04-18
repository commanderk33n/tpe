package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.GameController;

public class GameViewer {

	public static void printGame(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		System.out.println(game.getSpieler(1));
		System.out.println(game.getSpieler(2));
	}
	
	public static void printDetails(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		System.out.println(game.getDetailsSpieler(1));
		System.out.printf("%s%17s\n", "Rasse", "Lebenspunkte");
		System.out.println(game.getDetailsSpieler(1));
		//ausgabe aller wesen des squads
		System.out.println(game.getDetailsSpieler(2));
		System.out.printf("%s%17s\n", "Rasse", "Lebenspunkte");
		System.out.println(game.getDetailsSpieler(2));
		//ausgabe aller wesen des squads
	}
}
