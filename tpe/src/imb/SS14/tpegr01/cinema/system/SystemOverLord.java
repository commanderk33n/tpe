package imb.SS14.tpegr01.cinema.system;

import imb.SS14.tpegr01.cinema.Cinema;
import imb.SS14.tpegr01.cinema.Hall;
import imb.SS14.tpegr01.cinema.film.Film;
import imb.SS14.tpegr01.cinema.film.USK;
import imb.SS14.tpegr01.cinema.program.ProgramPart;
import imb.SS14.tpegr01.cinema.program.Time;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Die Klasse SystemOverLord dient zur Verwaltung mehrerer Kinos, sodass Kinos
 * Säle und Filme erstellt und einander zugewiesen werden können.
 * 
 * @author Philipp Siebert
 * 
 */
public class SystemOverLord {
	private ArrayList<Cinema> cinemas;

	/**
	 * konstruktor ohne eine bestehende Kinoliste
	 */
	public SystemOverLord() {
		this(new ArrayList<Cinema>());
	}

	/**
	 * konstruktor mit einer bestehenden Kinoliste
	 * 
	 * @param arrayList
	 *            bestehende Kinoliste
	 */
	public SystemOverLord(ArrayList<Cinema> arrayList) {
		this.cinemas = arrayList;

	}

	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}

	/**
	 * Überschreibt die bestehende Kinoliste mit einer neuen Liste
	 * 
	 * @param cinemas
	 *            neue Kinoliste
	 */
	public void setCinemas(ArrayList<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	/**
	 * Fügt beliebig viele neue Kinos der bestehenden Kinoliste hinzu
	 * 
	 * @param cinemas
	 *            Kino(s) die hinzugefügt werden sollen
	 */
	public void addCinema(Cinema... cinemas) {
		for (Cinema cinema : cinemas) {
			this.cinemas.add(cinema);
		}
	}

	/**
	 * Erstellt ein neues Kino, dass nicht zurückgegeben wird sondern direkt zur
	 * Kinoliste hinzugefügt wird
	 * 
	 * @param name
	 *            Name, der dem Objekt zugewisen wird
	 * @param city
	 *            Stadt, in der sich das Kino befindet
	 * @param halls
	 *            Säle des Kinos
	 */
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

	/**
	 * Fügt dem Saal des kinos ein neues Programm hinzu
	 * 
	 * @param cinema
	 *            Kino auf das zugegriffen wird
	 * 
	 * @param hall
	 *            der Saal dem das Programm zugewiesen werden soll
	 * @param newProgramPart
	 *            Programm das zugewiesen werden soll
	 * @return true - falls hizufügen funktioniert, false falls ein Fehler
	 *         aufgetreten ist.
	 */
	public boolean addProgrammToHall(Cinema cinema, Hall hall,
			ProgramPart newProgramPart) {
		return cinema.addProgramPart(hall, newProgramPart);
	}

	/**
	 * Erstellt ein neues Kino, dass zurückgegeben wird
	 * 
	 * @param name
	 *            Name, der dem Objekt zugewisen wird
	 * @param city
	 *            Stadt, in der sich das Kino befindet
	 * @param halls
	 *            Säle des Kinos
	 * @return Kino das erstellt wurde
	 */
	public Cinema createCinema(String name, String city, Hall... halls) {
		return new Cinema(name, city, halls);
	}

	/**
	 * Erstellt einen neuen Saal, der zurückgegeben wird
	 * 
	 * @param name
	 *            Name des Saals
	 * @param seats
	 *            Anzahl Sitzplätze
	 * @return Saal, der erstellt wurde
	 */
	public Hall createHall(String name, int seats) {
		return (new Hall(name, seats));
	}

	/**
	 * Erstellt einen neuen Film, der zurückgegeben wird
	 * 
	 * @param titel
	 *            Titel des Films
	 * @param usk
	 *            Altersbeschränkung des Films
	 * @param duration
	 *            Dauer des Films in Minuten
	 * @return Film, der erstellt wurde
	 */
	public Film createFilm(String titel, USK usk, int duration) {
		return (new Film(titel, duration, usk));
	}

	/**
	 * Erstellt einen neuen Programmpunkt, der zurückgegeben wird
	 * 
	 * @param film
	 *            Film des Programmpunkts
	 * @param startingTime
	 *            Startzeit des Films
	 * @return Programmpunkt, der erstellt wurde
	 */
	public ProgramPart createFilm(Film film, Time startingTime) {
		return (new ProgramPart(film, startingTime));
	}

	/**
	 * Erstellt neue Uhrzeit, die zurückgegeben wird
	 * 
	 * @param time
	 *            Zeit als String mit Format "HH:MM"
	 * @return Uhrzeit, die erstellt wurde
	 */

	public Time createTime(String time) {
		return (new Time(time));
	}
	// public static void main(String[] args) {
	// SystemOverLord imperator = new SystemOverLord();
	// imperator.addCinema(imperator.createCinema());
	// imperator.addCinema(imperator.createCinema());
	// imperator.addCinema(imperator.createCinema());
	// }
}
