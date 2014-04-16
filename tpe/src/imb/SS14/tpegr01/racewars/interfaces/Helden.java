package imb.SS14.tpegr01.racewars.interfaces;

public interface Helden {

	public static enum Held {
		FARSEER(1.2, "Erde"), LICH(2.3, "Wasser"), DAEMONENJAEGER(3.0, "Luft"), ERZMAGIER(
				5.0, "Feuer");

		private final double BONUSFAKTOR;
		private final String ELEMENT;

		private Held(double bonusfaktor, String element) {
			this.BONUSFAKTOR = bonusfaktor;
			this.ELEMENT = element;
		}

		public double getBonusfaktor() {
			return this.BONUSFAKTOR;
		}

		public String getElement() {
			return this.ELEMENT;
		}

	};
	
	public abstract String getElement();
	public abstract double kampfGegenHeld(Helden gegner);

}
