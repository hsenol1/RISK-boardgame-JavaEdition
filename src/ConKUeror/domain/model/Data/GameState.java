package ConKUeror.domain.model.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameState {
    private String turn;
    private Map<String, Integer> territoryArmies;
    private int currentTurn;
    private String mapState;
    public GameState(String turn,String mapState) {
        this.turn = turn;
        this.mapState = mapState;
    }

    public String getTurn() {
        return turn;
    }
    public String getMapState(){
        return mapState;
    }
    public Map<String, Integer> getTerritoryArmies() {
        return territoryArmies;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    
    public void setCurrentTurn(int turn) {
        currentTurn = turn;
    }

    public void setTerritoryArmies(Map<String, Integer> territoryArmies) {
        this.territoryArmies = territoryArmies;
    }

    @Override
    public String toString() {
        return turn + "," + mapState; // Only include turn and mapState
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    GameState other = (GameState) obj;
    return Objects.equals(turn, other.turn) && Objects.equals(mapState, other.mapState);
}
    public static GameState fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length < 2) {
            return null;
        }
        String turn = parts[0];
        String mapState = parts[1];
        return new GameState(turn, mapState);
    } 
}
