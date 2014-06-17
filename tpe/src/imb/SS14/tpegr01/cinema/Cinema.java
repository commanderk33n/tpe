package imb.SS14.tpegr01.cinema;

import imb.SS14.tpegr01.cinema.film.Film;
import imb.SS14.tpegr01.cinema.program.ProgramPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Cinema implements Iterable<ProgramPart> {

	private String name;
	private String city;
	private HashMap<Hall, ArrayList<ProgramPart>> program;

	public Cinema(String name, String city, Hall... halls) {
		this.setName(name);
		this.setCity(city);
		this.program = new HashMap<Hall, ArrayList<ProgramPart>>();
		for (Hall hall : halls) {
			this.program.put(hall, new ArrayList<ProgramPart>());
		}
	}

	public boolean addProgramPart(Hall hall, ProgramPart newProgramPart) {
		if (program.containsKey(hall)) {
			ArrayList<ProgramPart> currentProgram = program.get(hall);
			try {
				permitted(currentProgram, newProgramPart);
				currentProgram.add(newProgramPart);
				return true;
			} catch (IllegalProgrammTimeException e) {
				System.out.println("Fehler: " + e.getMessage());
			}
		}

		return false;
	}

	public void clearProgrammOfHall(Hall hall) {
		if (program.containsKey(hall)) {
			this.program.put(hall, new ArrayList<ProgramPart>());
		}
	}

	public void clearWholeProgramm() {
		for (Hall hall : program.keySet()) {
			this.program.put(hall, new ArrayList<ProgramPart>());
		}
	}

	/**
	 * @param currentProgram
	 * @param newProgramPart
	 * @return
	 */
	private void permitted(ArrayList<ProgramPart> currentProgram,
			ProgramPart newProgramPart) throws IllegalProgrammTimeException {
		int startingTimeNewFilm = newProgramPart.getTime().getTimeAsMinutes();
		int endingTimeNewFilm = (newProgramPart.getTime().getTimeAsMinutes() + newProgramPart
				.getFilm().getDuration());
		for (ProgramPart currentProgramPart : currentProgram) {
			int startingTimeCurrentFilm = currentProgramPart.getTime()
					.getTimeAsMinutes();
			int endingTimeCurrentFilm = (currentProgramPart.getTime()
					.getTimeAsMinutes() + currentProgramPart.getFilm()
					.getDuration());
			if (startingTimeNewFilm < startingTimeCurrentFilm
					&& endingTimeNewFilm > startingTimeCurrentFilm) {
				throw new IllegalProgrammTimeException(
						"Programm Zeiten überscheiden sich!");
			}
			if (startingTimeNewFilm < endingTimeCurrentFilm
					&& endingTimeNewFilm > endingTimeCurrentFilm) {
				throw new IllegalProgrammTimeException(
						"Programm Zeiten überscheiden sich!");
			}
		}
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public Map<Hall, ArrayList<ProgramPart>> getProgram() {
		return this.program;
	}

	public Hall[] getHalls() {
		Hall[] halls = program.keySet().toArray(new Hall[0]);
		Arrays.sort(halls, new Hall.HallComparator());
		return halls;
	}

	/**
	 * Zusätzlich soll das Kino noch die Möglichkeit bieten, über die
	 * toString-Methode den gesamten Spielplan auszugeben. Beispielsweise sieht
	 * die Ausgabe dann so aus:
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * Cinemaxx in Mannheim Saal 
	 * 'Blauer Saal' (250 Plaetze) 
	 * 14:00 -- Batman Begins [ab 12 Jahre] 134 min 
	 * 17:00 -- Batman Begins [ab 12 Jahre] 134 min 
	 * 20:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 23:00 -- Batman Begins [ab 12 Jahre] 134 min 
	 * Saal 'Grüner Saal' (200 Plaetze) 
	 * 17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min 
	 * 19:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min 
	 * 21:00 -- Machete [keine Jugendfreigabe] 100 min 
	 * Saal 'Studio' (150 Plaetze) 
	 * 15:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min 
	 * 17:00 -- Trainspotting [keine Jugendfreigabe] 89 min 
	 * 20:00 -- Pulp Fiction [ab 16 Jahre] 148 min
	 * </pre>
	 * 
	 * </blockquote>
	 * </p>
	 * 
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String plan = this.name + " in " + this.city + "\n";
		Hall[] halls = getHalls();
		for (Hall hall : halls) {
			plan += hall.toString() + "\n";
			for (ProgramPart program : getMoviesForHallWithTimes(hall)) {
				plan += program.toString() + "\n";
			}
		}
		return plan;
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
	public ProgramPart[] getAllMoviesWithTimes() {
		ArrayList<ProgramPart> completeProgram = new ArrayList<ProgramPart>();
		for (ArrayList<ProgramPart> list : Cinema.this.program.values()) {
			completeProgram.addAll(list);
		}
		ProgramPart[] allMoviesWithTimes = (ProgramPart[]) completeProgram
				.toArray(new ProgramPart[0]);
		Arrays.sort(allMoviesWithTimes,
				new ProgramPart.ProgramPartStartingTimeComparator());
		return allMoviesWithTimes;
	}

	/**
	 * Auslesen aller Filme, die im Kino laufen als Array. Hierbei soll jeder
	 * Film nur einmal enthalten sein, auch wenn er zu mehreren Zeiten und in
	 * unterschiedliche Sälen läuft. Die Filme nach dem Namen sortiert.
	 * (getAlleFilme)
	 * 
	 * @return alle Filme des Kinos
	 */
	public Film[] getAllMovies() {
		Set<Film> movies = new TreeSet<Film>();
		for (ProgramPart p : this) {
			movies.add(p.getFilm());
		}

		return movies.toArray(new Film[0]);
	}

	/**
	 * Auslesen aller Filme in einem bestimmten Saal mit den entsprechenden
	 * Anfangszeiten als Array. Die Filme sind nach der Startzeit sortiert.
	 * (getFilmeFuerSaalMitZeiten)
	 */
	public ProgramPart[] getMoviesForHallWithTimes(Hall h) {
		if (this.program.containsKey(h)) {
			ProgramPart[] programOfHall = this.program.get(h).toArray(
					new ProgramPart[0]);
			Arrays.sort(programOfHall,
					new ProgramPart.ProgramPartStartingTimeComparator());
			return programOfHall;
		}
		return null;
	}

	private void setName(String name) {
		this.name = name;
	}

	// sinnvolle Methode?!
	public void setWholeProgramm(
			HashMap<Hall, ArrayList<ProgramPart>> newProgram) {
		this.program = newProgram;
	}

	private void setCity(String city) {
		this.city = city;
	}

	// Implementieren Sie die Klasse Kino so, dass Objekte von ihr in einer
	// foreach-Schleife verwendet werden
	// können, um über das gesamte Programm zu iterieren (Film und
	// Anfangszeit). Bei jedem Schleifendurchlauf
	// soll ein Objekt zurückgegeben werden, dass die Startzeit und den Film
	// enthält. Filme können
	// doppelt vorkommen, wenn sie unterschiedliche Anfangszeiten haben.
	private class CinemaIterator implements Iterator<ProgramPart> {

		private int index = 0;
		private ArrayList<ProgramPart> completeProgram = new ArrayList<ProgramPart>();

		public CinemaIterator() {
			for (ArrayList<ProgramPart> list : Cinema.this.program.values()) {
				completeProgram.addAll(list);
			}

		}

		/**
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			if (index < completeProgram.size()) {
				return true;
			}
			return false;
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public ProgramPart next() {
			while (this.hasNext()) {
				ProgramPart next = this.completeProgram.get(index);
				index++;
				return next;
			}
			return null;
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			// not supported!

		}

	}

	public class IllegalProgrammTimeException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public IllegalProgrammTimeException(String message) {
			super(message);
		}
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<ProgramPart> iterator() {
		return new CinemaIterator();
	}
}
