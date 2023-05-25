package ConKUeror.domain.model.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ConKUeror.domain.model.Data.GameData;
import ConKUeror.domain.model.Player.Player;

public interface GameDataAdapter {
    void saveGameData(GameData gameData, String filename) throws IOException;
    GameData loadGameData(String filename, List<Player> playerList) throws FileNotFoundException; 
}
