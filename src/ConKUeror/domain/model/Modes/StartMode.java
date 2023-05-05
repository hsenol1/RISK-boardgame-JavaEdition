package src.ConKUeror.domain.model.Modes;

import java.util.ArrayList;
import java.util.List;

import src.ConKUeror.domain.model.Player.Player;

public class StartMode {
    private int playerCount;
    private BuildMode buildMode;
    private static List<Player> orderedPlayerList;

    public StartMode(BuildMode buildMode) {

        this.buildMode=buildMode;

    }

    public void setStartMode() {
        setGameOrder();
        setOrderedList();
        setInitialInfantries();
    }

    public void setPlayerCount() {
        playerCount= buildMode.getPlayerCount();
    }
    public int getPlayerCount() {
        return playerCount;
    }

    public void setInitialInfantries() {
            int inf_count;

            if(playerCount == 2) {
                inf_count=40;
            } else if( playerCount==3) {
                inf_count = 35;
            }else if( playerCount==4) {
                inf_count = 30;
             }else if( playerCount==5) {
                inf_count = 25;
             }else {
                inf_count = 20;
                }

            for(Player player : buildMode.getPlayers()) {
                player.getInventory().addInfantries(inf_count);
            }




    }

//viewa taşı,teknik olarak view la alakalı bir fonksiyon
    public String getInitialMessage() {

        String message = "You can select the territories that you don't want to be in the game! \n "+
        "Click the territory and press Remove Button.\n  " +
        "When you are ready press the Next Button";

        return message;

    }

    public void setGameOrder() {

    //set the order array according to dice rolls
    }


    public void setOrderedList() {

        //arrange orderedPlayerList according to order array

        orderedPlayerList = buildMode.getPlayers();


    }

    public static List<Player> getOrderedPlayerList() {

        return orderedPlayerList;
    }

    public void setOrderedAfterRoll(Player player) {
        int index = orderedPlayerList.indexOf(player);
        List<Player> orderList = new ArrayList<Player>();

        for (int i = 0; i < orderedPlayerList.size(); i++) {
            orderList.add(orderedPlayerList.get((index - i + orderedPlayerList.size() ) % orderedPlayerList.size()));
        }


        orderedPlayerList = orderList;
    }





}
