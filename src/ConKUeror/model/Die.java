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

    public ArrayList<Integer> rollForAttack(int n)
    {
        ArrayList<Integer> rollResults = new ArrayList<Integer>();

        for (int i = 0; i<n; i++)
        {
            rollResults.add(rollDie());
        }
        return rollResults;
    }
   
    
}
