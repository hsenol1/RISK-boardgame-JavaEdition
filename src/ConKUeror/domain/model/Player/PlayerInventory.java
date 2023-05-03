package src.ConKUeror.domain.model.Player;

import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.domain.model.Army;

import src.ConKUeror.domain.model.Board.Card;
import src.ConKUeror.domain.model.Board.*;;;;
public class PlayerInventory {

private Player p;

private int infantryCount;
private int cavalryCount;
private int artilleryCount;
private Army army;
private List<ArmyCard> armyCards;
private List<Territory> ownedTerritories;
private int armies;

   public PlayerInventory() {
        this.army = new Army();
        this.armyCards = new ArrayList<>();
        this.ownedTerritories = new ArrayList<>();
        this.armies = 0;
    }
    public boolean canTradeCards() {
        // Check if the player has a valid set of 3 cards to trade
        // This is just a simple example, you might need to implement more complex rules
       

        for (ArmyCard card : armyCards) {
            switch (card.getType()) {
                case INFANTRY:
                    infantryCount++;
                    break;
                case CAVALRY:
                    cavalryCount++;
                    break;
                case ARTILLERY:
                    artilleryCount++;
                    break;
            }
        }

        return (infantryCount >= 3 || cavalryCount >= 3 || artilleryCount >= 3 ||
                (infantryCount >= 1 && cavalryCount >= 1 && artilleryCount >= 1));
    }
    public void addTerritory(Territory territory) {
        ownedTerritories.add(territory);
    }
    
    public void addArmyCard(ArmyCard card) {
        armyCards.add(card);
    }

    public int getNumberOfArmies() {
        int totalArmies = 0;
    
        // Iterate through all the territories owned by the player
        for (Territory territory : ownedTerritories) {
            // Add the number of armies in the current territory to the total
            totalArmies += territory.getTotalUnit();
        }
    
        return totalArmies;
    }
    public int tradeCardsAndGetAdditionalArmies() {
        
        int additionalArmies = 0;

        if (canTradeCards()) {
            // Remove the traded cards from the player's hand
            // and calculate the additional armies 
          

            // Add the additional armies to the player's total armies
            armies += additionalArmies;
        }

        return additionalArmies;
    }

    public void addArmies(int additionalArmies) {
        
        armies += additionalArmies;
    }

    public void addInfantries(int n) {
        army.addInfantries(n);
    }
    public void addArtilleries(int n) {
        army.addArtilleries(n);
    }
    
    public void addCavalries(int n) {
        army.addCavalries(n);
    }

    public int getTotalArmy() {
       return  army.getTotalArmyUnit();
    }
    





public void deleteCards(Card c[]) {
    
    for(Card c1: c) {

        p.getCards().remove(c1);
        
    }
}

    
}