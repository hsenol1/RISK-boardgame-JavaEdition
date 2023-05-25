package Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import ConKUeror.domain.controller.GameHandler;
import ConKUeror.domain.model.Data.FileGameDataAdapter;
import ConKUeror.domain.model.Data.GameData;
import ConKUeror.domain.model.Data.GameDataAdapter;
import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Data.PlayerData;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerFactory;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SaveTest {
    private GameHandler gameHandler;
    private GameData gameData;
    private FileGameDataAdapter fileGameDataAdapter;
    private List<Player> playerList;
    private String filename = "test.txt";
    private GameState gameState;
    private List<PlayerData>playerDataList;
    static PlayerFactory playerFactory;
    static Player player1;
    static Player player2;
    static Player player3;
    static Player player4;
    static Player player5;
    
    @BeforeEach
    void setUp() {
        playerList = new ArrayList<>();
        playerDataList = new ArrayList<>();
        gameState = new GameState("turn", "mapState");
        playerFactory = PlayerFactory.getInstance();
        List<Color> playerColors = new ArrayList<Color>();
        Random random = new Random();
            for(int i= 0 ; i<5 ; i++)  {
                int red = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for red
                int green = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for green
                int blue = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for blue

                Color color =  new Color(red, green, blue);
                playerColors.add(color);
            }
          
            playerFactory.setColorList(playerColors);
        
        player1 = playerFactory.createPlayer("Real Player", "Player 1");
        player2 = playerFactory.createPlayer("Real Player", "Player 2");
        player3 = playerFactory.createPlayer("Real Player", "Player 3");
        player4 = playerFactory.createPlayer("Real Player", "Player 4");
        player5 = playerFactory.createPlayer("Computer Player", "Comp.Player 5");
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5); 
        for(Player player:playerList){
            playerDataList.add(new PlayerData(player));
        }
        gameHandler = GameHandler.getInstance();
        gameData = new GameData(gameState, playerDataList);
        fileGameDataAdapter = new FileGameDataAdapter(gameHandler) ;
        
        
    }

    @Test
    void testSaveGame() throws IOException {
        
        gameHandler.saveGame(gameData, filename, fileGameDataAdapter);

        GameData loadedGameData = gameHandler.loadGame(filename, playerList, fileGameDataAdapter);
        GameState loadedGameState = loadedGameData.getGameState();
        List<PlayerData> loadedPlayerDataList = loadedGameData.getPlayerDataList();
    
        
        assertEquals(gameData.getGameState(), loadedGameState, "Loaded game state should match original game state");
        assertEquals(gameData.getPlayerDataList(), loadedPlayerDataList, "Loaded player data list should match original player data list");
    }
    @AfterAll
    static void afterAll() {
    System.out.println("Cleaning up after all tests...");

   

    System.out.println("All tests have finished");
}
}
