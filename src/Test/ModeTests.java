package Test;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ConKUeror.domain.controller.CardController;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Board.Die;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Modes.StartMode;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.PlayerFactory;

class ModeTests {

    static BuildMode bMode = new BuildMode();
    static StartMode sMode = new StartMode(bMode);
    static Board board = new Board();
    static GameLogic game = new GameLogic(board , sMode);
    static Player player ;
    static PlayerFactory playerFactory;
    static PlayerExpert pExpert;

    @BeforeAll
    static void beforeAll() {

        playerFactory = PlayerFactory.getInstance();
        Color orange = Color.ORANGE;
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(orange);
        playerFactory.setColorList(colorList);
        player = playerFactory.createPlayer("Real Player", "Player 1");
        PlayerExpert.addPlayersList(player);
        PlayerExpert.setPlayerInTurn(player);

    }
    /*
        * Effects: Check the condition if bot number is bigger than total players number.
        *
    */
    @Test
    void testBotPlayerIsBiggerThanTotalPlayer() {


        int totalPlayerNumber = 1;
        int botPlayerNumber = 2;
        Boolean valid = bMode.validatePlayerNums(totalPlayerNumber,botPlayerNumber);
        assertFalse(valid,"Bot player number should be lower than total player ");

    }

      /*
        * Effects: Check if build mode's number is valid
        *
    */
    @Test
     void testValidBuildModeInitalization() {

        int totalPlayerNumber = 5;
        int botPlayerNumber = 2;
        Boolean expected = true;
        Boolean actual = bMode.validatePlayerNums(totalPlayerNumber,botPlayerNumber);
        assertEquals(expected, actual,"Bot player number should be lower than total player ");


}





    @Test
     void validateBuildMode() {
     assertTrue(bMode.repOK(),"Build state is invalid");
}


/**
 * Test case for deploying 5 infantry units.
 *
 * <p>Requires: {player} instance.
 * Modifies: Territory's army and player Inventory
 * Effects: 5 Infantry deployed to territory.</p>
 */
    @Test
    public void deploy5Infantry() {

    Territory t = new Territory(1);

    int beforeDeploy = t.getTotalUnit();

    int fiveArmy = 5;

    player.getInventory().addInfantries(fiveArmy);
    player.deploy(t, fiveArmy);

    int afterDeploy = t.getTotalUnit();
    int deployedInfantryCount = afterDeploy-beforeDeploy;

    assertEquals(fiveArmy, deployedInfantryCount,"5 army deployed ");



}


@Test
public void testFortify() {





}



    @AfterAll
    static void afterAll() {
        System.out.println("Tests are finished");
    }




}


