package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Player.PlayerFactory;
import ConKUeror.domain.model.Board.Coordinate;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BuildModeTest {

    BuildMode buildMode;
    PlayerFactory playerFactory;
    List<Color> playerColors;
    @BeforeEach
    void setUp() {
        playerFactory = PlayerFactory.getInstance();
        playerColors = new ArrayList<Color>();
        Random random = new Random();
            for(int i= 0 ; i<5 ; i++)  {
                int red = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for red
                int green = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for green
                int blue = random.nextInt(256); // Generate a random value between 0 (inclusive) and 256 (exclusive) for blue

                Color color =  new Color(red, green, blue);
                playerColors.add(color);
            }
          
            playerFactory.setColorList(playerColors);
        buildMode = new BuildMode();
    }

    @Test
    void testRepOkOnCreation() {
      
        assertTrue(buildMode.repOK());
    }

    @Test
    void testPlayerCountOnCreation() {
        assertEquals(0, buildMode.getPlayerCount());
    }

    @Test
    void testInitalizePlayer() {
        buildMode.initalizePlayer("TestPlayer", "Real Player");
        assertEquals(1, buildMode.getPlayerCount());
        assertTrue(buildMode.repOK());
    }

    @Test
    void testInitalizeColoredPlayer() {
        buildMode.initalizeColoredPlayer("TestPlayer", "Real Player", Color.RED);
        assertEquals(1, buildMode.getPlayerCount());
        assertTrue(buildMode.repOK());
    }

    @Test
    void testRepOkWithMaxPlayers() {
        for (int i = 0; i < 6; i++) {
            buildMode.initalizePlayer("TestPlayer" + i, "Real Player");
        }
        assertEquals(6, buildMode.getPlayerCount());
        assertFalse(buildMode.repOK());
    }

    @Test
    void testValidatePlayerNums() {
        assertTrue(buildMode.validatePlayerNums(5, 2));
    }

    @Test
    void testValidatePlayerNumsWithInvalidInput() {
        assertFalse(buildMode.validatePlayerNums(5, 7));
    }
}
