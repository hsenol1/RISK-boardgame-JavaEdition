package src.ConKUeror.model.Board;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.model.Army;

public class Territory {
    
    private String name;
    private List<Array> armies;

    public Territory(String name) {
        this.name = name;
        this.armies = new ArrayList<>();
    }

    public void addArmy(Army army) {
        // TODO: Implement army addition logic
    }

    public void removeArmy(Army army) {
        // TODO: Implement army removal logic
    }
}
