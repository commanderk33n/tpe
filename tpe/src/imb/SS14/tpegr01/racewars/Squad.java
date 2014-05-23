package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.wesen.Wesen;
import imb.SS14.tpegr01.racewars.wesen.WesenFactory;
import imb.SS14.tpegr01.racewars.wesen.WesenFactory.Rasse;

/**
 * Die Klasse <code>Squad</code> stellt das Team der gewählten Wesen eines
 * Spielers dar. Die Wesen werden in einem Array gespeichert, dem Squad wird
 * auch ein Name zugeordnet und es zählt die Anzahl der lebendigen Wesen des
 * Arrays. Ein Objetct dieser Klasse kann nur mit einem Object der Klasse
 * <code>Spieler</code> erstellt werden.
 * <p>
 * 
 * <p>
 * <blockquote>
 * 
 * <pre>
 * Squad squad1 = new Squad(spieler);
 * </p>
 * </blockquote></pre>
 * 
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 */

public class Squad {

	private String name;
	private Wesen[] armee;
	int lebendigeWesen;

	/**
	 * Erstellt ein Object der Klasse <code>Squad</code> mit einem Parameter der
	 * Klasse <code>Spieler</code>,die feststellt welche Rassen und
	 * Investitionen der Spieler gewählt hat und mit der Methode
	 * rekrutiereArmee(Rasse rasse, int invest) die Wesen erstellt.
	 * 
	 * @param spieler
	 *            Spieler dessen Squad erstellt werden soll
	 */
	public Squad(Spieler spieler) {
		this.name = spieler.getSquadName();
		Wesen[] truppe1 = rekrutiereArmee(spieler.getGewaehlteKlassen()[0],
				spieler.gewaehlteInvestitionen()[0]);
		Wesen[] truppe2;
		if (spieler.getGewaehlteKlassen().length == 2) {
			truppe2 = rekrutiereArmee(spieler.getGewaehlteKlassen()[1],
					spieler.gewaehlteInvestitionen()[1]);
		} else {
			truppe2 = new Wesen[0];
		}
		this.armee = new Wesen[truppe1.length + truppe2.length];
		for (int i = 0; i < armee.length; i++) {
			if (i < truppe1.length) {
				this.armee[i] = truppe1[i];
			} else {
				this.armee[i] = truppe2[i - truppe1.length];
			}
		}
		this.lebendigeWesen = this.armee.length;
	}

	/**
	 * Erstellt mithilfe der Klasse <code>Wesenfactory</code> die Wesen und in
	 * einem Array zurückgibt
	 * 
	 * @param rasse
	 *            Rasse, der die erzeugten Wesen angehören sollen.
	 * @param invest
	 *            Investition in die angegebene Rasse, die angibt wie viele
	 *            Wesen erstellt werden anhand der Kosten der Wesen dieser
	 *            Rasse.
	 * @return Array of Wesen, indem alle erzeugten Wesen zurückgegeben werden.
	 */
	private Wesen[] rekrutiereArmee(Rasse rasse, int invest) {
		Wesen[] armee = WesenFactory.erschaffe(rasse, invest);
		return armee;
	}

	/**
	 * Überprüft ob das Wesen an der Stelle index des Arrays noch Lebenspunkte
	 * besitzt und weiterkämpfen kann oder nicht. Falls es nicht mehr kämpfen
	 * kann wird mit der Methode restlicheTruppen(index) ein neues Array
	 * erstellt, das alle Wesen übernimmt außer das an der Position des Wesens
	 * ohne Lebendspunkte beinhaltet.
	 * 
	 * @param index
	 *            Position des Wesens im Array
	 */
	public void kampffaehig(int index) {
		if (!armee[index].isLebendig()) {
			lebendigeWesen--;
			if (this.lebendigeWesen > 0) {
				armee = restlicheTruppen(index);
			}
		}
	}

	/**
	 * Erstellt ein neues Array, das alle Wesen übernimmt außer das an der
	 * Position des Wesens ohne Lebendspunkte beinhaltet.
	 * 
	 * @param index
	 *            Position des Wesens ohne Lebendspunkte
	 * @return Array mit den restlichen Wesen
	 */
	private Wesen[] restlicheTruppen(int index) {
		Wesen[] neueArmee = new Wesen[lebendigeWesen];
		int indexAlt = 0;
		for (int indexNeu = 0; indexNeu < neueArmee.length; indexNeu++) {
			if (index == indexAlt) {
				indexAlt++;
			}
			neueArmee[indexNeu] = armee[indexAlt];
			indexAlt++;
		}
		return neueArmee;
	}

	/**
	 * 
	 * @param angreifendesSquad
	 */
	public void wirdAngegriffen(Squad angreifendesSquad, int runde) {
		for (int i = 0; i < angreifendesSquad.lebendigeWesen; i++) {
			if (this.lebendigeWesen > 0) {
				Wesen angreifer = angreifendesSquad.getWesen(i);
				/*
				 * if (angreifer instanceof Helden){ Helden
				 * held=(Helden)angreifer; held.spezialfunktion(this, runde); }
				 */
				int opferindex = zufallsIndex();
				Wesen opfer = this.armee[opferindex];
				double schaden = angreifer.attacke(opfer);
				GameViewer.printAngriff(angreifer, opfer, schaden);
				kampffaehig(opferindex);
			} else {
				break;
			}
		}
	}

	/**
	 * Erstellt eine Zufällige Zahl, die als Indexwert des Wesenarrays verwendet
	 * wird um einen Gegner zu ermitteln.
	 * 
	 * @return einen zufälligen ganzahligen Wert zwischen 0 und der Anzahl der
	 *         Wesen.
	 */
	public int zufallsIndex() {
		return (int) (Math.random() * this.lebendigeWesen);
	}

	/**
	 * Gibt den Namen des Squads aus
	 * 
	 * @return Name des Squads
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gibt die Anzahl der lebenden Wesen des Squads aus
	 * 
	 * @return Anzahl der Wesen mit Lebenspunkten
	 */
	public int getLebendige() {
		return this.lebendigeWesen;
	}

	/**
	 * Gibt das Wesen an der Position index innherhalb des Wesenarrays
	 * 
	 * @param index
	 *            Position des Wesens innherhalb des Wesenarrays das
	 *            zurückgegeben werden soll
	 * @return Wesen an der Position index
	 */
	public Wesen getWesen(int index) {
		if (index < armee.length) {
			return this.armee[index];
		} else {
			return null;
		}
	}

	/**
	 * Gibt zu jedem Wesen des Arrays die Rasse und die Lebenspunkte aus.
	 */
	public String toString() {
		String info = "";
		for (int i = 0; i < armee.length; i++) {
			info += armee[i].getRasse() + "\t" + armee[i].getLebenspunkte()
					+ "\n";
		}

		return info;
	}

}
