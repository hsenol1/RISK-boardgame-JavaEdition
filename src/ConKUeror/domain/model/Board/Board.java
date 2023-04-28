package src.ConKUeror.domain.model.Board;

import java.util.List;
import java.util.Map;
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


 //private ArrayList<Territory> boardTerritories2 = new ArrayList<Territory>();

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

    public  void takeTerritoryForRemoval(Territory _territory) {
        this.territory = _territory;

    }


    public void removeTerritory() {
        int indexToRemove  = territory.getId();
        territories.remove(indexToRemove);
        //add additional method if you want to reverse deleletion

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

        //europe 7
        //afrika da 6 fark
        //asia 12 
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
