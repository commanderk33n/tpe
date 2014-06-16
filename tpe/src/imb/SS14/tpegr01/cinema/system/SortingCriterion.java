package imb.SS14.tpegr01.cinema.system;

import imb.SS14.tpegr01.cinema.film.Film;

import java.util.Comparator;

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

	public abstract Comparator<Film> getComparator();
	// Auslesen aller Filme, die im Kino laufen als Array. Hierbei soll jeder
	// Film nur einmal enthalten sein,
	// auch wenn er zu mehreren Zeiten und in unterschiedliche Salen lauft
	// (getAlleFilme). Die Methode
	// ist uberladen und erlaubt in einer Variante die Angabe eines
	// Sortierkriteriums als Enumeration.
	// Wird kein Kriterium angegeben, werden die Filme nach dem Namen sortiert.

	// //Filme sollen nach allen drei Attributen (Name, Altersfreigabe,
	// Laufzeit) sortiert werden konnen. Die
	// naturlich Sortierreihenfolge von Filmen ist nach dem Namen.
	// Implementieren Sie die Klassen, die fur
	// diese weiteren Sortierkriterien notig sind als statische geschachtelte
	// Klassen im Film.

}
