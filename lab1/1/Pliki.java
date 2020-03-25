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
	
}