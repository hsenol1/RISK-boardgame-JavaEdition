package src.ConKUeror.domain.model.Player;


import java.util.List;
import java.util.ArrayList;

import src.ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerAttack;
import src.ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerDeploy;
import src.ConKUeror.domain.model.Player.Strategies.ComputerPlayer.ComputerPlayerFortify;
import src.ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerAttack;
import src.ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerDeploy;
import src.ConKUeror.domain.model.Player.Strategies.RealPlayer.RealPlayerFortify;

public class PlayerFactory {

    //PlayerFactory is implemented with singleton pattern.

    private static PlayerFactory instance;
    private PlayerFactory() {};
    private List<String> playerNames = new ArrayList<String>();


    public static PlayerFactory getInstance() {
        if(instance==null) {
            instance = new PlayerFactory();
        }
        return instance;

    }

    public Player createPlayer(String type,String name) {
        
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
            playerNames.add(name);
           }

       }

       else if (type.equals("Computer Player")) {
       
            PlayerInventory inv = new PlayerInventory();
            ComputerPlayerDeploy db = new ComputerPlayerDeploy();
            ComputerPlayerAttack ab = new ComputerPlayerAttack();
            ComputerPlayerFortify fb = new ComputerPlayerFortify();

            player = new Player(name, db, ab, fb,inv);

       }

       else {
        throw new IllegalArgumentException("Invalid player type: " + type);
       }

       return player;
        
        
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
