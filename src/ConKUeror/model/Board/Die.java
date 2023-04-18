package src.ConKUeror.model.Board;

import java.util.ArrayList;
import java.util.Random;

public class Die {

    private static Die dieInstance = null;

    private Random random;
    private int faceValue;

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

    public void rollDie()
    {
        faceValue =  random.nextInt(1,7);
    }

    public int getFaceValue() {

        return faceValue;
    }

    
    
}
