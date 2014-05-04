package imb.SS14.tpegr01.racewars.interfaces;

/**
 * Interface für alle Kämpfen mit der Methode die alle Kämpfer besitzten müssen.
 * (attacke(Kaempfer r)
 * @author Tim Hubert
 * @author Torsten Müller
 * @author Philipp Siebert
 * 
 */
public interface Kaempfer {
	/**
	 * Methode die die Attake eines Kämpfers auf einen anderen darstellt, es
	 * wird der Schaden berechnet und mit der Rüstung des Gegners verrechnet
	 * sowie von dessen Lebenspunkten angezogen wird.
	 * 
	 * @param r
	 *            Gegner der angegriffen wird
	 * @return Schaden der von den Lebenspunkten abgezogen wurde
	 */
	public abstract double attacke(Kaempfer r);
}
