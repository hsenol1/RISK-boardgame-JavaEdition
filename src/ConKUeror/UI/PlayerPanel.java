package src.ConKUeror.UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.ConKUeror.domain.controller.ButtonHandler;
import src.ConKUeror.domain.model.Modes.StartMode;
import src.ConKUeror.domain.model.Player.Player;

public class PlayerPanel extends JPanel{

    private ButtonHandler buttonHandler;

    private int playerCount;
    private int eachPlayerInfoWidth = 150;
    private int playerInfoHeight = 30;
    private List<Player> orderedPlayers;


    public PlayerPanel(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        playerCount = StartMode.getOrderedPlayerList().size();

        setBounds(300 ,724 ,eachPlayerInfoWidth*playerCount, playerInfoHeight);

         orderedPlayers=buttonHandler.getBuildMode().getPlayers();

         for (Player p :    orderedPlayers){

        JLabel playerNameLabel = new JLabel(p.getName());
        JLabel armyCountLabel = new JLabel(Integer.toString(p.getInventory().getTotalArmy()));
        add(playerNameLabel);
        add(armyCountLabel);
    }


   }




    public void setPanel(){



    } 





}
