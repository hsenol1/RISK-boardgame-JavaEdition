package ConKUeror.domain.model.Player.Strategies.RealPlayer;

import java.util.List;

import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Army.Artillery;
import ConKUeror.domain.model.Army.Cavalry;
import ConKUeror.domain.model.Army.Infantry;
import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Player.Strategies.IAttackBehaviour;

public class RealPlayerAttack implements IAttackBehaviour {

    @Override
    public void attack(List<Infantry> attackingInfantries, List<Cavalry> attackingCavalries,
    List<Artillery> attackingArtilleries, Army defendingArmy)
    {
        if (DiceRoller.getDiceRollerInstance().rollForAttack(attackingInfantries, attackingCavalries, attackingArtilleries,
        defendingArmy))
        {
            System.out.println("Attack is successful");
        }
        else
        {
            System.out.println("Attack failed");
        }

    }
    
}
