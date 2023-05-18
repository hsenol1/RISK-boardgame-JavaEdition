package src.ConKUeror.domain.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;





import src.ConKUeror.domain.model.Board.Card;
import src.ConKUeror.domain.model.Board.ArmyCard.ArmyType;
import src.ConKUeror.domain.model.Army.Army;
import src.ConKUeror.domain.model.Board.*;;;;
public class PlayerInventory {

private Player p;

private int infantryCount; // card
private int cavalryCount; // card
private int artilleryCount; // card
private Army army;
private List<ArmyCard> armyCards = new ArrayList<>();
private List<Territory> ownedTerritories;
private List<Continent> ownedContinents = new ArrayList<>();
private int armies;
private List<TerritoryCard> territoryCards;
private List<ChanceCard> chanceCards;


private static final List<String> NORTH_AMERICA = Arrays.asList("Territory Card 0", "Territory Card 1", "Territory Card 2", "Territory Card 5", "Territory Card 3", "Territory Card 4", "Territory Card 6", "Territory Card 7", "Territory Card 8");
private static final List<String> SOUTH_AMERICA = Arrays.asList("Territory Card 9", "Territory Card 10", "Territory Card 11", "Territory Card 12");
private static final List<String> EUROPE = Arrays.asList("Territory Card 21", "Territory Card 22", "Territory Card 23", "Territory Card 20", "Territory Card 25", "Territory Card 24", "Territory Card 26");
private static final List<String> AFRICA = Arrays.asList("Territory Card 13", "Territory Card 14", "Territory Card 15", "Territory Card 16", "Territory Card 17", "Territory Card 18");
private static final List<String> ASIA = Arrays.asList("Territory Card 19", "Territory Card 29", "Territory Card 37", "Territory Card 28", "Territory Card 30", "Territory Card 31", "Territory Card 32", "Territory Card 33", "Territory Card 27", "Territory Card 34", "Territory Card 36", "Territory Card 35", "Territory Card 37");
private static final List<String> AUSTRALIA = Arrays.asList("Territory Card 38", "Territory Card 39", "Territory Card 40", "Territory Card 41");


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

    public Army getArmy() {

        return this.army;
    }
    public List<ArmyCard> getArmyCards() {
        return armyCards;
    }

    public String getArmyCardstoString() {
        return armyCards.toString();
    }
    public void countByTypes() {
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

        // return (infantryCount >= 3 || cavalryCount >= 3 || artilleryCount >= 3 ||
        //         (infantryCount >= 1 && cavalryCount >= 1 && artilleryCount >= 1));
    }
    public void addTerritory(Territory territory) {
        ownedTerritories.add(territory);

    }

    public List<Territory> getOwnedTerritories() {
        return this.ownedTerritories;
    }

    public void addArmyCard(ArmyCard card) {
        armyCards.add(card);
        if (card.getType().equals(ArmyType.INFANTRY)) {
            infantryCount += 1;
        }

        else if (card.getType().equals(ArmyType.CAVALRY)) {
            cavalryCount += 1;
        }

        else {
            artilleryCount += 1;
        }
    }



    public void addTerritoryCard(TerritoryCard territoryCard) {
        territoryCards.add(territoryCard);


    }


    public void useTerritoryCards() {
        for (List<String> continent : Arrays.asList(NORTH_AMERICA, SOUTH_AMERICA, EUROPE, AFRICA, ASIA, AUSTRALIA)) {
            boolean continentCanBeCreated = true;
  
            for (String cardName : continent) {
                
                
                if (!territoryCards.stream().anyMatch(card -> card.getName().endsWith(cardName))) {
                    continentCanBeCreated = false;
                    break;
                }
            }
            if (continentCanBeCreated) {
                for (String cardName : continent) {
                    territoryCards.removeIf(card -> card.getName().endsWith(cardName));
                }
                System.out.println(continent);
               
            }
        }



        

    }

    public static boolean allElementsIncluded(List<String> list1, List<String> list2) {
        for (String element : list1) {
            if (!list2.contains(element)) {
                return false;
            }
        }
        return true;
    }




    public void removeInfantryCard(int n) {
        if (infantryCount != 0) {
            int counter = 0;
            Iterator<ArmyCard> iterator = armyCards.iterator();

            while (iterator.hasNext()) {
                ArmyCard aC = iterator.next();

                if (aC.getType().equals(ArmyType.INFANTRY) && counter < n) {
                    iterator.remove();
                    counter += 1;
                    infantryCount -= 1;
                }
            }
        }
    }


    public void removeArtilleryCard(int n) {
        if (artilleryCount != 0) {
            int counter = 0;
            Iterator<ArmyCard> iterator = armyCards.iterator();

            while (iterator.hasNext()) {
                ArmyCard aC = iterator.next();

                if (aC.getType().equals(ArmyType.ARTILLERY) && counter < n) {
                    iterator.remove();
                    counter += 1;
                    artilleryCount -= 1;
                }
            }
        }
    }

    public void removeCavalryCard(int n) {
        if (cavalryCount != 0) {
            int counter = 0;
            Iterator<ArmyCard> iterator = armyCards.iterator();

            while (iterator.hasNext()) {
                ArmyCard aC = iterator.next();

                if (aC.getType().equals(ArmyType.CAVALRY) && counter < n) {
                    iterator.remove();
                    counter += 1;
                    cavalryCount -= 1;
                }
            }
        }
    }








    public void useArmyCards(int type) {
        boolean validation = isValid(type);
        if (!validation) {
            System.out.println("you can not use army cards, because not valid!");
            return;
        }



        if (type == 1) {
            System.out.println("Test Case 1 occured, transition happening.");
            addCavalries(1);

            removeInfantryCard(3);


        }
        else if (type == 2) {
            System.out.println("Test Case 2 occured, transition happening.");

            addCavalries(2);
            removeInfantries(2);
            // deleteArmyCards(0, 2);
            // deleteArmyCards(2, 1);

            removeCavalries(1);

        }

        else if (type == 3) {
            System.out.println("Test Case 3 occured, transition happening.");
            addArtilleries(2);
           removeInfantries(2);
            removeArtilleries(1);
        }

        else if (type == 4) {
            System.out.println("Test Case 4 occured, transition happening.");
            addCavalries(1);
            addArtilleries(1);
            removeInfantryCard(1);
            removeCavalryCard(2);
        }


        else if (type == 5){
            System.out.println("Test Case 5 occured, transition happening.");
            addArtilleries(3);
            removeArtilleryCard(1);
            removeCavalryCard(2);


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

        // if (canTradeCards()) {
        //     // Remove the traded cards from the player's hand
        //     // and calculate the additional armies


        //     // Add the additional armies to the player's total armies
        //     armies += additionalArmies;
        // }

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

    public boolean isValid(int type) {
        switch(type) {
            case 1:
                if (infantryCount >= 3) {
                    return true;
                }
                else {
                    return false;
                }
                
            case 2:
                if (infantryCount >= 2 && cavalryCount >= 1) {
                    return true;
                }

                else {
                    return false;
                }
                
            case 3:
                if (infantryCount >= 2 && artilleryCount >= 1) {
                    return true;
                }
                else {
                    return false;
                }
                
            case 4:
                if (infantryCount >= 1 && cavalryCount>= 2) {
                    return true;
                }
                else {
                    return false;
                }
                
                
            case 5:
                if (artilleryCount >= 1 && cavalryCount >= 2) {
                    return true;
                }
                else {
                    return false;
                }
                

                

            
        }
        return false;


   


    }







public void deleteCards(Card c[]) {

    for(Card c1: c) {

        p.getCards().remove(c1);

    }
}


}