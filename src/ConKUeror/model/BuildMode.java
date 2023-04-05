package src.ConKUeror.model;

import java.util.List;

public class BuildMode {

private static final int PLAYER_LIMIT = 6;

private int playerCount;
private List<Player> players;

public Boolean validatePlayerNumber(int humanPlayerNumber,int botPlayerNumber ) {

    //checks at least one player is computer
    //game is played with 2-6 people
    //except computer player, other players must be real person

    if(botPlayerNumber<1 ||  humanPlayerNumber<1 || (botPlayerNumber + humanPlayerNumber) > PLAYER_LIMIT) {
        return false;
    }

    playerCount = humanPlayerNumber + botPlayerNumber;
    return true;

}

public List<Player> getPlayers() {
    return players;
}


public void initalizePlayer(String name) {
    
    Player player = PlayerFactory.createPlayer(name);
    players.add(player);


}




}











