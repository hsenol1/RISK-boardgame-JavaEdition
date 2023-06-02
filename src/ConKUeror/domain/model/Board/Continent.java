package ConKUeror.domain.model.Board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Continent implements Serializable {
    
    private String name;
    private List<Territory> territories;

    public Continent(String _name) {
        this.name = _name;
        this.territories =  new ArrayList<Territory>();

    }
    public List<String> getTerritoryNames() {
        return territories.stream()
                .map(Territory::getName)
                .collect(Collectors.toList());
    }
    public boolean containsTerritory(String territoryName) {
        for (Territory territory : territories) {
            if (territory.getName().equals(territoryName)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

 
    public void addTerritoryToContinent(Territory territtory) {
        territories.add(territtory);
    }
    public Territory getTerritoryByName(String territoryName) {
        for (Territory territory : territories) {
            if (territory.getName().equals(territoryName)) {
                return territory;
            }
        }
        return null;
    }

}
