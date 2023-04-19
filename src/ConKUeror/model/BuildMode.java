package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.controller.BuildModeListener;
import src.ConKUeror.model.Player.Player;
import src.ConKUeror.model.Player.PlayerFactory;

public class BuildMode {

private List<Player> players = new ArrayList<Player>();
private List<BuildModeListener> listeners = new ArrayList<>();
private int humanPlayerCount;
public static int botPlayerCount;
private int index;
PlayerFactory playerFactory;
private boolean canStart = false;


public BuildMode() {
    playerFactory = PlayerFactory.getInstance();
}

public List<Player> getPlayers() {
    return this.players;
}


public void initalizePlayer(String name,String type) {

    Player player = playerFactory.createPlayer(type, name);
    players.add(player);

}

public Boolean validatePlayerNums(int totalPlayerNumber, int botPlayerNumber) {

    if(botPlayerNumber<totalPlayerNumber) {

        botPlayerCount =botPlayerNumber;
        humanPlayerCount = totalPlayerNumber- botPlayerNumber;   
        index = humanPlayerCount;

        handleMenuLogicAndPlayerCreation();

        return true;

    } 
    return false;

    }

    
   
    public void handleMenuLogicAndPlayerCreation() {

        while(index !=0) {
            index--;
            String message =  String.format("Enter player %d name:", (humanPlayerCount-index));
            publishBoardEvent(message);             
        }
    }


    public void setStart() {
          canStart = true;

    }

    public Boolean getStartStatus() {
        return canStart; 
    }

    

public void addBuildModeListener(BuildModeListener lis) {
    listeners.add(lis);
}


private void publishBoardEvent(String message) {
    for(BuildModeListener l: listeners){
        l.onBoardEvent(message);

    }
       
}





}











