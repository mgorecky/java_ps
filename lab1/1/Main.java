/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		/*
		SerializacjaDanych sd = new SerializacjaDanych();
		sd.GenerateSerializableFile();	
		sd.ReadSerializableFile();
		*/

		Pliki p = new Pliki();
		System.out.println(p.FindStartLocalization());
	}	
}
