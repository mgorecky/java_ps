import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * PlikiZip
 */
public class PlikiZip {
	public void GenerateZIPFile(File[] files, String zipName, Path destPath) throws IOException{
		if (files.length == 0)
			return;

		if (Files.exists(destPath.resolve(zipName))) {
			System.out.println("Podany plik archiwum istnieje");
			return;
		}

		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destPath.resolve(zipName).toString()));
		//zipOut.setLevel(9);
		for (File f : files){
			ZipEntry zipE = new ZipEntry(f.getName());
			zipOut.putNextEntry(zipE);
			FileInputStream fileInputStream = new FileInputStream(f);
			
			byte[] buffor = new byte[1024];
			int len;

			while((len = fileInputStream.read()) >= 0)
				zipOut.write(buffor, 0, len);

			fileInputStream.close();
			zipOut.closeEntry();
		}
		zipOut.close();
	}
}
