package Test;

import org.junit.jupiter.api.Test;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Continent;
import ConKUeror.domain.model.Board.Territory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

    /*
    *This test class is for testing the class Board.
    *Overview, abstract function, representation invariant, repOk method is written in the Board class.
    *This class includes 3 BLACKBOX and 2 GLASSBOX test.
    *This is a BLACKBOX test.
    */


class BoardClassTest {
    private static Board board;

    @BeforeAll
    static void setUp() {
        board = new Board();
    }


    /*
    *Testing that repOk returns true after initialization.
    *This is a BLACKBOX test.
    */
    @Test
    void testRepOk() {
        assertTrue(board.repOk());
    }

    /*
    *Testing that the unoccupied territories map is identical to the territories map after initialization.
    *This is a BLACKBOX test.
    */

    @Test
    void testInitUnoccupiedTerritories() {
        assertEquals(Board.getTerritories(), Board.getUnoccupiedTerritories());
    }

    /*
    *Test that we get correct continent based on territory ID.
    *This is a GLASSBOX test.
    */

    @Test
    void testGetContinentByTerritoryID() {
        Continent continent = Board.getContinentByTerritoryID(5);
        assertEquals("North America", continent.getName());

        continent = Board.getContinentByTerritoryID(12);
        assertEquals("South America", continent.getName());

        continent = Board.getContinentByTerritoryID(15);
        assertEquals("Africa", continent.getName());

        continent = Board.getContinentByTerritoryID(24);
        assertEquals("Europe", continent.getName());

        continent = Board.getContinentByTerritoryID(28);
        assertEquals("Asia", continent.getName());

        continent = Board.getContinentByTerritoryID(39);
        assertEquals("Australia", continent.getName());
    }



    /*
    *Test that a territory can be removed and is removed correctly.
    *This is a GLASSBOX test
    */

    @Test
    void testRemoveTerritory() {
        Territory territory = Board.getTerritoryWithIndex(10);
        board.setTerritory(territory);
        board.removeTerritory();
        assertNull(Board.getTerritoryWithIndex(10));
    }

    /*
    *Testing that all continents are initialized and have the correct number of territories.
    *This is a BLACKBOX test.
    */

    @Test
    void testAllContinentsInitialized() {
        assertEquals(6, Board.getContinents().size());
        assertEquals(9, Board.getContinentByName("North America").getTerritories().size());
        assertEquals(4, Board.getContinentByName("South America").getTerritories().size());
        assertEquals(6, Board.getContinentByName("Africa").getTerritories().size());
        assertEquals(7, Board.getContinentByName("Europe").getTerritories().size());
        assertEquals(12, Board.getContinentByName("Asia").getTerritories().size());
        assertEquals(4, Board.getContinentByName("Australia").getTerritories().size());
    }
}
