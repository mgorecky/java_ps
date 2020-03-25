import java.io.Serializable;

/**
 * Adres
 */
public class Adres implements Serializable {
	String ulica;
	int numerBudynku;
	int numerLok;
	String miasto;
	String kodPocztowy;
	
	public Adres(String ulica, int numerBudynku, int numerLok, String miasto, String kodPocztowy){
		this.ulica = ulica;
		this.numerBudynku = numerBudynku;
		this.numerLok = numerLok;
		this.miasto = miasto;
		this.kodPocztowy = kodPocztowy;
	}

	public String toString(){
		return "Adres w pamięci: " + super.toString() + "\n" +
				"Ulica[" + this.ulica + "] nr/lok[" + this.numerBudynku + "/" + this.numerLok + "]\n" +
				"Miasto[" + this.miasto + "] Kod[" + this.kodPocztowy + "]";
	}
}
