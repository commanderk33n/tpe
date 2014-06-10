package imb.SS14.tpegr01.cinema;

public class Film {
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

	public String toString() {
		String ausgabe = this.getTitel() + " [" + this.getUsk() + "] "
				+ this.getDuration() + " min";
		return ausgabe;
	}

}
