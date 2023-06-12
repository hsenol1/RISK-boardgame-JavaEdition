package ConKUeror.domain.model.Data;

import java.io.IOException;

import ConKUeror.domain.model.Data.ISaveLoadAdapter;

public class TextFileServiceAdapter implements ISaveLoadAdapter {

	
	private TextFileDatabaseService txtService;
	private GameState gameState;
	public TextFileServiceAdapter() {
		txtService = new TextFileDatabaseService();
		System.out.println("Using Text File Database");
	}
	@Override
	public void save(GameState gameState) {
		// TODO Auto-generated method stub
		try {
			txtService.write(gameState);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Save de hata var");
			e.printStackTrace();
		}
		
	}

	@Override
	public GameState load() {
		// TODO Auto-generated method stub
		try {
			 gameState =txtService.read();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Load da hata var");
			e.printStackTrace();
		}
		return gameState;
	}
	
	
	
}
