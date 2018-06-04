package springerproblem;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verwaltung verwaltung = new Verwaltung();
		verwaltung.verwalten();
		
		
		// Debug
		Feld feld = new Feld('D', 2);
		Schachbrett s = new Schachbrett(5, feld);
		// Rekursiv-Klassisch
		s.koordiniere(false);
		// Rekursives zeug funktioniert
	}

}
