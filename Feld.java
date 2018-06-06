package springerproblem;

/**
 * Ein Schachbrett besteht aus mehreren Feldern
 * @author richard
 *
 */
public class Feld {
	
	private char x;
	private int y;
	
	/**
	 * Konstruktor
	 * @param x Der Buchstabe fuer die Schachnotation
	 * @param y Die Zahl fuer die Schachnotation
	 */
	public Feld(char x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Diese Methode gibt den String fuer die Schachnotation des betreffenden Felds aus
	 */
	public String toString() {
		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append(x);
		ausgabe.append(Integer.toString(y));
		return ausgabe.toString();
	}
	
	/**
	 * Dies ist ein Getter fuer den Buchstaben in der Schachnotation
	 * @return den entsprechenden Buchstaben
	 */
	public char getX() {
		return x;
	}
	
	/**
	 * Dies ist ein Getter fuer die Zahl in der Schachnotation
	 * @return die entsprechende Zahl
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Dies ist eine Vergleichsmethode die die aktuelle Instanz eines Felds mit einem gegebenen Feld vergleicht
	 * @param f das zu vergleichende Feld
	 * @return true, wenn sowohl Buchstabe als auch Zahl der beiden Felder identisch sind, sonst false
	 */
	public boolean equals(Feld f) {
		if(this.getX() == f.getX()) {
			if(this.getY() == f.getY()) {
				return true;
			}
		}
		return false;
	}
}
