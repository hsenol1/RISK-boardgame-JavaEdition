package ConKUeror.domain.model.Player;


import java.util.List;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerAttack;
import ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerDeploy;
import ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerFortify;
import ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerAttack;
import ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerDeploy;
import ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerFortify;

public class PlayerFactory implements Serializable {

    //PlayerFactory is implemented with singleton pattern.

    private static PlayerFactory instance;
    private PlayerFactory() {};
    private List<String> playerNames = new ArrayList<String>();
    private List<Color> playerColors;
    public int colorIndex= 0;

    public static PlayerFactory getInstance() {
        if(instance==null) {
            instance = new PlayerFactory();
        }
        return instance;

    }

    public void setColorList(List<Color> colors) {
        this.playerColors = colors;

    }

    public Player createColoredPlayer(String type,String name, Color color) {

        Player player=null;

        if (name == null) {
            throw new IllegalArgumentException("Player name cannot be null");
        }

       if(type.equals("Real Player")) {

           PlayerInventory inv = new PlayerInventory();
           RealPlayerDeploy db =new RealPlayerDeploy();
           RealPlayerAttack ab =new RealPlayerAttack();
           RealPlayerFortify fb =new RealPlayerFortify();

           if (searchName(name) && (name.length() != 0)) {

            player = new Player(name,db,ab,fb,inv);

            player.setType("Real");

            player.setColor(color);
            playerNames.add(name);
           }

       }

       else if (type.equals("Computer Player")) {

            PlayerInventory inv = new PlayerInventory();
            ComputerPlayerDeploy db = new ComputerPlayerDeploy();
            ComputerPlayerAttack ab = new ComputerPlayerAttack();
            ComputerPlayerFortify fb = new ComputerPlayerFortify();


            player = new Player(name, db, ab, fb,inv);


            player.setType("Computer");


            player.setColor(color);

       }

       else {
        throw new IllegalArgumentException("Invalid player type: " + type);
       }

       return player;


    }
     /*
     * Function: createPlayer
     * 
     * Requires: 
     *      - type: a String representing the type of player ("Real Player" or "Computer Player")
     *      - name: a String representing the name of the player. It should not be null or empty.
     * 
     * Modifies: 
     *      - playerNames: If the name is unique and the player is a "Real Player", the name is added to the list of player names.
     *      - colorIndex: the colorIndex is incremented each time a player is created.
     *      - Player object: The function creates a new Player object with the given type, name, and color.
     *      
     * Effects: 
     *      - Returns a new Player object if the type and name are valid.
     *      - Throws IllegalArgumentException if the type is not valid or the name is null.
     *      - If the player type is "Real Player" and the name is not unique or is an empty string, the function returns null.
     * 
     */
    public Player  createPlayer(String type,String name) {

        Player player=null;

        if (name == null) {
            throw new IllegalArgumentException("Player name cannot be null");
        }

       if(type.equals("Real Player")) {

           PlayerInventory inv = new PlayerInventory();
           RealPlayerDeploy db =new RealPlayerDeploy();
           RealPlayerAttack ab =new RealPlayerAttack();
           RealPlayerFortify fb =new RealPlayerFortify();

           if (searchName(name) && (name.length() != 0)) {

            player = new Player(name,db,ab,fb,inv);

            player.setType("Real");

            setColorToPlayer(player);
            playerNames.add(name);
           }

       }

       else if (type.equals("Computer Player")) {

            PlayerInventory inv = new PlayerInventory();
            ComputerPlayerDeploy db = new ComputerPlayerDeploy();
            ComputerPlayerAttack ab = new ComputerPlayerAttack();
            ComputerPlayerFortify fb = new ComputerPlayerFortify();


            player = new Player(name, db, ab, fb,inv);


            player.setType("Computer");


            setColorToPlayer(player);

       }

       else {
        throw new IllegalArgumentException("Invalid player type: " + type);
       }

       return player;


    }

    public void setColorToPlayer(Player player) {
        player.setColor(playerColors.get(colorIndex));
        colorIndex++;
        if (colorIndex >= playerColors.size()) {
            colorIndex = 0;
        }
    }
    public void resetPlayerNames() {
        playerNames = new ArrayList<String>();
    }


    public boolean searchName(String playerName) {
        for (int i = 0; i < playerNames.size(); i++) {
            if (playerName.equals(playerNames.get(i))) {
                return false;
            }
        }

        return true;
    }


}
