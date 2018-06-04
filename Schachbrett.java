package springerproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Schachbrett {

	private Feld startFeld;
	private Springer springer;	
	private Feld[][] felder;
	private List<Feld> pfad;
	private Set<Feld> besuchteFelder;
	
	public Schachbrett(int dimension, Feld startFeld) {
		
	}
	public void initialisiereFelder() {
		
		
	}
	public List<Feld> ermittleEckfelder() {
		
		return new ArrayList<Feld>();
	}
	
	public void verschiebeSpringer(Feld wohin) {
		
	}
	public List<Feld> moeglicheFelder() {
		
		
		
		return new ArrayList<Feld>();
	}
	public void rekursivKlassisch(Feld aktuellesFeld, List<Feld> pfad) {
		
	}
	public void rekursivEinfach(Feld aktuellesFeld, List<Feld> pfad) {
	
	}
	public void koordiniere(boolean modus) {
		
	}
	
	public List<Feld> getPfad() {
		return this.pfad;
	}
}
