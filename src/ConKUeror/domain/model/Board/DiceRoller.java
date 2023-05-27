package ConKUeror.domain.model.Board;

import java.util.ArrayList;
import java.util.List;

import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Army.Artillery;
import ConKUeror.domain.model.Army.Cavalry;
import ConKUeror.domain.model.Army.Infantry;
import ConKUeror.domain.model.Army.Soldier;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;

public class DiceRoller {

    private static DiceRoller diceRollerInstance = null;
    Die die;
    PlayerExpert playerExpert;

    private DiceRoller() {
        this.die = Die.getDieInstance();
        playerExpert = PlayerExpert.getPlayerExpert();
    }

    public static DiceRoller getDiceRollerInstance()
    {
        if (diceRollerInstance == null)
        {
            diceRollerInstance = new DiceRoller();
        }
        return diceRollerInstance;
    }

    int attackerArmy;
    int defenderArmy;


    public int rollDice() {
        die.rollDie();
       return die.getFaceValue();
    }



    public boolean rollForAttack(List<Infantry> attackingInfantries, List<Cavalry> attackingCavalries,
    List<Artillery> attackingArtilleries, Army defendingArmy)
    {
        boolean attackSuccess = false;

        List<Soldier> attackingSoldiers = new ArrayList<Soldier>();
        List<Soldier> defendingSoldiers = new ArrayList<Soldier>();

        //add all attacking soldiers to a list
        if (attackingInfantries.size() > 0)
        {
            for (Infantry infantry: attackingInfantries)
            {
                attackingSoldiers.add(infantry);
            }
        }

        if (attackingCavalries.size() > 0)
        {
            for (Cavalry cavalry: attackingCavalries)
            {
                attackingSoldiers.add(cavalry);
            }
        }

        if (attackingArtilleries.size() > 0)
        {
            for (Artillery artillery: attackingArtilleries)
            {
                attackingSoldiers.add(artillery);
            }
        }

        //add all defending soldiers to a list
        List<Infantry> defendingInfantries = defendingArmy.getInfantryList();
        List<Cavalry> defendingCavalries = defendingArmy.getCavalryList();
        List<Artillery> defendingArtilleries = defendingArmy.getArtilleryList();

        if (defendingInfantries.size() > 0)
        {
            for(Infantry infantry: defendingInfantries)
            {
                defendingSoldiers.add(infantry);
            }
        }

        if (defendingCavalries.size() > 0)
        {
            for (Cavalry cavalry: defendingCavalries)
            {
                defendingSoldiers.add(cavalry);
            }
        }

        if (defendingArtilleries.size() > 0)
        {
            for (Artillery artillery: defendingArtilleries)
            {
                defendingSoldiers.add(artillery);
            }
        }

        //loop until a list's size becomes 0
        if (attackingSoldiers.size() != 0 && defendingSoldiers.size() != 0)
        {
            while (attackingSoldiers.size() > 0 && defendingSoldiers.size() > 0)
            {
                int firstRoll = die.getFaceValue();;
                int secondRoll = die.getFaceValue();;
                System.out.println(firstRoll + " " + secondRoll);

                if (firstRoll > secondRoll)
                {
                    defendingSoldiers.get(0).takeHit();
                }
                if (defendingSoldiers.get(0).getHealth() == 0)
                {
                    defendingSoldiers.remove(0);
                }
                else
                {
                    attackingSoldiers.get(0).takeHit();
                }
                if (attackingSoldiers.get(0).getHealth() == 0)
                {
                    attackingSoldiers.remove(0);
                }
            }
            
        }

        if (attackingSoldiers.size() != 0)
        {
            attackSuccess = true;
        }

        return attackSuccess;

        // while (attackerArmy > 0 && defenderArmy > 0) {
            
        //     die.rollDie();
        //     int roll1 =die.getFaceValue();
        //     //System.out.println(roll1);
        //     die.rollDie();
        //     int roll2 =die.getFaceValue();
        //     //System.out.println(roll2);


        //     if (roll1 > roll2) {
        //         defenderArmy--;
        //         System.out.println("ATTACKER HITS");

        //     } else {
        //         attackerArmy--;
        //         System.out.println("DEFENDER HITS");
                

        //     }
        // }
        // this.attackerArmy = attackerArmy;
        // this.defenderArmy = defenderArmy;

        // return defenderArmy == 0;
    
    }

    public int postWarGetAttackerArmy() {

        return attackerArmy;
    }

    public int postWarGetDefenderArmy() {
        return defenderArmy;
        
    }

    public Player getFirstPlayer() {
        
      

        return PlayerExpert.getPlayersList().get(die.getCustomValue(PlayerExpert.getPlayersListSize() - 1));



    }



    
    
}
