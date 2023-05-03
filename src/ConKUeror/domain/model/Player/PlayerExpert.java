package src.ConKUeror.domain.model.Player;
import src.ConKUeror.domain.model.Player.Player;
import java.util.List;
import java.util.ArrayList;

public class PlayerExpert {


    private static PlayerExpert playerExpertInstance = null;
    private static List<Player> players = new ArrayList<Player>();

    private PlayerExpert() {

    }

    public static PlayerExpert getPlayerExpert() {
        if (playerExpertInstance == null) {
            playerExpertInstance = new PlayerExpert();
        }

        return playerExpertInstance;
    }
    

    public void addPlayersList(Player player) {
        players.add(player);
        System.out.println(player.getName() +  " was " + "HERE");
    }

    public static List<Player> getPlayersList() {  
        return players;
    }

    public static int getPlayersListSize() {
        return players.size();
    }
    
}
