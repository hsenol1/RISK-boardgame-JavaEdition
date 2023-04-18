package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.controller.BuildModeListener;

public class BuildMode {

private List<Player> players = new ArrayList<Player>();
private List<BuildModeListener> listeners = new ArrayList<>();
private int humanPlayerCount;
private int index;


public List<Player> getPlayers() {
    return this.players;
}


public void initalizePlayer(String name) {
    
    Player player = PlayerFactory.createPlayer(name);
    players.add(player);


}

public Boolean validatePlayerNums(int totalPlayerNumber, int botPlayerNumber) {

    if(botPlayerNumber<totalPlayerNumber) {
        
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


//addPropertyListener( PropertyListener lis ) 
//method for publisher
public void addBuildModeListener(BuildModeListener lis) {
    listeners.add(lis);
}

//publishPropertyEvent(name, value)
//method for publisher


//bu methoda modelim değişince view ın ne yapmasını istediğimi yazıcam
private void publishBoardEvent(String message) {
    for(BuildModeListener l: listeners){
        l.onBoardEvent(message);

    }
       
}





}











