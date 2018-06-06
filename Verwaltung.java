package springerproblem;

/**
 * Diese Klasse ordnet die eingelesenen Werte zu und fuehrt das Programm aus
 * @author richard
 *
 */
public class Verwaltung {
	
	private Input input;
	private Schachbrett schachbrett;
	
	/**
	 * Konstruktor
	 */
	public Verwaltung() {
	}
	
	/**
	 * Diese Methode instanziiert das Input-Merkmal, ordnet die Werte zu, und fuehrt an dem instanziierten Schachbrett-Attribut die koordiniere()-Funktion aus.
	 */
	public void verwalten() {
		input = new Input();
		System.out.println("\nWillkommen zum Springerproblem!\n");
		
		int groesse = input.leseGroesse();
		Feld startFeld = input.leseStartfeld();
		boolean modus = input.leseModus();
		int anzahlAuszugebenderLoesungen = input.leseLoesungen();
		
		schachbrett = new Schachbrett(groesse, startFeld, anzahlAuszugebenderLoesungen);
		System.out.println("\nEs wird mit der Ermittlung der Pfade begonnen:\n");
		schachbrett.koordiniere(modus);
		System.out.println("\nDamit ist das Programm zum Springerproblem abgeschlossen. Auf Wiedersehen!\n");

	}
	

}
