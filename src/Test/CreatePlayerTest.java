package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerFactory;

public class CreatePlayerTest {
    PlayerFactory playerFactory;
 // 5 Test Cases for createPlayer method of the PlayerFactory Class Written by Alp Akkanlar
    @BeforeEach
    void BeforeEach() {
        playerFactory = PlayerFactory.getInstance();
        playerFactory.resetPlayerNames();
        Color orange = Color.ORANGE;
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(orange);
        Color green = Color.GREEN;
        colorList.add(green);
        playerFactory.setColorList(colorList);
    }

    // Test case: Create Real Player with null name --> Black Box  This is based on the expected behavior that creating a player with a null name should throw an exception.
    @Test
    public void testCreateRealPlayerWithNullName() { 
        assertThrows(IllegalArgumentException.class, () -> playerFactory.createPlayer("Real Player", null));
    }

    // Test case: Create Real Player with unique name  Black-box. This test checks that a player can be created with a unique name and that their type is set correctly.
    @Test
    public void testCreateRealPlayerWithUniqueName() {
        Player player = playerFactory.createPlayer("Real Player", "John");
        assertEquals("John", player.getName());
        assertEquals("Real", player.getType());
    }

    // Test case: Create Computer Player  Black-box. This tests that a computer player can be created with a name and the correct type.
    @Test
    public void testCreateComputerPlayer() {
        Player player = playerFactory.createPlayer("Computer Player", "Bot");
        assertEquals("Bot", player.getName());
        assertEquals("Computer", player.getType());
    }

   // Test case: Create Real Player with empty name - WHITE-BOX
// This test case assumes the knowledge of the internal check for name length
@Test
public void testCreateRealPlayerWithEmptyName() {
    Player player = playerFactory.createPlayer("Real Player", "");
    assertNull(player);
}

// Test case: Verify color is assigned to players - WHITE-BOX
// This test case assumes the knowledge of the internal implementation that colors are assigned from a list to players.
@Test
public void testPlayerColorAssignment() {
    Player player1 = playerFactory.createPlayer("Real Player", "John");
    Player player2 = playerFactory.createPlayer("Computer Player", "Bot");

    assertEquals(Color.ORANGE, player1.getColor());
    assertEquals(Color.GREEN, player2.getColor());
}
}
