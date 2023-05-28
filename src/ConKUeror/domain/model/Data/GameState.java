package ConKUeror.domain.model.Data;

import java.io.Serializable;
import java.util.List;

import ConKUeror.domain.model.Player.Player;

public class GameState implements Serializable{
    private List<Player> players;
    private List<PlayerData> playerDataList;
    
    public GameState(List<PlayerData> playerDataList){
        this.playerDataList = playerDataList;
    }
    public List<PlayerData> getPlayerData(){
        return playerDataList;
    }
}
