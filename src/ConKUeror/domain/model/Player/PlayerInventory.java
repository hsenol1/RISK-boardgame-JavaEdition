package src.ConKUeror.domain.model.Player;

import java.util.ArrayList;
import java.util.List;





import src.ConKUeror.domain.model.Board.Card;
import src.ConKUeror.domain.model.Army.Army;
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
private List<TerritoryCard> territoryCards;
private List<ChanceCard> chanceCards;
   public PlayerInventory() {
        this.army = new Army();
        this.armyCards = new ArrayList<>();
        this.ownedTerritories = new ArrayList<>();
        this.territoryCards = new ArrayList<>();
        this.armies = 0;
    }
    public List<TerritoryCard> getTerritoryCards() {
        return territoryCards;
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

    public void useArmyCard() {
        
    }

    public void addTerritoryCard(TerritoryCard territoryCard) {
        territoryCards.add(territoryCard);
        System.out.println("Territory card's territory name is: " + territoryCard.getTerritory().getId());
       
    }


    public void useTerritoryCards() {
        boolean valid = true;
        Continent continent = Board.getContinentByTerritoryID(territoryCards.get(0).getTerritory().getId());
        List<Integer> tCardNames = new ArrayList<>();
        for (TerritoryCard tc : territoryCards) {
            tCardNames.add(tc.getTerritory().getId());
        }

        for (Territory territory : continent.getTerritories()) {
           if (!tCardNames.contains(territory.getId())) {
                System.out.println("Cards are not enough!");
                valid = false;
                break;

           }

        }
        if (valid) {
            System.out.println(continent.getName() + " is captured!");
        }
       
        

       


    
    
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

    public void removeInfantries(int n) {

        army.removeInfantries(n);
    }

    public void removeCavalries(int n) {

        army.removeCavalries(n);
    }

    public void removeArtilleries(int n) {

        army.removeArtilleries(n);
    }







public void deleteCards(Card c[]) {

    for(Card c1: c) {

        p.getCards().remove(c1);

    }
}


}