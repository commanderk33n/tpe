package imb.SS14.tpegr01.cinema;

import java.util.ArrayList;

public class SystemOverLord {
	private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

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
	public Film[] getAllMoviesWithTimes(Cinema c) {
		// TODO
		return null;
	}

	/**
	 * Auslesen aller Filme in einem bestimmten Saal mit den entsprechenden
	 * Anfangszeiten als Array. Die Filme sind nach der Startzeit sortiert.
	 * (getFilmeFuerSaalMitZeiten)
	 */
	public Film[] getMoviesForHallWithTimes(Cinema c, Hall h) {
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
}
