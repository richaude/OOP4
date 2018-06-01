package springerproblem;

public class Feld {
	
	private char x;
	private int y;
	
	public Feld(char x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append(x);
		ausgabe.append(Integer.toString(y));
		return ausgabe.toString();
	}

}
