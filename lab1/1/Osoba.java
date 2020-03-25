import java.io.Serializable;

/**
 * Osoba
 */
public class Osoba implements Serializable {
	String imie;
	String nazwisko;
	Adres adresOsoby;

	public Osoba(String imie, String nazwisko, Adres adresZamledowania){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adresOsoby = adresZamledowania;

		System.out.println("Dodano nową osobę");
	}

	@Override
	public String toString() {
		return "Adres w pamięci: " + super.toString() + "\n" +
				"Imie[" + this.imie + "] Nazwisko[" + this.nazwisko + "]\n" +
				"Miasto[" + this.adresOsoby + "]";
	}
	
}
