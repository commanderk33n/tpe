/**
 * 
 */
package imb.SS14.tpegr01.cinema.program;

import java.util.Comparator;

import imb.SS14.tpegr01.cinema.film.Film;

/**
 * Die Klasse ProgrammPart dient als Programm-Objekt, diese besteht aus einem
 * Film und einer Startzeit. Die Klasse implementiert Comparable mit nach Filmen
 * sortiert wird.
 * 
 * @author Philipp Siebert
 */
public class ProgramPart implements Comparable<ProgramPart> {

	private Film movie;
	private Time startingTime;

	/**
	 * Konstruktor erstellt Programm-Objekte, diese besteht aus einem Film und
	 * einer Startzeit.
	 * 
	 * @param movie
	 *            Film
	 * @param time
	 *            Startzeit des Films
	 */
	public ProgramPart(Film movie, Time time) {
		setFilm(movie);
		setTime(time);
	}

	public Film getFilm() {
		return movie;
	}

	private void setFilm(Film movie) {
		this.movie = movie;
	}

	public Time getTime() {
		return startingTime;
	}

	private void setTime(Time startingTime) {
		this.startingTime = startingTime;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ProgramPart) {
			ProgramPart p = (ProgramPart) o;
			if (p.movie.equals(this.movie)) {
				if (p.startingTime.equals(this.startingTime)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Ausgabe wie folgt :
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * 15:00 -- Ice Age 3 [ohne Altersbeschrankung] 90 min
	 * </pre>
	 * 
	 * </blockquote>
	 * </p>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ausgabe = startingTime.toString() + " -- " + movie.toString();
		return ausgabe;
	}

	@Override
	public int compareTo(ProgramPart o) {
		if (this.equals(o)) {
			return 0;
		}
		int titelVergleich = (this.movie.getTitel().compareTo(o.movie
				.getTitel()));
		if (titelVergleich == 0) {
			if (this.startingTime.getTimeAsMinutes() > o.startingTime
					.getTimeAsMinutes()) {
				return -1;
			}
			return 1;
		}
		return titelVergleich;
	}

	/**
	 * Mit dem ProgramPartTitelComparator können Filme nach ihrer Sartzeit
	 * sortiert werden
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class ProgramPartTitelComparator implements
			Comparator<ProgramPart> {

		@Override
		public int compare(ProgramPart o, ProgramPart o2) {
			return o.compareTo(o2);
		}

	}

	/**
	 * Mit dem ProgramPartStartingTimeComparator können Filme nach ihrer
	 * Sartzeit sortiert werden
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class ProgramPartStartingTimeComparator implements
			Comparator<ProgramPart> {

		@Override
		public int compare(ProgramPart o, ProgramPart o2) {
			int time1 = o.startingTime.getTimeAsMinutes();
			int time2 = o2.startingTime.getTimeAsMinutes();
			if (time1 == time2) {
				return o.compareTo(o2);
			}
			if (time1 < time2) {
				return -1;
			}
			return 1;
		}
	}

}
