import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

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
		Path startLocation = p.FindStartLocalization();

		File[] temp = p.GetAllFiles(startLocation);
		try{
			p.MoveFile(startLocation.getParent(), "katalog", temp);
		} catch (IOException e){
			e.printStackTrace();
		}
	}	
}
