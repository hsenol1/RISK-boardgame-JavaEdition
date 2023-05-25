package ConKUeror.domain.model.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.model.Data.GameData;
import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Data.PlayerData;
import ConKUeror.domain.model.Player.Player;

public class FileGameDataAdapter implements GameDataAdapter {
    private GameHandler gameHandler;

    public FileGameDataAdapter(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    @Override
    public void saveGameData(GameData gameData, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(gameData.getGameState());
            for (PlayerData playerData : gameData.getPlayerDataList()) {
                out.println(playerData);
            }
        }
    }

    @Override
    public GameData loadGameData(String filename, List<Player> playerList) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            GameState gameState = GameState.fromString(scanner.nextLine());

            List<PlayerData> playerDataList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                PlayerData playerData = PlayerData.fromString(scanner.nextLine(), playerList);
                if (playerData != null) {
                    playerDataList.add(playerData);
                } 
            }
            return new GameData(gameState, playerDataList);
        }
    } 
}