package springerproblem;

public class Verwaltung {
	private Input input;
	private Schachbrett schachbrett;
	
	
	
	public Verwaltung() {
		// TODO Auto-generated constructor stub
		input = new Input();
	}
	// Um die hier k�mmere ich mich sp�ter 
	public String verwalten() {
		// Beginn
		System.out.println("\nWillkommen zum Springerproblem!\n");
		
		// Lese Werte ein
		int groesse = input.leseGroesse();
		Feld startFeld = input.leseStartfeld();
		boolean modus = input.leseModus();
		int anzahlAuszugebenderLoesungen = input.leseLoesungen();
		
		// Initialisiere Schachbrett
		schachbrett = new Schachbrett(groesse, startFeld, anzahlAuszugebenderLoesungen);
		System.out.println("\nWir beginnen nun mit der Ermittlung der Pfade:\n");
		schachbrett.koordiniere(modus);	
		// Ueberlege dir etwas wegen Vereinfachter Rekursion, die bricht nicht schnell genug ab!
		String s = new String("\nDamit ist unser Programm zum Springerproblem abgeschlossen. Sch�nen Tag noch!\n");
		return s;
	}

}
