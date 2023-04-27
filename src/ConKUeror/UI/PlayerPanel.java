package src.ConKUeror.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
       setLayout(new GridLayout(1, playerCount));


        //setBounds(540 ,5 ,eachPlayerInfoWidth*playerCount, playerInfoHeight);
        //setPreferredSize(new Dimension(eachPlayerInfoWidth * playerCount, playerInfoHeight));

         orderedPlayers=buttonHandler.getBuildMode().getPlayers();


         Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
         Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

         int screenWidth = 1115;
         int screenHeight = 770;
 
         // Calculate the panel dimensions
         //int maxPanelWidth = screenWidth / 3;
         //int minPanelWidth = screenWidth / 6;
         //int panelWidth = Math.min(maxPanelWidth, screenWidth / playerCount);
         //panelWidth = Math.max(minPanelWidth, panelWidth);
         int availableWidth = screenWidth - 450;
        int panelWidth = availableWidth / playerCount;
         int panelHeight = 30;

         int startX = 460;
        int startY = 5;

        setBounds(startX, startY, panelWidth * playerCount, panelHeight);
        setPreferredSize(new Dimension(panelWidth * playerCount, panelHeight));

         for (Player p : orderedPlayers){
            JPanel playerInfoPanel = new JPanel();

        playerInfoPanel.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));
        playerInfoPanel.setBackground(Color.gray);
        JLabel playerNameLabel = new JLabel(p.getName() + ":");
        JLabel armyCountLabel = new JLabel(Integer.toString(p.getInventory().getTotalArmy()));
        
        playerInfoPanel.add(playerNameLabel);
        playerInfoPanel.add(armyCountLabel);
       
        playerInfoPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
       
        add(playerInfoPanel);
        
        //add(playerNameLabel);
        //add(armyCountLabel);
    }


   }




    public void setPanel(){



    } 





}
