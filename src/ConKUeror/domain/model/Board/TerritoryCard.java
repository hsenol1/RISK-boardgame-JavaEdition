package src.ConKUeror.domain.model.Board;
import src.ConKUeror.domain.model.Player.*;

public class TerritoryCard extends Card {
    

    private Territory territory;
    private int bonusArmies;

    public TerritoryCard(String name, Territory territory) {
        super(name);
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

   
    @Override
    public void use(Player player) {
     //   Continent continent = Board.getContinentByTerritory(territory);

        // Check if the player has all territory cards of the continent
        // boolean hasAllTerritoryCards = true;
        // for (Territory territory : continent.getTerritories()) {
        //     if (!player.getInventory().getTerritoryCards().contains(territory.getName())) {
        //         hasAllTerritoryCards = false;
        //         break;
        //     }
        // }
    
        // // Conquer the continent if the player has all territory cards
        // if (hasAllTerritoryCards) {
        //     for (Territory territory : continent.getTerritories()) {
        //         Board.setTerritoryOwner(territory.getName(), player);
        //     }
    //to commit
    }

    }


