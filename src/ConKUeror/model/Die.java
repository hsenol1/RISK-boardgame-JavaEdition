package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.Random;

public class Die {

    private static Die dieInstance = null;

    private Random random;

    private Die()
    {
        this.random = new Random();
    }

    public static Die getDieInstance()
    {
        if (dieInstance == null)
        {
            dieInstance = new Die();
        }
        return dieInstance;
    }

    public int rollDie()
    {
        return random.nextInt(1,7);
    }

    public boolean rollForAttack(int army1, int army2) {
        while (army1 > 0 && army2 > 0) {
            int roll1 = rollDie();
            int roll2 = rollDie();

            if (roll1 > roll2) {
                army2--;
            } else {
                army1--;
            }
        }

        return army2 == 0;
    }
    
}
