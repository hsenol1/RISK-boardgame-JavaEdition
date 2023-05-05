package src.ConKUeror.domain.model.Board;

import java.util.List;
import java.util.Map;

import src.ConKUeror.domain.model.Player.Player;

import java.util.ArrayList;
import java.util.HashMap;


public class Board {

private Continent ASIA;
private Continent NORTH_AMERICA;
private Continent SOUTH_AMERICA;
private Continent AFRICA;
private Continent EUROPE;
private Continent AUSTRALIA;

private Territory territory;
private static List<Continent> continents;


 private static Map<Integer, Territory> territories= new HashMap<>();

    public  Board() {
        initAllTerritoriesAndContinents();

    }
    public static Map<Integer, Territory> getTerritories() {

        return territories;

    }


    public static Territory getTerritoryWithIndex(int i) {

        return territories.get(i);
    }

    public  void setTerritory(Territory _territory) {
        this.territory = _territory;

    }


    public void removeTerritory() {
        int indexToRemove  = territory.getId();
        territories.remove(indexToRemove);
    

    }
    public static void setTerritoryOwner(String territoryName, Player newOwner) {
        for (Continent continent : continents) {
            Territory territory = continent.getTerritoryByName(territoryName);
            if (territory != null) {
                territory.setOwner(newOwner);
                break;
            }
        }
    }
    public static Continent getContinentByTerritory(String territoryName) {
        for (Continent continent : continents) {
            if (continent.containsTerritory(territoryName)) {
                return continent;
            }
        }
        return null;
    }
    public Player choosePlayerForAlliance(Player currentPlayer) {
        // to choose another player for alliance
        return null;
    }

  
    public void formAlliance(Player player1, Player player2) {
        //  to form an alliance between player1 and player2
    }

  
    public int rollDiceForReinforcements() {
        //  roll dice and determine the number of reinforcements
        return 0;
    }

    
    public Territory chooseTerritoryToReinforce(Player player) {
        // to let the player choose a territory to reinforce
        return null;
    }

   
    public int rollDiceForSabotage() {
        //  to roll dice and determine the number of armies to remove
        return 0;
    }

   
    public Territory chooseTerritoryToSabotage(Player player) {
        //  to let the player choose an opponent's territory to sabotage
        return null;
    }

   
    public Territory chooseTerritoryToConquer(Player player) {
        //  to let the player choose an opponent's territory to conquer
        return null;
    }

  
    public Territory chooseAttackingTerritory(Player player) {
        //  to let the player choose a territory to attack from
        return null;
    }

 
    public Territory chooseDefendingTerritory(Player player, Territory attackingTerritory) {
        //  to let the player choose an opponent's territory to attack
        return null;
    }


    public void performSurpriseAttack(Territory attackingTerritory, Territory defendingTerritory, int additionalArmies) {
        //  to perform a surprise attack
    }

   
    public int rollDiceForSurpriseAttack() {
        // to roll dice and determine the number of additional armies for surprise attack
        return 0;
    }


    public Territory chooseTerritoryToProtect(Player player) {
        //  to let the player choose a territory to protect from attack
        return null;
    }

  
    public void protectTerritoryFromAttack(Territory territory) {
        // Implement your logic to protect a territory from attack for one turn
    }

   
    public int rollDiceForMercenaries() {
        // to roll dice and determine the number of additional armies for hiring mercenaries
        return 0;
    }

    
    public Territory chooseTerritoryToDeployMercenaries(Player player) {
       // to let the player choose a territory to deploy mercenaries
        return null;
    }


    public void initAllTerritoriesAndContinents() {



        NORTH_AMERICA = new Continent("North America");
        for(int i = 0 ; i< 9 ; i++) {
            Territory territory = new Territory(i);
            NORTH_AMERICA.addTerritoryToContinent(territory);
            territories.put(i, territory);

        }
        SOUTH_AMERICA= new Continent("South America");
        for(int i= 9; i<13 ; i++ ) {

            Territory territory = new Territory(i);
            SOUTH_AMERICA.addTerritoryToContinent(territory);
            territories.put(i, territory);

        }


        AFRICA= new Continent("Africa");

        for(int i= 13; i<19; i++ ) {

            Territory territory = new Territory(i);
            AFRICA.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }
        EUROPE= new Continent("Europe");
        for(int i= 20; i<27; i++ ) {

            Territory territory = new Territory(i);
            EUROPE.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }

        ASIA= new Continent("Asia");
        for(int i= 27; i<38; i++ ) {

            if(i == 27) {
                Territory territory = new Territory(19);
                ASIA.addTerritoryToContinent(territory);
                territories.put(19, territory);
            }

            Territory territory = new Territory(i);
            ASIA.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }

        AUSTRALIA= new Continent("Australia");
        for(int i= 38; i<42; i++ ) {

            Territory territory = new Territory(i);
            AUSTRALIA.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }




    }

}
