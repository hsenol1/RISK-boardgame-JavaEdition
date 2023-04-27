package src.ConKUeror.domain.model.Board;




public class Territory {
    
    private int id;

    private int totalArmyUnit;

    private boolean isFree;

    public Territory(int _id) {
        this.id = _id;
        this.isFree = true;
        this.totalArmyUnit = 0;
    }

    public int getId() {
        return id;
    }

    public void addArmy(int army) {
        this.totalArmyUnit += army;

 }
    public void removeArmy(int army) {

    if(totalArmyUnit >= army) {
        this.totalArmyUnit -= army;
    }
 }

    public int getTotalUnit() {
       return totalArmyUnit;
        
    }

    
}
