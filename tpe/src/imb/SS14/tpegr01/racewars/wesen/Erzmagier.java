package imb.SS14.tpegr01.racewars.wesen;

import imb.SS14.tpegr01.racewars.Squad;
import imb.SS14.tpegr01.racewars.interfaces.*;

/**
 * Die Klasse <code>Erzmagier</code> stellt den Anführer der Fraktion
 * <code>Mensch</code> und besitzt die Spezialfähigkeit Absorption die
 * verhindert, dass ihm Schaden zugefügt wird.
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 */
public class Erzmagier extends Mensch implements Helden {

	public Held name;
	private int spezialangriffRunde;
	private boolean absorptionAktiv;

	/**
	 * Konstruktor der Klasse <code>Erzmagier</code>
	 */
	public Erzmagier() {
		super(true, Held.ERZMAGIER.getBonusfaktor());
		this.name = Held.ERZMAGIER;
		this.spezialangriffRunde = 0;
		this.absorptionAktiv = false;
	}

	public void spezialfunktion(Squad s, int runde) {
		if (runde > spezialangriffRunde) {
			absorption();
			spezialangriffRunde = runde + 2;
		} else {
			this.absorptionAktiv = false;
		}
	}

	/**
	 * Spezialfähigkeit Absorption die verhindert, dass ihm Schaden zugefügt
	 * wird.
	 */
	private void absorption() {
		this.absorptionAktiv = true;
	}

	public void bekommtSchaden(double schaden) {
		if (!absorptionAktiv) {
			this.setLebenspunkte((int) (this.getLebenspunkte() - schaden));
		}
	}

	public double elementBonus(Helden ziel) {
		String feindlichesElement = ziel.getElement();
		if (feindlichesElement == "Luft") {
			return 2;
		} else {
			return 1;
		}
	}

	public String getElement() {
		return name.getElement();
	}

	public String getName() {
		return "Erzmagier";
	}

}
