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
import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Board.Die;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerFactory;

class JUnitTest {

    static Die dice;
    static CardController cardController;
    static PlayerFactory playerFactory;
    static List<Player> playerList;
    static Player player1;
    static Player player2;
    static Player player3;
    static Player player4;
    static Player player5;
    


    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting the pile of tests:");
        dice = Die.getDieInstance();
        cardController = CardController.getInstance();
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

        playerList = new ArrayList<>();
        playerList.add(player1);playerList.add(player2);playerList.add(player3);playerList.add(player4);playerList.add(player5);
        cardController.initializeDeck(playerList, 42);



    }
    /*
        * Requires: Player object
        * Modifies: List armyCards = player1.getInventory().getArmyCards, is modified.
        * Effects: player1 has added one army card to his/her armyCards.
        * 
    */
    @Test
    void testArmyCard() {
        
        int prev_length = player1.getInventory().getArmyCardsLength();
        System.out.println(prev_length);

        player1.getInventory().addArmyCard(cardController.drawArmyCard(player1));
        
        int current_length = player1.getInventory().getArmyCardsLength();
        System.err.println(current_length);

        assertEquals(true, prev_length + 1 == current_length, "Army Card is added!");

    }


    /*
        * Requires: dice Instance
        * Modifies: dice.faceValue;
        * Effects: dice.faceValue has value between 1-6, both included.
        * 
    */
    @Test
    void testDiceRoller() { // huseyin test1
        
        dice.rollDie();
        int result = dice.getFaceValue();

        assertEquals(true, result >= 1 && result <= 6, "Result must be between 1-6 both included!");

    }

    /*
        * Requires: playerFactory instance
        * Modifies: playerFactory.playerNames has another String object.
        * Effects: New player object is created.
        * 
    */
    @Test
    void checkPlayerNameValid() {
        assertThrows(IllegalArgumentException.class, () -> playerFactory.createPlayer("Real Player", null), "If name is null, throws error!");



    }


    
    @AfterAll
    static void afterAll() {
        System.out.println("Test is finished");
    }




}