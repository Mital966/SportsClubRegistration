package tech.csm.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FIleUpload {
	
	static File file = null;
	public static String UploadFile(MultipartFile multiPartFile) {
		try {
			byte[] b = multiPartFile.getInputStream().readAllBytes();
			file = new File("d:/Downloads/"+multiPartFile.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file.getName();
	}

}
