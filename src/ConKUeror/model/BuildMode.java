package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.List;

public class BuildMode {

private List<Player> players = new ArrayList<Player>();


public List<Player> getPlayers() {
    return this.players;
}


public void initalizePlayer(String name) {
    
    Player player = PlayerFactory.createPlayer(name);
    players.add(player);


}




}











