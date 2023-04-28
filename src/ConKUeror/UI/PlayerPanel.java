package src.ConKUeror.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import src.ConKUeror.domain.controller.ButtonHandler;
import src.ConKUeror.domain.model.Modes.StartMode;
import src.ConKUeror.domain.model.Player.Player;

public class PlayerPanel extends JPanel{

    private ButtonHandler buttonHandler;

    private int playerCount;
    private List<Player> orderedPlayers;

    Border blackBorder;
    Border padding;
    int panelWidth;
    int panelHeight;


    public PlayerPanel(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;

        playerCount = StartMode.getOrderedPlayerList().size();
        setLayout(new GridLayout(1, playerCount));
        orderedPlayers=StartMode.getOrderedPlayerList();

        setUI();
        setPlayerInfos();
   }

   public void setUI() {

     blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
     padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        int screenWidth = 1115;
        int availableWidth = screenWidth - 450;
        panelWidth = availableWidth / playerCount;
        panelHeight = 30;

        int startX = 460;
        int startY = 5;

        setBounds(startX, startY, panelWidth * playerCount, panelHeight);
        setPreferredSize(new Dimension(panelWidth * playerCount, panelHeight));

   }
   

   public void setPlayerInfos() {
        for (Player p : orderedPlayers){
            JPanel playerInfoPanel = new JPanel();

        playerInfoPanel.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));
        playerInfoPanel.setBackground(Color.WHITE);
        JLabel playerNameLabel = new JLabel(p.getName() + ":");
        String army = Integer.toString(p.getInventory().getTotalArmy());
        JLabel armyCountLabel = new JLabel(army);
        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        playerNameLabel.setFont(labelFont);
        armyCountLabel.setFont(labelFont);

        
        playerInfoPanel.add(playerNameLabel);
        playerInfoPanel.add(armyCountLabel);

    
        playerInfoPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
    
        add(playerInfoPanel);
        
    
    }
}




    public void setPanel(){



    } 





}
