package src.ConKUeror.model.Board;

import java.util.*;

public class Board {
    
private Continent ASIA;
private Continent NORTH_AMERICA;
private Continent SOUTH_AMERICA;
private Continent AFRICA;
private Continent EUROPE;
private Continent AUSTRALIA;

private Territory territory;


 private ArrayList<Territory> boardTerritories = new ArrayList<Territory>();


    public  Board() {
        initAllTerritoriesAndContinents();

    }


    public Territory getTerritoryWithIndex(int i) {

        return boardTerritories.get(i);
    }

    public void takeTerritoryForRemoval(Territory _territory) {
        this.territory = _territory;

    }


    public void removeTerritoryFromBoardList() {
        int indexToRemove  = territory.getId();
        boardTerritories.set(indexToRemove, null);

    }



    public void initAllTerritoriesAndContinents() {


         
        NORTH_AMERICA = new Continent("North America");
        for(int i = 0 ; i< 9 ; i++) {
            Territory territory = new Territory(i);
            NORTH_AMERICA.addTerritoryToContinent(territory);
            boardTerritories.add(territory);

        }
        SOUTH_AMERICA= new Continent("South America");
        for(int i= 9; i<13 ; i++ ) {

            Territory territory = new Territory(i);
            SOUTH_AMERICA.addTerritoryToContinent(territory);
            boardTerritories.add(territory);

        }
        EUROPE= new Continent("Europe");
        for(int i= 13; i<20; i++ ) {

            Territory territory = new Territory(i);
            EUROPE.addTerritoryToContinent(territory);
            boardTerritories.add(territory);


        }
        AFRICA= new Continent("Africa");
        for(int i= 20; i<26; i++ ) {

            Territory territory = new Territory(i);
            AFRICA.addTerritoryToContinent(territory);
            boardTerritories.add(territory);


        }

        ASIA= new Continent("Asia");
        for(int i= 26; i<38; i++ ) {

            Territory territory = new Territory(i);
            ASIA.addTerritoryToContinent(territory);
            boardTerritories.add(territory);


        }

        AUSTRALIA= new Continent("Australia");
        for(int i= 38; i<42; i++ ) {

            Territory territory = new Territory(i);
            AUSTRALIA.addTerritoryToContinent(territory);
            boardTerritories.add(territory);


        }




    }

}
