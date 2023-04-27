package src.ConKUeror.domain.model.Board;

public class TerritoryCard extends Card {
    

    private String territory;
    private int bonusArmies;

    public TerritoryCard(String name, String territory, int bonusArmies) {
        super(name);
        this.territory = territory;
        this.bonusArmies = bonusArmies;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public int getBonusArmies() {
        return bonusArmies;
    }

    public void setBonusArmies(int bonusArmies) {
        this.bonusArmies = bonusArmies;
    }

    @Override
    public void use() {
        
    }



}
