package src.ConKUeror.domain.model.Player.Strategies.RealPlayer;

import src.ConKUeror.domain.model.Board.DiceRoller;
import src.ConKUeror.domain.model.Player.Strategies.IAttackBehaviour;

public class RealPlayerAttack implements IAttackBehaviour {

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
