import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Pliki
 */
public class Pliki {
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
			//GetFileInfo(f);
		}

		return tempFiles;
	}

	public void MoveFile(Path fromPath, String toPath, File[] files) throws IOException{
		Path destLocation = fromPath.resolve(toPath);
		System.out.println(destLocation.toString());

		for (File f : files){
			Files.copy(fromPath.resolve(f.getName()), destLocation.resolve(f.getName()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Przenosze plik do: " + destLocation.resolve(f.getName()));
		}
	}

	public void GetFileInfo(File file) {
		System.out.println("Nazwa: " + file.getName());
		System.out.println("Root: " + file.toPath().getRoot());
		System.out.println("Liczba podkatakogów: " + file.toPath().getNameCount());
		System.out.println("Wielkość (B): " + file.length());
		System.out.println("Czy można wykonać: " + file.canExecute());
		System.out.println("Rozmiar dysku: " + file.getTotalSpace());
	}	
}
