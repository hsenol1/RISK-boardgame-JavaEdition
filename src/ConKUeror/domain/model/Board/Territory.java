package src.ConKUeror.domain.model.Board;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.ConKUeror.domain.model.Player.Player;



public class Territory {
    
    private Map<Integer, Territory> adjacencyList = new  HashMap<>();
    private int id;

    private int totalArmyUnit;
    private String name;
    private Player owner;

    private boolean isFree;



    public Territory(int _id) {
        this.id = _id;
        this.isFree = true;
        this.totalArmyUnit = 0;
    }
    public void setOwner(Player newOwner) {
        this.owner = newOwner;
    }

    public String getName() {
        return name;
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
    public void removeArmies(int armiesToRemove) {
        if (armiesToRemove > 0) {
            if (this.totalArmyUnit >= armiesToRemove) {
                this.totalArmyUnit -= armiesToRemove;
            }
        }
    }
    public Map<Integer, Territory> getAdjacencyList() {
        return adjacencyList;
    }

    public void addConnection(Territory neighbor) {

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
