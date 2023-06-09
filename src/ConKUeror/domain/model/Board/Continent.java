package ConKUeror.domain.model.Board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Continent implements Serializable {

    private String name;
    private List<Territory> continent_territories;

    public Continent(String _name) {
        this.name = _name;
        this.continent_territories =  new ArrayList<Territory>();

    }
    public List<String> getTerritoryNames() {
        return continent_territories.stream()
                .map(Territory::getName)
                .collect(Collectors.toList());
    }
    public boolean containsTerritory(String territoryName) {
        for (Territory territory : continent_territories) {
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
        return continent_territories;
    }


    public void addTerritoryToContinent(Territory territtory) {
        continent_territories.add(territtory);
    }

    public void deleteFromContinent(Territory t) {
        Iterator<Territory> iterator = continent_territories.iterator();
        while(iterator.hasNext()) {
            Territory territory = iterator.next();
            if (territory.getId() == t.getId()) {
                iterator.remove();  // Safely removes the current item from the List
                break;  // Exit the loop once the territory is found and removed
            }
        }
    }


    public Territory getTerritoryByName(String territoryName) {
        for (Territory territory : continent_territories) {
            if (territory.getName().equals(territoryName)) {
                return territory;
            }
        }
        return null;
    }

}
