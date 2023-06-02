package Test;
import static org.junit.jupiter.api.Assertions.*;


import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
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



    /*
    *This test is for computerChoosesTerritory() method,
    *that simulates a behavior of computer player in territory selection on the start mode of the game.
    *There are total 3 BLACKBOX, 2 WHITEBOX test cases.
    *This test cases is written by BATUHAN ARAT.
    */
public class CompChooseTerritoryTest {


    BuildMode bMode;
    StartMode sMode;
    Board board;
    GameLogic game;


    Player realPlayer;
    Player computerPlayer;
    Player playerInTurn;

    PlayerFactory playerFactory;



    @BeforeEach
    void BeforeEach() {

            bMode = new BuildMode();
            sMode = new StartMode(bMode);
            board = new Board();
            game = new GameLogic(board , sMode);



            playerFactory = PlayerFactory.getInstance();
            playerFactory.resetPlayerNames();
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



    }


    /*
    *This is a GLASSBOX (WHITEBOX) test.
    *It test the path of territory selection from already owned territory.
    *This case happens when all of the territories are already captured.
    */

    @Test
    public void chooseTerritoryComputerOwned() throws InterruptedException {

            game.setPlayerInTurn(computerPlayer);
            computerPlayer.inv.addInfantries(1);
            Territory territory = new Territory(0);
            territory.setOwner(computerPlayer);
            territory.addInfantries(1);
            computerPlayer.getInventory().addTerritory(territory);
            int oldInfantrySize = territory.getTotalUnit();
            game.computerChoosesTerritory();
            int newInfantrySize = territory.getTotalUnit();


            assertTrue(oldInfantrySize < newInfantrySize);
}


    /*
    *This is a GLASSBOX (WHITEBOX) test.
    *It test the path of territory selection from uncaptured territories are still present.
    */

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

    /*
     * This is a BLACKBOX test.
     * It test for player is in Real Player instead of Computer Player.
    */

    @Test
    public void testRealPlayer() throws InterruptedException {


            game.setPlayerInTurn(realPlayer);
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            game.computerChoosesTerritory();

            assertEquals("This is Real Player. Something is not right.\n", outContent.toString());
    }

    /*
     * This is a BLACKBOX test.
     * It test for player has no army to capture a territory.
    */

    @Test
    public void testNoArmy() throws InterruptedException {

            game.setPlayerInTurn(computerPlayer);
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            game.computerChoosesTerritory();

            assertEquals("Computer Player doesnt have army to choose a territory.\n", outContent.toString());
    }
    /*
     * This is a BLACKBOX test.
     * It test for player switch after computer player made its move.
     */

    @Test
    public void testPlayerSwitchAfterChoosingTerritory() throws InterruptedException {

            game.setPlayerInTurn(computerPlayer);
            computerPlayer.inv.addInfantries(1);
            board.initAllTerritoriesAndContinents();
            game.setGameMode(GameMode.BUILD);
            game.moveToOtherPhase();
            game.computerChoosesTerritory();
            Player currentPlayer = game.getPlayerInTurn();

            assertEquals(realPlayer, currentPlayer);
    }


    @AfterAll
    static void afterAll() {
        System.out.println("Tests are finished");
    }






}
