package src.ConKUeror.domain.model.Board;
import src.ConKUeror.domain.model.Player.*;

public class TerritoryCard extends Card {
    

    private String territory;
    private int bonusArmies;

    public TerritoryCard(String name, String territory) {
        super(name);
        this.territory = territory;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

   
    @Override
    public void use(Player player) {
        
    }



}
