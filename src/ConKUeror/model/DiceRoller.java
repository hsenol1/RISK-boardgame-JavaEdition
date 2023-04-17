package src.ConKUeror.model;

public class DiceRoller {


    Die die = Die.getDieInstance();

    int attackerArmy;
    int defenderArmy;


    public int rollDice() {
        die.rollDie();
       return die.getFaceValue();
    }



    public boolean rollForAttack(int attackerArmy, int defenderArmy) {
        while (attackerArmy > 0 && defenderArmy > 0) {
            
            die.rollDie();
            int roll1 =die.getFaceValue();
            //System.out.println(roll1);
            die.rollDie();
            int roll2 =die.getFaceValue();
            //System.out.println(roll2);


            if (roll1 > roll2) {
                defenderArmy--;
                System.out.println("ATTACKER HITS");

            } else {
                attackerArmy--;
                System.out.println("DEFENDER HITS");
                

            }
        }
        this.attackerArmy = attackerArmy;
        this.defenderArmy = defenderArmy;

        return defenderArmy == 0;
    }

    public int postWarGetAttackerArmy() {

        return attackerArmy;
    }

    public int postWarGetDefenderArmy() {
        return defenderArmy;
        
    }



    
    
}
