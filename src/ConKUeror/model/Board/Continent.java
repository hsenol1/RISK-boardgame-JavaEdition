package src.ConKUeror.model.Board;

import java.util.ArrayList;
import java.util.List;


public class Continent {
    
    private String name;
    private List<Territory> territories;

    public Continent(String _name) {
        this.name = _name;
        this.territories =  new ArrayList<Territory>();

    }

 
    public void addTerritoryToContinent(Territory territtory) {
        territories.add(territtory);
    }


}
