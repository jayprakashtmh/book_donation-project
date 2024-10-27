package jay.common;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import jakarta.servlet.http.Part;

public class Image {
	public String saveImage(Part p) {
		String[] d = p.getContentType().split("/");
		String name = UUID.randomUUID().toString() + "." + d[1];
		String path = ImagePath.PATH + name;
		try (FileOutputStream fos = new FileOutputStream(path); InputStream is = p.getInputStream()) {

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
