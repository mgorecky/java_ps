import java.io.*;

/**
 * SerializacjaDanych
 */
public class SerializacjaDanych {
	public SerializacjaDanych() { }

	public void GenerateSerializableFile(){
		Adres adres = new Adres("Kwiatowa", 1, 12, "Kraków", "30-000");
		Osoba osoba1 = new Osoba("Ewa", "Kowalska", adres);
		Osoba osoba2 = new Osoba("Jan", "Kowalski", adres);

		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("Osoby.dat"));
			objOut.writeObject(osoba1);
			objOut.writeObject(osoba2);
			objOut.flush();
			objOut.close();
			System.out.println("Dane zostały zapisane w pliku");
		} catch(IOException e){
			e.printStackTrace();
		}

	}	
}
