package src.ConKUeror.model.Board;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.model.Army;

public class Territory {
    
   // private String name;
    private int id;
    private List<Array> armies;
    private boolean isFree;

    public Territory(int _id) {
         //this.name = name;

        this.id = _id;
        this.armies = new ArrayList<>();
        this.isFree = true;
    }

    public void addArmy(Army army) {
        // TODO: Implement army addition logic
    }

    public void removeArmy(Army army) {
        // TODO: Implement army removal logic
    }

    
}
