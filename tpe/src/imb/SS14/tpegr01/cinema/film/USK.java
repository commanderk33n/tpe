package imb.SS14.tpegr01.cinema.film;

/**
 * Enumeration-Klasse <code>USK</code> legt eindeutig die
 * USK-Freigaben der Filme an.
 * Attribut <code>usk</code> beinhaltet Zahl der Freigabe
 * Attribut <code>text</code> beinhaltet Text zur Freigabe
 * 	ohne Alterbeschraenkung - 0
 * 	ab 6 Jahre - 6
 * 	ab 12 Jahre - 12
 * 	ab 16 Jahren - 16
 * 	Keine Jugendfreigabe - 18
 */

public enum USK {
	OHNEALT("ohne Altersbeschränkung", 0), ABSECHS("ab 6 Jahre", 6), ABZWOELF(
			"ab 12 Jahre", 12), ABSECHZEHN("ab 16 Jahre", 16), OHNEJUGEND(
			"keine Jugendfreigabe", 18);

	private String text;
	private int usk;

	private USK(String text, int usk) {
		this.setText(text);
		this.setUsk(usk);

	}

	@Override
	public String toString() {
		return this.text;
	}

	public String getText() {
		return text;
	}

	private void setText(String text) {
		this.text = text;
	}

	public int getUsk() {
		return usk;
	}

	private void setUsk(int usk) {
		this.usk = usk;
	}
}
