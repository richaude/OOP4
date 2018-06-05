package springerproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	private int dimension;
	private Feld startFeld;
	private boolean modus; //true fuer klassisch, false fuer einfach
	
	public Input() {
	}
	
	public int leseGroesse() {
		boolean weitermachen = true;
		do {
			String antwort = new String("");
			System.out.println("Bitte eine Zahl fuer die Seitenlaenge des Schachbretts eingeben:\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				antwort = br.readLine().toLowerCase();
				dimension = Integer.parseInt(antwort);
				if ((dimension>26)||(dimension<1)) {
					System.out.println("Diese Dimension macht die Schachnotation unmoeglich! Bitte nochmal eingeben:\n");
					continue;
				}
				weitermachen = false;
			} catch (IOException e) {
				System.out.println("Mit der Eingabe ging etwas schief! Bitte nochmal versuchen.\n");
				continue;
			} catch (NumberFormatException ne) {
				System.out.println("Es wurde keine valide Nummer eingegeben. Bitte nochmal versuchen.\n");
				continue;
			}
		} while (weitermachen);
		return dimension;
	}
	
	public Feld leseStartfeld() {
		boolean weitermachen = true;
		do {
			String antwort = new String("");
			System.out.println("Bitte das Startfeld in Schachnotation eingeben (ein Buchstabe, direkt gefolgt von einer Zahl, ohne Leerzeichen dazwischen).\nBuchstabe und Zahl muessen beide innerhalb der zuvor eingegebenen Dimension liegen:\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				antwort = br.readLine().toLowerCase();
				if (antwort.length() >= 2) {
					String buchstabe = antwort.substring(0, 1);
					char x = buchstabe.charAt(0);
					if ((int) x > (96+dimension)) {
						System.out.println("Die Position des eingegebenen Buchstaben im Alphabet ist groesser als die zuvor eingegebene Dimension. Bitte nochmal das Startfeld eingeben.\n");
						continue;
					}
					String zahl = antwort.substring(1, antwort.length());
					int y = Integer.parseInt(zahl);
					if (y > dimension) {
						System.out.println("Der Wert der eingegebenen Zahl ist groesser als die zuvor eingegebene Dimension des Schachfelds. Bitte nochmal das Startfeld eingeben.\n");
						continue;
					}
					startFeld = new Feld(Character.toUpperCase(x), y);
					weitermachen = false;
				} else {
					System.out.println("Es ist keine Eingabe in valider Schachnotation erfolgt. Bitte nochmal versuchen.\n");
					continue;
				}
			} catch (IOException e) {
				System.out.println("Mit der Eingabe ging etwas schief! Bitte nochmal versuchen.\n");
				continue;
			} catch (NumberFormatException ne) {
				System.out.println("Es wurde keine valide Zahl eingegeben. Nur das erste Zeichen der Eingabe darf ein Buchstabe sein. Leerzeichen zwischen Zahl und Buchstabe bitte auch vermeiden.\nBitte nochmal das Startfeld in Schachnotation eingeben.\n");
				continue;
			}
		} while (weitermachen);
		return startFeld;
	}
	
	public boolean leseModus() {
		boolean weitermachen = true;
		do {
			String antwort = new String("");
			System.out.println("Bitte den Modus fuer die Rekursion eingeben: 'k' steht fuer klassisch, 'e' steht fuer einfach:\n");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				antwort = br.readLine().toLowerCase();
				if (antwort.equals("k")) {
					modus = true;
					System.out.println("Modus fuer die Rekursion: Klassisch.\n");
					weitermachen = false;
				}
				else if (antwort.equals("e")) {
					modus = false;
					System.out.println("Modus fuer die Rekursion: Einfach.\n");
					weitermachen = false;
				} else {
					System.out.println("Es gab eine ungueltige Eingabe. Bitte nur k oder e verwenden.\n");
					continue;
				}
			} catch (IOException e) {
				System.out.println("Mit der Eingabe ging etwas schief! Bitte nochmal versuchen.\n");
				continue;
			}
		} while (weitermachen);
		return modus;
	}
	
	public int leseLoesungen() {
		boolean weitermachen = true;
		int loesungen = 0;
		do {
			System.out.println("Bitte die Anzahl der zu ermittelnden Loesungen eingeben:\n");
			String antwort = new String("");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				antwort = br.readLine().toLowerCase();
				loesungen = Integer.parseInt(antwort);
				weitermachen = false;
			} catch (IOException e) {
				System.out.println("Etwas ging mit der Eingabe schief, bitte nochmal versuchen.\n");
				continue;
			} catch (NumberFormatException ne) {
				System.out.println("Es wurde keine valide Zahl eingegeben. Bitte nochmal versuchen.\n");
				continue;
			}
		} while (weitermachen);
		return loesungen;
	}

}
