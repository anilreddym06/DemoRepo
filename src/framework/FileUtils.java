package framework;

import java.io.File;

public class FileUtils {
	
	
	public static boolean checkforfile(String filepath) {
		File f=new File(filepath);
		if(f.exists()) {
			return true;
			
		}else {
			return false;
		}
	}
	
	
	public static String getFilExtenion(String filepath) {
		String extension="";
		if(checkforfile(filepath)) {
			File f=new File(filepath);
			if(f.isFile()) {
				String filename=f.getName();
				String[]names=filename.split("\\.");
				extension=names[names.length-1];
				
			}else {
				System.out.println("Given path:"+filepath+"is not a valid file");
			}
			
		}else {
			System.out.println("No file exist in given path:"+filepath);
		}
		return extension;
	}
	
				
}


