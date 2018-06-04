package springerproblem;

public class Springer {
	private Feld momentanesFeld;
	
	
	public Springer(Feld feld) {
		this.momentanesFeld = feld;
	}

	public void setPosition(Feld feld) {
		this.momentanesFeld = feld;
	}
	
	public Feld getPosition() {
		return this.momentanesFeld;
	}
}
