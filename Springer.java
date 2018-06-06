package springerproblem;

/**
 * Diese Klasse repraesentiert den beweglichen Springer
 * @author richard
 *
 */
public class Springer {
	
	private Feld momentanesFeld;
	
	/**
	 * Konstruktor
	 * @param feld das Feld, auf dem der Springer beginnen soll
	 */
	public Springer(Feld feld) {
		this.momentanesFeld = feld;
	}
	
	/**
	 * Diese Methode setzt das Attribut momentanesFeld auf den angegebenen Parameter.
	 * @param feld das Feld, welches das momentane Feld fuer den Springer werden soll
	 */
	public void setPosition(Feld feld) {
		momentanesFeld = feld;
	}
	
	/**
	 * Diese Methode ist ein Getter fuer die Position des Springers.
	 * @return das momentane Feld des Springers
	 */
	public Feld getPosition() {
		return momentanesFeld;
	}
}
