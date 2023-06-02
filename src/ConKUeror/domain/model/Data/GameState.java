package ConKUeror.domain.model.Data;

import java.io.Serializable;
import java.util.List;

import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;

public class GameState implements Serializable{
    private List<Player> players;
    private List<PlayerData> playerDataList;
    private Player playerInTurn;
    private List<Player> orderedList;
    private GameLogic gameLogic;
    private int phaseIndex;
    public GameState(List<PlayerData> playerDataList,GameLogic gameLogic){
        this.playerDataList = playerDataList;
        this.playerInTurn = PlayerExpert.getPlayerInTurn();
        this.orderedList = PlayerExpert.getPlayersList();
        this.gameLogic = gameLogic;
        this.phaseIndex = gameLogic.getGamePhaseAsIndex();
    }
    public List<PlayerData> getPlayerData(){
        return playerDataList;
    }
    public int getGamePhase(){
        return phaseIndex;
    }
    public Player getPlayerInTurn(){
        return playerInTurn;
    }
    public List<Player> getOrderedList(){
        return orderedList;
    }
}
