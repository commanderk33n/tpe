package imb.SS14.tpegr01.cinema;

public enum USK {
	OHNEALT("ohne Altersfreigabe", 0), ABSECHS("ab 6 Jahre", 6), ABZWOELF(
			"ab 12 Jahre", 12), ABSECHZEHN("ab 16 Jahre", 16), OHNEJUGEND(
			"ohne Jugendfreigabe", 18);

	private String text;
	private int usk;

	private USK(String text, int usk) {
		this.setText(text);
		this.setUsk(usk);

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
