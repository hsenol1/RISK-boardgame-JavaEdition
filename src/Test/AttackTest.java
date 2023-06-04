package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import ConKUeror.UI.Panels.AttackingArmyPanel;
import ConKUeror.domain.controller.ButtonHandler;
import ConKUeror.domain.model.Army.Artillery;
import ConKUeror.domain.model.Army.Cavalry;
import ConKUeror.domain.model.Army.Infantry;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Modes.StartMode;

public class AttackTest {

    static Board board;
    static StartMode startMode;
    static GameLogic gameLogic;
    static BuildMode buildMode;
    static ButtonHandler buttonHandler;

    @BeforeEach
    static void beforeEach()
    {
        board = null;
        buildMode = new BuildMode();
        startMode = new StartMode(buildMode);
        gameLogic = null;
        buttonHandler = null;
    }

    /*
     * blackbox
     * a slider opens and infantry number is chosen
     * for this test 5 infantries should be chosen
     * test doesn't know how cavalries are added to the list
     */
    @Test
    public void testChosenInfantryCount()
    {
        Territory territoryOne = new Territory(1);

        territoryOne.getArmy().addInfantries(7);

        try
        {
            gameLogic.memory[0] = territoryOne;
            buttonHandler.increaseArmyCount();
        }
        catch (Exception e)
        {
            gameLogic = new GameLogic(board, startMode);
            buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);
            gameLogic.memory[0] = territoryOne;
            buttonHandler.increaseArmyCount();
        }

        assertEquals("The chosen infantry number should be 5", 5, buttonHandler.getAttackingInfantries().size(), 0);
    }

    /*
     * blackbox
     * a slider opens and cavalry number is chosen
     * for this test 7 cavalries should be chosen
     * test doesn't know how cavalries are added to the list
     */
    @Test
    public void testChosenCavalryCount()
    {
        Territory territoryTwo = new Territory(2);

        territoryTwo.getArmy().addCavalries(10);

        try
        {
            gameLogic.memory[0] = territoryTwo;
            buttonHandler.increaseArmyCount();
        }
        catch (Exception e)
        {
            gameLogic = new GameLogic(board, startMode);
            buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);
            gameLogic.memory[0] = territoryTwo;
            buttonHandler.increaseArmyCount();
        }

        assertEquals("The chosen cavalry number should be 7", 7, buttonHandler.getAttackingCavalries().size(), 0);
    }

    /*
     * blackbox
     * a slider opens and artillery number is chosen
     * for this test 4 artilleries should be chosen
     * test doesn't know how artilleries are added to the list
     */

    @Test
    public void testChosenArtilleryCount()
    {
        Territory territoryThree = new Territory(3);

        territoryThree.getArmy().addArtilleries(5);

        try
        {
            gameLogic.memory[0] = territoryThree;
            buttonHandler.increaseArmyCount();
        }
        catch (Exception e)
        {
            gameLogic = new GameLogic(board, startMode);
            buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);
            gameLogic.memory[0] = territoryThree;
            buttonHandler.increaseArmyCount();
        }

        assertEquals("The chosen artillery number should be 4", 4, buttonHandler.getAttackingArtilleries().size(), 0);
    }


    /*
     * glassbox test
     * this test checks whether units are added to the lists correctly
     */
    @Test
    public void testAddAttackingUnitsCorrectly()
    {

        GameLogic gameLogic = new GameLogic(board, startMode);

        Territory territory = new Territory(10);
        territory.addInfantries(10);
        territory.getArmy().addCavalries(5);
        territory.getArmy().addArtilleries(4);

        gameLogic.memory[0] = territory;

        ButtonHandler buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);

        buttonHandler.increaseArmyCount();

        List<Infantry> attackingInfantries = buttonHandler.getAttackingInfantries();
        List<Cavalry> attackingCavalries = buttonHandler.getAttackingCavalries();
        List<Artillery> attackingArtilleries = buttonHandler.getAttackingArtilleries();
    
        int expectedInfantryValue = 10;
        int expectedCavalryValue = 5;
        int expectedArtilleryValue = 4;
    
        // Verify the number of attacking units
        assertEquals(expectedInfantryValue, attackingInfantries.size());
        assertEquals(expectedCavalryValue, attackingCavalries.size());
        assertEquals(expectedArtilleryValue, attackingArtilleries.size());
    
        // Verify the correctness of the added attacking units
        int infantryCount = 0;
        for (Infantry infantry : attackingInfantries) {
            assertTrue(gameLogic.memory[0].getArmy().getInfantryList().contains(infantry));
            infantryCount++;
        }
        assertEquals(expectedInfantryValue, infantryCount);
    
        int cavalryCount = 0;
        for (Cavalry cavalry : attackingCavalries) {
            assertTrue(gameLogic.memory[0].getArmy().getCavalryList().contains(cavalry));
            cavalryCount++;
        }
        assertEquals(expectedCavalryValue, cavalryCount);
    
        int artilleryCount = 0;
        for (Artillery artillery : attackingArtilleries) {
            assertTrue(gameLogic.memory[0].getArmy().getArtilleryList().contains(artillery));
            artilleryCount++;
        }
        assertEquals(expectedArtilleryValue, artilleryCount);
    }

    /*
     * glassbox test
     * this test checks whether maximum number of army units are exceeded when choosing
     */
    @Test
    public void testChoosingMoreThanAvailableUnits()
    {
        GameLogic gameLogic = new GameLogic(board, startMode);

        Territory territory = new Territory(10);
        territory.addInfantries(10);
        territory.getArmy().addCavalries(5);
        territory.getArmy().addArtilleries(4);

        gameLogic.memory[0] = territory;
    
        ButtonHandler buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);

        buttonHandler.increaseArmyCount();
    
        List<Infantry> attackingInfantries = buttonHandler.getAttackingInfantries();
        List<Cavalry> attackingCavalries = buttonHandler.getAttackingCavalries();
        List<Artillery> attackingArtilleries = buttonHandler.getAttackingArtilleries();
    
        int maxInfantryValue = 10;
        int maxCavalryValue = 5;
        int maxArtilleryValue = 7;
    
        assertTrue(attackingInfantries.size() <= maxInfantryValue);
        assertTrue(attackingCavalries.size() <= maxCavalryValue);
        assertTrue(attackingArtilleries.size() <= maxArtilleryValue);
    }

    
}


