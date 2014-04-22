package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.GameController;

public class GameViewer {

	public static void printGame(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		for (Squad ausgabeSquad : game.getSquads()) {
			System.out.println("'" + ausgabeSquad.getName() + "' besitzt "
					+ ausgabeSquad.getLebendige() + " Wesen.");
		}
		System.out.printf("\n");
	}

	public static void printDetails(GameController game) {
		System.out.println("Spielzustand nach Runde " + game.getRunde());
		for (Squad ausgabeSquad : game.getSquads()) {
			System.out.println("'" + ausgabeSquad.getName() + "' besitzt "
					+ ausgabeSquad.getLebendige() + " Wesen.");
			System.out.printf("%-20s%s\n", "Rasse", "Lebenspunkte");
			for (int i = 0; i < ausgabeSquad.getLebendige(); i++) {
				System.out.printf("%-20s%s\n", ausgabeSquad.getWesen(i)
						.getName(), ausgabeSquad.getWesen(i).getLebenspunkte());
			}
			System.out.printf("\n");
		}
	}

	public static void printResult(GameController game) {
		System.out.println("Spielende nach Runde " + game.getRunde());
		Squad[] ergebnis = game.getSquads();
		if (ergebnis[0].getLebendige() > 0) {
			siegerehrung(ergebnis[0], ergebnis[1]);
		} else {
			siegerehrung(ergebnis[1], ergebnis[0]);
		}

	}

	private static void siegerehrung(Squad gewinner, Squad verlierer) {
		System.out.println("'" + gewinner.getName() + "' besiegt '"
				+ verlierer.getName() + "'!\n");
	}
}
