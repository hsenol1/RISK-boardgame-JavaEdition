package ConKUeror.domain.model.Board;

import ConKUeror.domain.model.Player.Player;

public class ChanceCard extends Card {

    public enum ChanceType {
        REINFORCEMENTS, COUP, REVOLT, SECRETWEAPON, DRAFT
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
        this.type =type;
    }


    @Override
    public void use(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
    
}