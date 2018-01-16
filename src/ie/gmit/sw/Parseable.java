package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Parseable {

	//the methods declaration must be implemented by concrete class
	public void encrypt(String key)throws FileNotFoundException, IOException;
	public void decrypt(String key)throws FileNotFoundException, IOException;
	
}
