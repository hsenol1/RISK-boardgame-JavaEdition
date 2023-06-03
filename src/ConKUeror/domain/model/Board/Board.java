package ConKUeror.domain.model.Board;

import java.util.List;
import java.util.Map;

import ConKUeror.domain.model.Player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Board implements Serializable{

 /*
  * OVERVIEW: The Board class represents the game board in the game, consisting of
  * territories grouped into continents. Each territory can be unoccupied at the beginning of the game
  * and they can be occupied by a player.
 */
 /*
 * The abstraction function is
 * AF(c) = { "Board with " + c.continents.size() + " continents. Each territory in each
 * continent may be owned by a Player or unoccupied" }
 */
/*
 *The rep invariant is:
 * RI(c) = (c.continents != null) && (c.territories != null) && (c.unoccupiedTerritories != null) &&
 * (Every territory in territories belongs to exactly one continent in continents) &&
 * (Every territory in unoccupiedTerritories is also present in territories)
 */




private Continent ASIA;
private Continent NORTH_AMERICA;
private Continent SOUTH_AMERICA;
private Continent AFRICA;
private Continent EUROPE;
private Continent AUSTRALIA;

private static Territory currentTerritory;
private static List<Continent> continents = new ArrayList<>();
static Map<Integer, Territory> unoccupiedTerritories = new LinkedHashMap<>();
private static Map<Integer, Territory> territories= new HashMap<>();

    public  Board() {
        initAllTerritoriesAndContinents();
        initUnoccupiedTerritories();

    }

    public static void initUnoccupiedTerritories() {
        unoccupiedTerritories.putAll(territories);

    }

    public static Map<Integer, Territory> getUnoccupiedTerritories() {
        return unoccupiedTerritories;
    }


    public static Map<Integer, Territory> getTerritories() {

        return territories;

    }


    public static Territory getTerritoryWithIndex(int i) {

        return territories.get(i);
    }

    public  void setTerritory(Territory _territory) {
        this.currentTerritory = _territory;

    }

    public static Territory getCurrenTerritory() {
        return currentTerritory;
    }


    public void removeTerritory() {
        int indexToRemove  = currentTerritory.getId();
        System.out.println("this is the selected button id to remove: " +indexToRemove);
        territories.remove(indexToRemove);


    }

    public static List<Continent> getContinents() {
        return continents;
    }

    public static Continent getContinentByName(String name) {
        for (Continent continent : continents) {
            if (continent.getName().equals(name)) {
                return continent;
            }
        }
        return null;
    }


    public static Continent getContinentByTerritory(String territoryName) {
        for (Continent continent : continents) {
            if (continent.containsTerritory(territoryName)) {
                return continent;
            }
        }
        return null;
    }

    public static Continent getContinentByTerritoryID(int id) {

        if (id < 9) {
            return continents.get(0);
        }

        else if (id > 8 && id < 13) {
            return continents.get(1);
        }
        else if (id > 12 && id < 19) {
            return continents.get(2);
        }
        else if (id > 19 && id < 27) {
            return continents.get(3);
        }
        else if (id > 27 && id < 38) {
            return continents.get(4);
        }
        else if (id > 37 && id < 42) {
            return continents.get(5);
        }
        else {
            return null;
        }


    }
    public boolean repOk() {
        if (continents == null || territories == null || unoccupiedTerritories == null) return false;

        for (Continent continent : continents) {
            if (continent == null || continent.getTerritories() == null) return false;
            for (Territory territory : continent.getTerritories()) {
                if (!territories.containsValue(territory)) return false;
            }
        }

        for (Territory territory : unoccupiedTerritories.values()) {
            if (!territories.containsValue(territory)) return false;
        }

        return true;
    }



    public void initAllTerritoriesAndContinents() {



        NORTH_AMERICA = new Continent("North America");
        continents.add(NORTH_AMERICA);
        for(int i = 0 ; i< 9 ; i++) {
            Territory territory = new Territory(i);
            NORTH_AMERICA.addTerritoryToContinent(territory);
            territories.put(i, territory);

        }
        SOUTH_AMERICA= new Continent("South America");
        continents.add(SOUTH_AMERICA);
        for(int i= 9; i<13 ; i++ ) {

            Territory territory = new Territory(i);
            SOUTH_AMERICA.addTerritoryToContinent(territory);
            territories.put(i, territory);

        }


        AFRICA= new Continent("Africa");
        continents.add(AFRICA);

        for(int i= 13; i<19; i++ ) {

            Territory territory = new Territory(i);
            AFRICA.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }
        EUROPE= new Continent("Europe");
        continents.add(EUROPE);
        for(int i= 20; i<27; i++ ) {

            Territory territory = new Territory(i);
            EUROPE.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }

        ASIA= new Continent("Asia");
        continents.add(ASIA);
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
        continents.add(AUSTRALIA);
        for(int i= 38; i<42; i++ ) {

            Territory territory = new Territory(i);
            AUSTRALIA.addTerritoryToContinent(territory);
            territories.put(i, territory);


        }




    }

}
