package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ConKUeror.domain.controller.ButtonHandler;
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
        board = new Board();
        buildMode = new BuildMode();
        startMode = new StartMode(buildMode);
        gameLogic = new GameLogic(board, startMode);
        buttonHandler = ButtonHandler.getInstance(buildMode, gameLogic);
    }


    /*
     * whitebox
     */
    @Test
    public void testMaximumArmyCounts()
    {
        Territory territoryOne = new Territory(1);
        Territory territoryTwo = new Territory(2);

        territoryOne.addInfantries(5);
        territoryTwo.addInfantries(10);

        // gameLogic.addToMemory(territoryOne);
        // gameLogic.addToMemory(territoryTwo);

        // buttonHandler.increaseArmyCount();

        assertEquals("The maximum infantry number should be 5", 5, territoryOne.getArmy().getTotalArmyUnit(), 0);
        assertEquals("The maximum infantry number should be 10", 10, territoryTwo.getArmy().getTotalArmyUnit(), 0);
    }

    //@Test

    
}
