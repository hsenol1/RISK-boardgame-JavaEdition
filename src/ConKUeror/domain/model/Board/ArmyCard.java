package src.ConKUeror.domain.model.Board;

public class ArmyCard extends Card {
    private int additionalArmies;
    private int armyPower;
    public ArmyCard(String name, int additionalArmies) {
        super(name);
        this.additionalArmies = additionalArmies;
    }

    public int getAdditionalArmies() {
        return additionalArmies;
    }

    public void setAdditionalArmies(int additionalArmies) {
        this.additionalArmies = additionalArmies;
    }

    @Override
    public void use() {
        
    }

}
