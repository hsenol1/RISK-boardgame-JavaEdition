package src.ConKUeror.domain.model.Board;
import src.ConKUeror.domain.model.Player.*;
public class ChanceCard extends Card {
    public enum ChanceType {
        ALLIANCE, REINFORCEMENTS, SABOTAGE, COUP, SURPRISE_ATTACK, DIPLOMATIC_IMMUNITY, MERCENARIES
    }

    private ChanceType type;

    public ChanceCard(String name, ChanceType type) {
        super(name);
        this.type = type;
    }

    public ChanceType getType() {
        return type;
    }

    public void setType(ChanceType type) {
        this.type = type;
    }

    @Override
    public void use(Player player) {
       
    }
}
