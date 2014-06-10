/**
 * 
 */
package imb.SS14.tpegr01.cinema;

/**
 * @author Philipp Siebert
 * 
 */
public class ProgramPart {

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

	// 15:00 -- Ice Age 3 [ohne Altersbeschrankung] 90 min
	public String toString() {
		String ausgabe = startingTime.toString() + " -- " + movie.toString();
		return ausgabe;
	}

}
