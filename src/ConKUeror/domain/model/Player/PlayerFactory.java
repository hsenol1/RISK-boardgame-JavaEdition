package src.ConKUeror.domain.model.Player;


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

    public static PlayerFactory getInstance() {
        if(instance==null) {
            instance = new PlayerFactory();
        }
        return instance;

    }

    public Player createPlayer(String type,String name) {
        
        Player player;

        if (name == null) {
            throw new IllegalArgumentException("Player name cannot be null");
        }

       if(type.equals("Real Player")) {

           PlayerInventory inv = new PlayerInventory();
           RealPlayerDeploy db =new RealPlayerDeploy();
           RealPlayerAttack ab =new RealPlayerAttack();
           RealPlayerFortify fb =new RealPlayerFortify();

         player = new Player(name,db,ab,fb,inv);

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

}
