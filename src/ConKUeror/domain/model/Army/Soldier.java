package ConKUeror.domain.model.Army;



public abstract class Soldier {
    
protected int healthPoints;
    
public abstract int getUnitPower();
    
public abstract void takeHit();
    
public abstract int getHealth();
    
/* 
    There are 6 complete sets of armies, each containing 3 denominations of army pieces: 
    Infantry (worth l), Cavalry (worth 5 Infantry), and Artillery (worth 10 Infantry, or 2 Cavalry). 
    Start the game by placing Infantry pieces;
     later in the game, you may trade in 5 Infantry for 1 Cavalry, 
     or 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.
*/


}
