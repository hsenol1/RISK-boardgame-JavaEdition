package Test;



import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import ConKUeror.domain.controller.CardController;
import ConKUeror.domain.model.Board.ArmyCard;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerFactory;
import ConKUeror.domain.model.Player.PlayerInventory;

public class PlayerInvTest {
    static CardController cardController;
    static Player playerTurn1;
    static Player playerTurn2;
    static Player playerTurn3;
    static Player playerTurn4;
    static Player playerTurn5;


    static PlayerInventory playerInventory;
    static PlayerInventory player2Inventory;
    static PlayerInventory player3Inventory;
    static PlayerInventory player4Inventory;
    static PlayerInventory player5Inventory;

    static PlayerFactory playerFactory;
    static List<ArmyCard> deck;
    static List<ArmyCard> deckEmpty;
    static ArmyCard infantryCard;
    static ArmyCard cavalryCard;
    static ArmyCard artilleryCard;
    
    
    private final PrintStream standardOut = System.out;
    private final static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
   



    @BeforeAll
    void beforeAll() {
        System.setOut(new PrintStream(outputStreamCaptor));
        cardController = CardController.getInstance();
        playerFactory = PlayerFactory.getInstance();
        Color orange = Color.ORANGE;
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(orange);
        Color green = Color.GREEN;
        colorList.add(green);
        playerFactory.setColorList(colorList);
        playerTurn1 = playerFactory.createPlayer("Real Player", "Test Player");
        playerInventory = playerTurn1.getInventory();
        playerTurn2 =  playerFactory.createPlayer("Real Player", "Test2 Player");
        player2Inventory = playerTurn2.getInventory();

        playerTurn3 =  playerFactory.createPlayer("Real Player", "Test3 Player");
        player3Inventory = playerTurn3.getInventory();

        playerTurn4 =  playerFactory.createPlayer("Real Player", "Test4 Player");
        player4Inventory = playerTurn4.getInventory();

        playerTurn5 =  playerFactory.createPlayer("Real Player", "Test5 Player");
        player5Inventory = playerTurn5.getInventory();

     
        infantryCard = new ArmyCard("Infantry Card", ArmyCard.ArmyType.INFANTRY);
        artilleryCard = new ArmyCard("Artillery Card", ArmyCard.ArmyType.ARTILLERY);
        cavalryCard = new ArmyCard("Cavalry Card", ArmyCard.ArmyType.CAVALRY);

        for (int i = 0; i < 6; i++) {
            playerTurn1.getInventory().addArmyCard(artilleryCard);
            playerTurn1.getInventory().addArmyCard(infantryCard);
            playerTurn1.getInventory().addArmyCard(cavalryCard);
           
        }


        for (int i = 0; i < 6; i++) {
            playerTurn2.getInventory().addArmyCard(artilleryCard);
            playerTurn2.getInventory().addArmyCard(infantryCard);
            playerTurn2.getInventory().addArmyCard(cavalryCard);
           
        }


        for (int i = 0; i < 6; i++) {
            playerTurn5.getInventory().addArmyCard(artilleryCard);
            playerTurn5.getInventory().addArmyCard(infantryCard);
            playerTurn5.getInventory().addArmyCard(cavalryCard);
        }

        

    }

    @AfterAll
    public void afterEach() {
        System.setOut(standardOut);
    }

    @Test
    public void isTypeValid() {
    
        playerTurn4.getInventory().useArmyCards(9); // there are only 5 types.

        assertEquals("Not valid type!", outputStreamCaptor.toString().trim());



    }

    @Test
    public void removeArmyCards() {
        int pre_Inf_Count = playerTurn1.getInventory().getInfantryCount();
        int pre_Art_Count = playerTurn1.getInventory().getArtilleryCount();

        playerTurn1.getInventory().useArmyCards(3);

        int new_Inf_Count = playerTurn1.getInventory().getInfantryCount();
        int new_Art_Count = playerTurn1.getInventory().getArtilleryCount();

        assertEquals(new_Inf_Count, pre_Inf_Count - 2, "Infantry Card count decreased by 2");
        assertEquals(new_Art_Count, pre_Art_Count - 1, "Artillery Card count decreased by 1");
    }


    @Test
    public void addArmiesAsCavalry() {

        int before_Cavalry_Number = playerTurn2.getInventory().getArmy().getCavalries();

        playerTurn2.getInventory().useArmyCards(2);

        int after_Cavalry_Number = playerTurn2.getInventory().getArmy().getCavalries();

        assertEquals(after_Cavalry_Number,before_Cavalry_Number + 2, "Army has 2 extra cavalries!");



    }


    @Test
    public void notEnoughCards() {
        // // this time, not valid due to lack of cards.

         playerTurn3.getInventory().useArmyCards(2);

         assertEquals("Test Case 2 occured, transition happening.", outputStreamCaptor.toString().trim());

    }


    @Test
    public void successfulConvertPrint() {
        int before_Cavalry_Number = playerTurn5.getInventory().getArmy().getArtilleries();

        playerTurn5.getInventory().useArmyCards(5);

        int after_Cavalry_Number = playerTurn5.getInventory().getArmy().getArtilleries();

        assertEquals(after_Cavalry_Number,before_Cavalry_Number + 3, "Army has 2 extra cavalries!");
       
        

    }









       




    
}
