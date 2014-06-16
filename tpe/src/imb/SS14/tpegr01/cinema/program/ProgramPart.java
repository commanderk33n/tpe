/**
 * 
 */
package imb.SS14.tpegr01.cinema.program;

import imb.SS14.tpegr01.cinema.film.Film;

/**
 * @author Philipp Siebert
 * 
 */
public class ProgramPart implements Comparable<ProgramPart> {

	private Film movie;
	private Time startingTime;

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

	// 15:00 -- Ice Age 3 [ohne Altersbeschrankung] 90 min
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
}
