package ConKUeror.domain.model.Army;

public class Infantry extends Soldier{
    int unitPower = 1;

    public Infantry()
    {
        this.unitPower = 1;
        this.healthPoints = 1;
    }

    @Override
    public int getUnitPower() {
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
