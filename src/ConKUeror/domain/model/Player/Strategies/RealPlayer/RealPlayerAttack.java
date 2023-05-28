package ConKUeror.domain.model.Player.Strategies.RealPlayer;

import java.io.Serializable;

import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Player.Strategies.IAttackBehaviour;

public class RealPlayerAttack implements IAttackBehaviour,Serializable {

    @Override
    public void attack(int attackingArmy, int defendingArmy) {
        // TODO Auto-generated method stub
        if (DiceRoller.getDiceRollerInstance().rollForAttack(attackingArmy, defendingArmy))
        {
            System.out.println("Attack is successful");
        }
        else
        {
            System.out.println("Attack failed");
        }


    }
    
}
