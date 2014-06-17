package imb.SS14.tpegr01.cinema.system;

import imb.SS14.tpegr01.cinema.Cinema;
import imb.SS14.tpegr01.cinema.Hall;
import imb.SS14.tpegr01.cinema.film.Film;
import imb.SS14.tpegr01.cinema.program.ProgramPart;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemOverLord {
	private ArrayList<Cinema> cinemas;

	public SystemOverLord() {
		this(new ArrayList<Cinema>());
	}

	public SystemOverLord(ArrayList<Cinema> arrayList) {
		this.cinemas = arrayList;

	}

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
		if (c == null) {
			return null;
		}
		return c.getAllMoviesWithTimes();
	}

	/**
	 * Auslesen aller Filme in einem bestimmten Saal mit den entsprechenden
	 * Anfangszeiten als Array. Die Filme sind nach der Startzeit sortiert.
	 * (getFilmeFuerSaalMitZeiten)
	 */
	public ProgramPart[] getMoviesForHallWithTimes(Cinema c, Hall h) {
		if (c == null) {
			return null;
		}
		return c.getMoviesForHallWithTimes(h);
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
	public Film[] getAllMovies(Cinema c) {
		return c.getAllMovies();
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
	public Film[] getAllMovies(Cinema c, SortingCriterion s) {
		Film[] movies = getAllMovies(c);
		Arrays.sort(movies, s.getComparator());
		return movies;

	}

	public Cinema createCinema(String name, String city, Hall... halls) {
		return new Cinema(name, city, halls);
	}

	public Hall createHall(String name, int seats) {
		return (new Hall(name, seats));
	}

	// public static void main(String[] args) {
	// SystemOverLord imperator = new SystemOverLord();
	// imperator.addCinema(imperator.createCinema());
	// imperator.addCinema(imperator.createCinema());
	// imperator.addCinema(imperator.createCinema());
	// }
}
