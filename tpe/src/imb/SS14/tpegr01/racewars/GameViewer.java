package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.GameController;
import imb.SS14.tpegr01.racewars.wesen.Wesen;

/**
 * Die <code>GameViewer</code> Klasse ist statisch und dient der
 * Veranschaulichung eines Objekts der Klasse <code>GameController</code> indem
 * sie verschiedene relevante Informationen auf der Konsole ausgibt.
 * <p>
 * 
 * 
 * 
 * @author Tim Hubert
 * @author Torsten MÃ¼ller
 * @author Philipp Siebert
 * @version 2 28/04/2014
 */

public class GameViewer {
	/**
	 * Gibt eine kurze Billanz Ã¼ber die Anzahl der Wesen in den Squads der
	 * Spieler.
	 * 
	 * @param game
	 *            das Objekt der Klasse <code>GameController</code> welches
	 *            dargestellt werden soll
	 */
	public static void printGame(GameController game) {
		printRunde(game.getRunde());
		for (Squad ausgabeSquad : game.getSquads()) {
			printSquadshort(ausgabeSquad);
		}
		System.out.printf("\n");
	}

	/**
	 * Gibt eine kurze Billanz Ã¼ber die Anzahl der Wesen in den Squads der
	 * Spieler und anschlieÃŸend zu jedem Wesen die Anzahl der Lebenspunkte.
	 * 
	 * @param game
	 *            das Objekt der Klasse <code>GameController</code> welches
	 *            dargestellt werden soll
	 */
	public static void printDetails(GameController game) {
		printRunde(game.getRunde());
		for (Squad ausgabeSquad : game.getSquads()) {
			printSquadshort(ausgabeSquad);
			System.out.printf("%-20s%s\n", "Rasse", "Lebenspunkte");
			for (int i = 0; i < ausgabeSquad.getLebendige(); i++) {
				System.out.printf("%-20s%s\n", ausgabeSquad.getWesen(i)
						.getName(), ausgabeSquad.getWesen(i).getLebenspunkte());
			}
			System.out.printf("\n");
		}
	}

	/**
	 * Stellt fest welcher Spieler gewonnen hat, anhand der Anzahl der Wesen in
	 * den Squads der Spieler.
	 * 
	 * @param game
	 *            das Objekt der Klasse <code>GameController</code> welches
	 *            dargestellt werden soll
	 */
	public static void printResult(GameController game) {
		System.out.println("Spielende nach Runde " + game.getRunde());
		Squad[] ergebnis = game.getSquads();
		if (ergebnis[0].getLebendige() > 0) {
			siegerehrung(ergebnis[0], ergebnis[1]);
		} else {
			siegerehrung(ergebnis[1], ergebnis[0]);
		}

	}

	/**
	 * Ausgabe der Squadnamen des Gewinners und des Verlierers
	 * 
	 * @param gewinner
	 *            Squad, welches das Spiel gewonnen hat
	 * @param verlierer
	 *            Squad, welches das Spiel verloren hat
	 */
	private static void siegerehrung(Squad gewinner, Squad verlierer) {
		System.out.println("'" + gewinner.getName() + "' besiegt '"
				+ verlierer.getName() + "'!\n");
	}

	/**
	 * Ausgabe der aktuellen Runde
	 * 
	 * @param runde
	 *            aktuelle Runde
	 */
	private static void printRunde(int runde) {
		System.out.println("\n Spielzustand nach Runde " + runde);
	}

	/**
	 * Ausgabe des Namens und der lebenden Wesen eines Squads
	 * 
	 * @param ausgabeSquad
	 *            Squad dessen Informationen ausgegeben werden sollen
	 */
	private static void printSquadshort(Squad ausgabeSquad) {
		System.out.println("'" + ausgabeSquad.getName() + "' besitzt "
				+ ausgabeSquad.getLebendige() + " Wesen.");
	}

	public static void printAngriff(Wesen angreifer, Wesen opfer, double schaden) {
		System.out.println(angreifer.getName() + " fÃ¼gt " + opfer.getName()
				+ " " + Math.round(schaden) + " Schaden zu.");
	}
}
