import java.io.File;
import java.nio.file.Path;

/**
 * Pliki
 */
public class Pliki {
	public void Pliki() {
	}

	public Path FindStartLocalization() {
		File f = new File("temp");
		//System.out.println(f.toPath().toAbsolutePath());
		return f.toPath().toAbsolutePath();
	}

	public File[] GetAllFiles(Path location) {
		//System.out.println(location.getParent());
		File[] tempFiles = location.getParent().toFile().listFiles();
		for (File f : tempFiles){
			if (f.isFile())
				System.out.println(f.getName());
		}

		return null;
	}
	
}