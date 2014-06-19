package imb.SS14.tpegr01.cinema.film;

import java.util.Comparator;

/**
 * Klasse Film - Ein Film besteht aus einem Titel, Dauer und einer
 * Altersfreigabe. Die Klasse implementiert Comparable mit der Filme nach Titel
 * sortiert werden.
 * 
 * @author Philipp Siebert
 * 
 */
public class Film implements Comparable<Film> {
	private String titel;
	private int duration;
	private USK usk;

	public Film(String titel, int duration, USK usk) {
		this.setTitel(titel);
		this.setDuration(duration);
		this.setUsk(usk);
	}

	// TODO
	// Filme sollen nach allen drei Attributen (Name, Altersfreigabe, Laufzeit)
	// sortiert werden konnen. Die
	// naturlich Sortierreihenfolge von Filmen ist nach dem Namen.
	// Implementieren Sie die Klassen, die fur
	// diese weiteren Sortierkriterien notig sind als statische geschachtelte
	// Klassen im Film.

	public String getTitel() {
		return titel;
	}

	private void setTitel(String titel) {
		this.titel = titel;
	}

	public int getDuration() {
		return duration;
	}

	private void setDuration(int duration) {
		this.duration = duration;
	}

	public USK getUsk() {
		return usk;
	}

	private void setUsk(USK usk) {
		this.usk = usk;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Film) {
			Film p = (Film) o;
			if (p.titel.equals(this.titel)) {
				if (p.duration == this.duration) {
					if (p.usk.equals(this.usk)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String ausgabe = this.getTitel() + " [" + this.getUsk() + "] "
				+ this.getDuration() + " min";
		return ausgabe;
	}

	@Override
	public int compareTo(Film o) {
		return (this.titel.compareTo(o.titel));
	}

	/**
	 * Mit dem USKComparator können Filme nach ihrer Altersfreigabe sortiert
	 * werden
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class USKComparator implements Comparator<Film> {

		@Override
		public int compare(Film o, Film o2) {
			if (o.usk.equals(o2.usk)) {
				return 0;
			}
			if (o.usk.getUsk() < o2.usk.getUsk()) {
				return -1;
			}
			return 1;
		}

	}

	/**
	 * Mit dem TitelComparator können Filme nach ihrem Titel sortiert werden
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class TitelComparator implements Comparator<Film> {

		@Override
		public int compare(Film o, Film o2) {
			return o.compareTo(o2);
		}

	}

	/**
	 * Mit dem DurationComparator können Filme nach ihrem Dauer (n) sortiert
	 * werden
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class DurationComparator implements Comparator<Film> {

		@Override
		public int compare(Film o, Film o2) {
			if (o.duration == o2.duration) {
				return 0;
			}
			if (o.duration < o2.duration) {
				return -1;
			}
			return 1;
		}
	}
}
