package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.controller.BuildModeListener;
import src.ConKUeror.model.Board.Coordinate;
import src.ConKUeror.model.Player.Player;
import src.ConKUeror.model.Player.PlayerFactory;

public class BuildMode {

private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
private List<Player> players = new ArrayList<Player>();
private List<BuildModeListener> listeners = new ArrayList<>();
private int humanPlayerCount;
public static int botPlayerCount;
private int index;
PlayerFactory playerFactory;
private boolean canStart = false;


public BuildMode() {
    playerFactory = PlayerFactory.getInstance();
    fillCoordinates();
}

public List<Player> getPlayers() {
    return this.players;
}


public void fillCoordinates() {

    coordinates.add(new Coordinate(69, 103));
    coordinates.add(new Coordinate(171, 102));
    coordinates.add(new Coordinate(368, 60));
    coordinates.add(new Coordinate(155, 164));
    coordinates.add(new Coordinate(232, 182));
    coordinates.add(new Coordinate(303, 175));
    coordinates.add(new Coordinate(162, 236));
    coordinates.add(new Coordinate(249, 271));
    coordinates.add(new Coordinate(178, 342));
    coordinates.add(new Coordinate(246, 402));
    coordinates.add(new Coordinate(264, 505));
    coordinates.add(new Coordinate(343, 478));
    coordinates.add(new Coordinate(266, 597));
    coordinates.add(new Coordinate(439, 228));
    coordinates.add(new Coordinate(463, 141));
    coordinates.add(new Coordinate(532, 151));
    coordinates.add(new Coordinate(643, 199));
    coordinates.add(new Coordinate(545, 236));
    coordinates.add(new Coordinate(455, 341));
    coordinates.add(new Coordinate(564, 304));
    coordinates.add(new Coordinate(501, 453));
    coordinates.add(new Coordinate(585, 416));
    coordinates.add(new Coordinate(634, 495));
    coordinates.add(new Coordinate(583, 542));
    coordinates.add(new Coordinate(594, 638));
    coordinates.add(new Coordinate(692, 641));
    coordinates.add(new Coordinate(666, 372));
    coordinates.add(new Coordinate(733, 257));
    coordinates.add(new Coordinate(751, 170));
    coordinates.add(new Coordinate(813, 127));
    coordinates.add(new Coordinate(896, 85));
    coordinates.add(new Coordinate(978, 93));
    coordinates.add(new Coordinate(880, 178));
    coordinates.add(new Coordinate(893, 248));
    coordinates.add(new Coordinate(1000, 260));
    coordinates.add(new Coordinate(861, 321));
    coordinates.add(new Coordinate(791, 373));
    coordinates.add(new Coordinate(888, 415));
    coordinates.add(new Coordinate(906, 545));
    coordinates.add(new Coordinate(999, 502));
    coordinates.add(new Coordinate(948, 641));
    coordinates.add(new Coordinate(1041, 616));


}

public ArrayList<Coordinate> getCoordinateList() {
    return coordinates;
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











