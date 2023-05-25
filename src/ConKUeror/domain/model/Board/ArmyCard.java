package ConKUeror.domain.model.Board;
import ConKUeror.domain.model.Player.*;
import ConKUeror.domain.model.Player.PlayerInventory;
public class ArmyCard extends Card {
    public enum ArmyType {
        INFANTRY, CAVALRY, ARTILLERY
    }

    private ArmyType type;

    public ArmyCard(String name, ArmyType type) {
        super(name);
        this.type = type;
    }

    public ArmyType getType() {
        return type;
    }

    public void setType(ArmyType type) {
        this.type = type;
    }

    @Override
    public void use(Player player) {
        // if (player.inv.canTradeCards()) {
        //     int additionalArmies = player.inv.tradeCardsAndGetAdditionalArmies();
        //     player.inv.addArmies(additionalArmies);
        // }
    }

}
