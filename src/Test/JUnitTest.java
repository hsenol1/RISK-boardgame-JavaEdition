package Test;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ConKUeror.domain.controller.CardController;
import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Board.Die;
import ConKUeror.domain.model.Player.PlayerFactory;

class JUnitTest {

    Die dice;
    CardController cardController;
    PlayerFactory playerFactory;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting the pile of tests:");
    }



    @Test
    void testDiceRoller() { // huseyin test1
        dice = Die.getDieInstance();
        dice.rollDie();
        int result = dice.getFaceValue();

        assertEquals(true, result >= 1 && result <= 6, "Result must be between 1-6 both included!");

    }


    @Test
    void checkPlayerNameValid() {
        playerFactory = PlayerFactory.getInstance();
        assertThrows(IllegalArgumentException.class, () -> playerFactory.createPlayer("Real Player", null), "If name is null, throws error!");



    }
    @AfterAll
    static void afterAll() {
        System.out.println("Test is finished");
    }




}