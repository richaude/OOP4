package springerproblem;

/**
 * Einsprungsklasse fuer die Virtual Machine
 * @author richard
 *
 */
public class Main {

	/**
	 * Diese Methode erzeugt eine Instanz der Klasse Verwaltung und ruft an ihr die verwalten()-Funktion auf
	 * @param args
	 */
	public static void main(String[] args) {
		Verwaltung verwaltung = new Verwaltung();
		verwaltung.verwalten();
	}

}
