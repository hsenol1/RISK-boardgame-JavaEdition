package Test;

import ConKUeror.domain.model.Player.PlayerFactory;
import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Player.Player;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RepOKTest {

    static BuildMode buildMode;
    static PlayerFactory playerFactory;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting the test for BuildMode class");
        buildMode = new BuildMode();
        playerFactory = PlayerFactory.getInstance();
        List<Color> playerColors = new ArrayList<Color>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            playerColors.add(new Color(red, green, blue));
        }
        
        
        playerFactory.setColorList(playerColors);
    }

    @Test
    void testRepOkWithNoPlayers() {
        assertTrue(buildMode.repOK(), "repOK should return true for empty player list");
    }

    @Test
    void testRepOkWithValidPlayerCount() {
        List<Player> players = new ArrayList<>();
        players.add(playerFactory.createPlayer("Real Player", "Player 1"));  
        players.add(playerFactory.createPlayer("Real Player", "Player 2"));
        assertTrue(buildMode.repOK(), "repOK should return true for valid player count");
    }

    @Test
    void testRepOkWithMaxPlayerCount() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            players.add(playerFactory.createPlayer("Real Player", "Player" + (i+1)));  
        }
        assertTrue(buildMode.repOK(), "repOK should return true for maximum player count");
    }
    @Test
    void testRepOkWithExceededPlayerCount() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Player player = null;
            try {
                player = playerFactory.createPlayer("Real Player", "Player" + (i+1));
            } catch (IndexOutOfBoundsException e) {
                
            }
            if (player != null) {
                players.add(player);
            }
        }
    
        assertFalse(buildMode.repOK(), "repOK should return false for exceeded player count");
    }


        @Test
    void testRepOkWithNullPlayerList() {
        List<Player> players = null;
        assertFalse(buildMode.repOK(), "repOK should return false for null player list");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished the test for BuildMode class");
    }

}