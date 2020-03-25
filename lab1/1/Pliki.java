import java.io.File;
import java.io.FilenameFilter;
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
		File[] tempFiles = location.getParent().toFile().listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".dat");
			}
		});
		for (File f : tempFiles){
			System.out.println(f.getName());
		}

		return null;
	}
	
}