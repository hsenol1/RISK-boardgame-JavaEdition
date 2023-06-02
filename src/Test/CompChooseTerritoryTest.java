package Test;
import static org.junit.jupiter.api.Assertions.*;


import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConKUeror.domain.enums.GameMode;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Modes.StartMode;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.PlayerFactory;

public class CompChooseTerritoryTest {
    BuildMode bMode;
    StartMode sMode;
    Board board;
    GameLogic game;


     Player realPlayer;
     Player computerPlayer;
    static Player playerInTurn;

    static PlayerFactory playerFactory;
    static PlayerExpert pExpert;

    @BeforeEach
     void BeforeEach() {
         bMode = new BuildMode();
         sMode = new StartMode(bMode);
         board = new Board();
         game = new GameLogic(board , sMode);



        playerFactory = PlayerFactory.getInstance();
        Color orange = Color.ORANGE;
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(orange);
        Color green = Color.GREEN;
        colorList.add(green);
        playerFactory.setColorList(colorList);

        computerPlayer = playerFactory.createPlayer("Computer Player", "Player 1");
        realPlayer = playerFactory.createPlayer("Real Player", "Player 2");

        PlayerExpert.addPlayersList(computerPlayer);
        PlayerExpert.addPlayersList(realPlayer);
        List<Player> orderList = new ArrayList<>();
        orderList= PlayerExpert.getPlayersList();
        game.setGameOrderList(orderList);
        playerFactory.colorIndex=0;

        //PlayerExpert.setPlayerInTurn(computerPlayer);
       // playerInTurn = PlayerExpert.getPlayerInTurn();

    }
    @Test
    public void chooseTerritoryComputerOwned() throws InterruptedException {
    game.setPlayerInTurn(computerPlayer);
    computerPlayer.inv.addInfantries(1);

    Territory territory = new Territory(0);
    territory.setOwner(computerPlayer);
    territory.addInfantries(1);
    computerPlayer.getInventory().addTerritory(territory);
    int oldInfantrySize = territory.getTotalUnit();
    System.out.println("oldInfantrySize");
    System.out.println(oldInfantrySize);
    game.computerChoosesTerritory();
    int newInfantrySize = territory.getTotalUnit();
    System.out.println("newInfantrySize");

    System.out.println(newInfantrySize);

    assertTrue(oldInfantrySize < newInfantrySize);
}

@Test
public void chooseUnoccupiedTerritory() throws InterruptedException {
    game.setPlayerInTurn(computerPlayer);
    computerPlayer.inv.addInfantries(1);
    board.initAllTerritoriesAndContinents();
    game.setGameMode(GameMode.BUILD);
    game.moveToOtherPhase();


    game.computerChoosesTerritory();
    Territory territory = computerPlayer.getInventory().getOwnedTerritories().get(0);

    assertEquals(computerPlayer, territory.getOwner());

}
@Test
public void testNoArmy() throws InterruptedException {
    // Redirecting System.out to capture the print statements
    game.setPlayerInTurn(computerPlayer);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    game.computerChoosesTerritory();
    assertEquals("Computer Player doesnt have army to choose a territory.\n", outContent.toString());
}

@Test
public void testRealPlayer() throws InterruptedException {

    game.setPlayerInTurn(realPlayer);

    // Redirecting System.out to capture the print statements
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    game.computerChoosesTerritory();
    assertEquals("This is Real Player. Something is not right.\n", outContent.toString());
}






}
