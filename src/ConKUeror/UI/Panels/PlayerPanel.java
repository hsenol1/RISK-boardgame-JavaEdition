package src.ConKUeror.UI.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import src.ConKUeror.UI.Buttons.CustomButton;
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
            JPanel playerInfoPanel = new JPanel(new BorderLayout());


            playerInfoPanel.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));
            playerInfoPanel.setBackground(Color.WHITE);

            String playerInfoText= p.getName() + ":" + Integer.toString(p.getInventory().getTotalArmy());
            Font labelFont = new Font("Arial", Font.PLAIN, 12);
            CustomButton playerInfoButton = new CustomButton(playerInfoText, labelFont, Color.WHITE);


            JPanel emptyPanel = new JPanel();
            emptyPanel.setOpaque(false);

            playerInfoPanel.add(playerInfoButton, BorderLayout.CENTER);
            playerInfoPanel.add(emptyPanel, BorderLayout.SOUTH);


            add(playerInfoButton);
    }
}




    public void setPanel(){



    }





}
