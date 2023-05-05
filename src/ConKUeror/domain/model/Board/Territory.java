package src.ConKUeror.domain.model.Board;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Territory {

    private Map<Integer, Territory> adjacencyList = new  HashMap<>();
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

    public Map<Integer, Territory> getAdjacencyList() {
        return adjacencyList;
    }

    public void addConnectionDual(Territory neighbor) {

       int neighborId = neighbor.getId();

        if(this.adjacencyList.get(neighborId) == null) {
            this.adjacencyList.put(neighborId, neighbor);
            neighbor.getAdjacencyList().put(this.getId(),this);
        }

    }
    @Override
    public String toString() {
        return Integer.toString(this.id);
    }


}
