package ConKUeror.domain.model.Army;

public class Artillery extends Soldier {
    private int unitPower = 10;

    public Artillery ()
    {
        this.unitPower = 10;
        this.healthPoints = 10;
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
