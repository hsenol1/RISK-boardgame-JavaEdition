package ConKUeror.domain.model.Army;

public class Cavalry extends Soldier {
    private int unitPower = 5;

    public Cavalry()
    {
        this.unitPower = 5;
        this.healthPoints = 5;
    }

    @Override
    public int getUnitPower() {
        // TODO Auto-generated method stub
        return unitPower;
    }

    @Override
    public void takeHit()
    {
        this.healthPoints--;
    }

    @Override
    public int getHealth()
    {
        return healthPoints;
    }
    
}
