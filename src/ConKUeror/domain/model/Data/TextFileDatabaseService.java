package ConKUeror.domain.model.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TextFileDatabaseService implements Serializable {
	GameState gamestate;
	String fileName = "data.txt";
	

	public TextFileDatabaseService() {
		
	}
	
	
	public void write(GameState gamestate) throws FileNotFoundException, IOException {
		this.gamestate =gamestate;		
		 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
		        oos.writeObject(gamestate);
		    }
		
		
	}
	
	public GameState read() throws IOException, ClassNotFoundException {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
	        return (GameState) ois.readObject();
	    }
	}
}
