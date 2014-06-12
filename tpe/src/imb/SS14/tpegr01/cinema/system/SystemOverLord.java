package imb.SS14.tpegr01.cinema.system;

import imb.SS14.tpegr01.cinema.Cinema;
import imb.SS14.tpegr01.cinema.Hall;
import imb.SS14.tpegr01.cinema.film.Film;
import imb.SS14.tpegr01.cinema.program.ProgramPart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemOverLord {
	private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	private static Scanner scan = new Scanner(System.in);

	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(ArrayList<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	public void addCinema(Cinema... cinemas) {
		for (Cinema cinema : cinemas) {
			this.cinemas.add(cinema);
		}
	}

	public void createAndAddCinema(String name, String city, Hall... halls) {
		Cinema newCinema = new Cinema(name, city, halls);
		this.cinemas.add(newCinema);
	}

	/**
	 * Auslesen aller Filme mit Ihren Anfangszeiten als Array sortiert nach der
	 * Anfangszeit. Filme können doppelt vorkommen, wenn sie unterschiedliche
	 * Anfangszeiten haben. (getAlleFilmeMitZeiten)
	 * 
	 * @param c
	 *            Kino dessen Filme ausgelesen werden sollen
	 * @return Filme mit Ihren Anfangszeiten
	 */
	public ProgramPart[] getAllMoviesWithTimes(Cinema c) {
		// TODO
		return null;
	}

	/**
	 * Auslesen aller Filme in einem bestimmten Saal mit den entsprechenden
	 * Anfangszeiten als Array. Die Filme sind nach der Startzeit sortiert.
	 * (getFilmeFuerSaalMitZeiten)
	 */
	public ProgramPart[] getMoviesForHallWithTimes(Cinema c, Hall h) {
		// TODO
		return null;
	}

	/**
	 * Auslesen aller Filme, die im Kino laufen als Array. Hierbei soll jeder
	 * Film nur einmal enthalten sein, auch wenn er zu mehreren Zeiten und in
	 * unterschiedliche Sälen läuft. Die Methode ist uberladen und erlaubt in
	 * einer Variante die Angabe eines Sortierkriteriums als Enumeration. Wird
	 * kein Kriterium angegeben, werden die Filme nach dem Namen sortiert.
	 * (getAlleFilme)
	 * 
	 * @param c
	 *            Kino dessen Filme ausgelesen werden sollen
	 * @return alle Filme eines Kinos
	 */
	public Film[] getAllmovies(Cinema c) {
		// TODO
		return null;
	}

	/**
	 * Auslesen aller Filme, die im Kino laufen als Array. Hierbei soll jeder
	 * Film nur einmal enthalten sein, auch wenn er zu mehreren Zeiten und in
	 * unterschiedliche Sälen läuft. Die Methode ist uberladen und erlaubt in
	 * einer Variante die Angabe eines Sortierkriteriums als Enumeration. Wird
	 * kein Kriterium angegeben, werden die Filme nach dem Namen sortiert.
	 * (getAlleFilme)
	 * 
	 * @param c
	 *            Kino dessen Filme ausgelesen werden sollen
	 * @param s
	 *            Angabe des anzuwendenen Sortierkriteriums
	 * @return alle Filme eines Kinos
	 */
	public Film[] getAllmovies(Cinema c, SortingCriterion s) {
		// TODO
		return null;
	}

	public Cinema createCinema() {
		System.out.println("Erstelle neues Kino");
		System.out.println("Name des Kinos: ");
		String name = scan.nextLine();
		System.out.println("Stadt in der sich das Kino befindet: ");
		String city = scan.nextLine();
		Hall[] halls = createHalls();
		return new Cinema(name, city, halls);
	}

	/**
	 * @return
	 */
	private Hall[] createHalls() {
		ArrayList<Hall> halls = new ArrayList<Hall>();
		Hall nextHall;
		boolean weiter = true;
		while (weiter) {
			try {
				nextHall = createHall();
				halls.add(nextHall);
				System.out.println(nextHall + " wurde hinzugefügt.");
				System.out.println("Weiteren Saal erstellen? (Ja)");
				String ja = scan.next().toUpperCase();
				weiter = false;
				if (ja.equals("JA")) {
					weiter = true;
				}
				;
			} catch (MyInputMismatchException e) {
				System.out
						.println("Fehler! Saal konnte nicht erstellt werden!");
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out
						.println("Fehler! Saal konnte nicht erstellt werden!");
			}
		}
		Hall[] hallsAsArray = new Hall[halls.size()];
		for (int i = 0; i < halls.size(); i++) {
			hallsAsArray[i] = halls.get(i);
		}
		return hallsAsArray;
	}

	private Hall createHall() throws MyInputMismatchException,
			InputMismatchException {
		System.out.println("Erstelle neuen Saal");
		System.out.println("Name des Saals: ");
		String name = scan.next();
		name += scan.nextLine();
		System.out.println("Anzahl der Sitze: ");
		int seats = scan.nextInt();
		if (seats < 1) {
			throw new MyInputMismatchException(
					"Es muss mindestens ein Platz im Saal vorhanden sein!");
		}
		return (new Hall(name, seats));
	}

	private class MyInputMismatchException extends Exception {

		private static final long serialVersionUID = 1L;

		public MyInputMismatchException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
		SystemOverLord imperator = new SystemOverLord();
		imperator.addCinema(imperator.createCinema());
		imperator.addCinema(imperator.createCinema());
		imperator.addCinema(imperator.createCinema());
	}
}
