package imb.SS14.tpegr01.cinema.system;

import imb.SS14.tpegr01.cinema.film.Film;

import java.util.Comparator;

/**
 * Sortierkriteriums als Enumeration mit der Filme nach allen drei Attributen
 * (Name, Altersfreigabe, Laufzeit) sortiert werden können
 * 
 * @author Philipp Siebert
 * 
 */
public enum SortingCriterion {
	Name() {
		public Comparator<Film> getComparator() {
			return new Film.TitelComparator();
		}
	},
	Altersfreigabe() {
		public Comparator<Film> getComparator() {
			return new Film.USKComparator();
		}
	},
	Laufzeit() {
		public Comparator<Film> getComparator() {
			return new Film.DurationComparator();
		}
	};
	/**
	 * Gibt den entsprechenden Film-Comparator aus
	 * 
	 * @return Film-Comparator der Enumeration
	 */
	public abstract Comparator<Film> getComparator();
}
