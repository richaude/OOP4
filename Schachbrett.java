package springerproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schachbrett {

	private Feld startFeld;
	private Springer springer;	
	private Feld[][] felder;
	private List<Feld> pfad;
	private Set<Feld> besuchteFelder;
	private int loesungsAnzahl = 0;
	private int auszugebendeLoesungen;
	
	/**
	 * Initlisiert Schachfeld per Dimension und Startfeld des Springers
	 * @param dimension Dimension des Schachfeldes, wird an InitialisiereFelder() weitergereicht
	 * @param startFeld StartFeld des Springers
	 */
	public Schachbrett(int dimension, Feld startFeld, int auszugebendeLoesungen) {
		this.startFeld = startFeld;
		this.springer = new Springer(this.startFeld);
		initialisiereFelder(dimension);
		ermittleEckfelder();
		this.pfad = new ArrayList<Feld>();
		this.besuchteFelder = new HashSet<Feld>();
		this.auszugebendeLoesungen = auszugebendeLoesungen;
	}
	
	/**
	 * Initialisiert das KlassenAttribut fleder Schach-getreu mit den richtigen Feldern.
	 * @param dimension Dimension des Schachfeldes, bsp. 4x4 oder 8x8; nur Intervall (0,26] zulaessig
	 */
	public void initialisiereFelder(int dimension) {
		if(dimension > 26) {
			System.out.println("Schachbrett konnte mit mehr als 26 Buchstaben nicht initialisiert werden. Abbruch, diesen Fehler bei der Eingabe bitte abfangen.");
			return;
		}
		else if(dimension < 1) {
			System.out.println("Schachbrett kann nicht mit weniger als einem Feld initialisiert werden! Abbruch, diesen Fehler bei der Eingabe bitte abfangen.");
			return;
		}
		else {
			char currentLetter = 'A';
			int tempValue = dimension;			// Damit kann ich Arbeiten, muss ja die Schachschrift realisieren
			this.felder = new Feld[dimension][dimension];
			
			for(int i = 0; i<dimension; i++) {
				for(int j = 0; j<dimension; j++) {
					this.felder[i][j] = new Feld(currentLetter, j+1);
				}
				
				if(tempValue >= 0) {
					currentLetter += 1;
					tempValue -= 1;
				}
			}
		}
		/*
		DEBUG_POWER
		for(int i = 0; i<dimension; i++) {
			for(int j = 0; j<dimension; j++) {
				System.out.println("Feld: = " +felder[i][j]);
			}
		}
		*/
	}
		
	/**
	 * Ermittelt die vier Eckfelder des Schachbretts und gibt sie dann zureck
	 * @return Liste mit den Eckfeldern des Schachbretts
	 */
	public List<Feld> ermittleEckfelder() {
		// Haelt die Eckfelder, Variable fuer Position der EckFelder
		ArrayList<Feld> eckfelder = new ArrayList<Feld>(4);
		int randPos = this.felder.length -1;
		
		// Fuegt die Eckfelder hinzu
		eckfelder.add(this.felder[0][0]);
		eckfelder.add(this.felder[randPos][0]);
		eckfelder.add(this.felder[0][randPos]);
		eckfelder.add(this.felder[randPos][randPos]);
		
		//Debug
		/*
		for(Feld f : eckfelder) {
			System.out.println(f);
		}
		*/
		
		//Rueckgabe
		return eckfelder;
	}

	/**
	 * Koordiniert den Programmablauf in Bezug auf den gewuenschten Modus
	 * @param modus Modus des Springerproblems, True fuer klassisch, False fuer einfach
	 */
	public void koordiniere(boolean modus) {	
		if(modus) {
			rekursivKlassisch(this.startFeld, this.pfad);
			
			if(this.loesungsAnzahl == 0) {
				System.out.println("Leider konnten wir keinen Weg mit dieser Kombination von Schachbrett-Dimension und Startfeld finden! Vielleicht sollten sie ein anderes Startfeld probieren?");
			}
		}
		else {
			rekursivEinfach(this.startFeld, this.pfad);
			
			if(this.loesungsAnzahl == 0) {
				System.out.println("Keinen Weg mit dieser Kombination von Schachbrett-Dimension und Startfeld gefunden!");
			}
		}
		// hier muss nochwas hin
		System.out.println("\n\nAnzahl aller Pfade, die die Loesung des Problems verkoerpern: " + this.loesungsAnzahl);
	}	
	/**
	 * Bestimmt anhand der Position des Springers auf dem Schachbrett die moeglichen Felder, auf die er verschoben werden koennte, shuffled diese um mehrere Loesungen zu Ermoeglichen
	 * @return Die Liste aller moeglichen Felder, auf die der Springer springen koennte
	 */
	public List<Feld> moeglicheFelder() {
		// Halte moegliche Felder, aktuelles Feld und dessen Koordinaten, RandKoordinaten
		List<Feld> rueckgabe = new ArrayList<Feld>();
		Feld currentField = this.springer.getPosition();
		
		char rX = this.felder[this.felder.length-1][this.felder.length-1].getX();
		char rX2 = this.felder[this.felder.length-2][this.felder.length-2].getX();
		int rY = this.felder[this.felder.length-1][this.felder.length-1].getY();
		
		char x = currentField.getX();
		int y = currentField.getY();
		
		// Ermittle Moegliche Felder
		
			// Zwei Rechts, eins hoch
			if(((y+2) <= rY) && (x != 'A')) {
				rueckgabe.add(new Feld((char)(x-1), y+2));
			}
			
			// Zwei Rechts eins runter
			if(((y+2) <= rY) && (x != rX)) {
				rueckgabe.add(new Feld((char)(x+1), y+2));
			}
			
			// Zwei links eins hoch
			if(((y-2) >= 1) && (x != 'A')) {
				rueckgabe.add(new Feld((char)(x-1), y-2));
			}
			
			// Zwei links eins runter
			if(((y-2) >= 1) && (x != rX)) {
				rueckgabe.add(new Feld((char)(x+1), y-2));
			}
		
			// Zwei hoch eins links
			if(((y-1) >= 1) && ( x != 'A' ) && (x != 'B')) {
				rueckgabe.add(new Feld((char) (x-2), y-1));
			}
			
			// Zwei hoch eins rechts
			if(((y+1) <= rY) && ( x != 'A' ) && (x != 'B')) {
				rueckgabe.add(new Feld((char) (x-2), y+1));
			}
			
			// Zwei runter eins links
			if(((y-1) >= 1) && ( x != rX ) && (x != rX2 )) {
				rueckgabe.add(new Feld((char) (x+2), y-1));
			}
			
			// Zwei runter eins rechts
			if(((y+1) <= rY) && ( x != rX ) && (x != rX2 )) {
				rueckgabe.add(new Feld((char) (x+2), y+1));
			}

		//Jetzt schon gebrauchte Felder aussortieren#
		List<Feld> finalList = new ArrayList<Feld>();
			
		for(Feld f: rueckgabe) {
			boolean isThere = false;
			for( Feld g : besuchteFelder) {
				if(f.equals(g)) {
					isThere = true;
				}
			}
			if(!isThere) {
				finalList.add(f);
			}
		}
		
		/*	
		// Debug:
		for(Feld f : finalList) {
			System.out.println("FELD:= " + f);
		}
		*/
		// Rueckgabe
		return finalList;
	}
	
	/** ermittelt Rekursiv die komplexe Loesung des klassischen Springerproblems
	 * 
	 * @param aktuellesFeld Feld auf dem sich der Springer momentan befindet
	 * @param pfad Pfad den der Springer schon gesprungen ist
	 */	
	public void rekursivKlassisch(Feld aktuellesFeld, List<Feld> pfad) {
		pfad.add(aktuellesFeld);
		besuchteFelder.add(aktuellesFeld);
		
		//Abbruchbedingung und Variable
		if(pfad.size() == (this.felder.length * this.felder.length)) {
			//System.out.println("Volle Pfadlaenge erreicht");
			
			//Debug
			/*
			System.out.println("FINAL PATH =");
			for(Feld f: pfad) {
				System.out.println("FELD:= "+f);
			}
			*/
			this.pfad = pfad;
			this.loesungsAnzahl += 1;
			if(this.auszugebendeLoesungen > 0) {
				helpful(pfad);
				auszugebendeLoesungen -=1;
			}
			
		}	
		List<Feld> verfuegbareFelder = moeglicheFelder();
		
		if(verfuegbareFelder.isEmpty()) {
			// Springer kommt nicht weiter, gehe zureuck
			//Debug 
			/*
			System.out.println("Kommt nicht weiter bei Feld: "+ aktuellesFeld + " schiebe ihn also zureuck");
			*/
			pfad.remove(aktuellesFeld);
			besuchteFelder.remove(aktuellesFeld);
		}
		else {
			for(Feld f: verfuegbareFelder) {		
				verschiebeSpringer(f);
				//System.out.println("Verschiebe Springer auf " + f);
				rekursivKlassisch(springer.getPosition(), pfad);		
			}
			pfad.remove(aktuellesFeld);
			besuchteFelder.remove(aktuellesFeld);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/** ermittelt Rekursiv die Loesung des einfachen Springerproblems
	 *  ~ muss noch angepassat werden
	 * @param aktuellesFeld Feld auf dem sich der Springer momentan befindet
	 * @param pfad Pfad den der Springer schon gesprungen ist
	 */	
	public void rekursivEinfach(Feld aktuellesFeld, List<Feld> pfad) {
		pfad.add(aktuellesFeld);
		besuchteFelder.add(aktuellesFeld);
		List<Feld> eckfelder = ermittleEckfelder();
		boolean finishedPath = true;
	
		/*
		System.out.println("\n\n\n");
		for(Feld f : pfad) {
			System.out.print(f + " -> ");
		}
		*/
		//Abbruchbedingung und Variable
		for(Feld f : eckfelder) {
			if(!containsFeld(f,pfad)) {
				finishedPath = false;
			}
		}
		//System.out.println("\n"+finishedPath);
		
		
		if(finishedPath) {
			//System.out.println("Volle Pfadlaenge erreicht");
			
			//Debug
			/*
			System.out.println("FINAL PATH =");
			for(Feld f: pfad) {
				System.out.println("FELD:= "+f);
			}
			*/
			this.pfad = pfad;
			this.loesungsAnzahl += 1;
			if(this.auszugebendeLoesungen > 0) {
				helpful(pfad);
				auszugebendeLoesungen -=1;
			}
			pfad.remove(aktuellesFeld);
			besuchteFelder.remove(aktuellesFeld);
			
		}
		else {
			List<Feld> verfuegbareFelder = moeglicheFelder();
		
			if(verfuegbareFelder.isEmpty()) {
				// Springer kommt nicht weiter, gehe zureuck
				//Debug 
				/*
				System.out.println("Kommt nicht weiter bei Feld: "+ aktuellesFeld + " schiebe ihn also zureuck");
				*/ 
				pfad.remove(aktuellesFeld);
				besuchteFelder.remove(aktuellesFeld);
			}
			else {
				for(Feld f: verfuegbareFelder) {		
					verschiebeSpringer(f);
				//	System.out.println("Verschiebe Springer auf " + f);
					rekursivEinfach(springer.getPosition(), pfad);		
				}	
				pfad.remove(aktuellesFeld);
			besuchteFelder.remove(aktuellesFeld);
	
			}
		}	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Gibt den Erfolgreichen Pfad aus, falls er geschlossen ist, gibt es eine zusaetzliche Meldung
	 * @param pfad der auszugebende Pfad
	 */
	private void helpful(List<Feld> pfad) {
		System.out.println("\n\nPfad, der ihr Problem loest: \n");
		for(Feld f: pfad) {
			System.out.print(" --> " + f);
		}
		this.pfad = pfad;
		
		//Versuche auf besonderen Weg zu testen, Springer ist noch bei letztem Feld, noch testen!
		// Schaffe Voraussetzungen
		 besuchteFelder.remove(this.startFeld);
		 // Teste
		 if(moeglicheFelder().contains(this.startFeld)) {
		 System.out.println("Dieser Pfad ist ein geschlossener Pfad, denn es ware dem Springer moeglich, von seiner letzten Position zum Startfeld zu springen!");
		 }
		 // Negiere Voraussetzungen
		 besuchteFelder.add(this.startFeld);
	}
	private boolean containsFeld(Feld feld, List<Feld> zuUntersuchendeListe) {
		boolean rueckgabe = false;
		for(Feld f : zuUntersuchendeListe) {
			if(feld.equals(f)) {
				rueckgabe = true;
			}
			else {
				continue;
			}
		}
		return rueckgabe;
	}
	/**
	 * Verschiebt die Position des Springers
	 * @param wohin Feld, auf das der Springer verschoben wird
	 */
	public void verschiebeSpringer(Feld wohin) {
		this.springer.setPosition(wohin);
	}
	
	/**
	 * Gibt den Pfad des Springers ueber das Schachbrett zurueck
	 * @return den Pfad des Springers
	 */
	public List<Feld> getPfad() {
		return this.pfad;
	}
	public int getLoesungsAnzahl() {
		return this.loesungsAnzahl;
	}
}
