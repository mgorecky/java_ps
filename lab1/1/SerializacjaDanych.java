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
	
	public void ReadSerializableFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("Osoby.dat"));
			Osoba osoba3 = (Osoba)objIn.readObject();
			Osoba osoba4 = (Osoba)objIn.readObject();
			objIn.close();

			System.out.println(osoba3.toString());
			System.out.println(osoba4.toString());
		} catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
