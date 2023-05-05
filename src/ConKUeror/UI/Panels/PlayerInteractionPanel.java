package src.ConKUeror.UI.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import src.ConKUeror.UI.Buttons.ActionButton;
import src.ConKUeror.domain.controller.ButtonHandler;
import src.ConKUeror.domain.controller.GameHandler;
import src.ConKUeror.domain.model.Modes.GameLogic;

public class PlayerInteractionPanel extends JPanel{

    private ButtonHandler buttonHandler;
    private GameHandler gameHandler;
    int buttons_num = 3;

    Border blackBorder;
    Border padding;
    int panelWidth;
    int panelHeight;
    public String[][] buttonNames =  {
        {"Add Connections", "Remove Territory", "Next"},
        {"Set Game Order","Place Army","Next"},
        {"Pick Chance Card","Card Info","Next"},
        {"Deploy Army","Select Army","Next"},
        {"Attack","Select Army","Next"},
        {"Fortify Army","Select Army" ,"Next"},
        {"Fortify Army","Select Army" ,"End Turn"},
        {"Pick Army Card","Card Info", "End Turn"},
        {"Pick Territory Card","Card Info","End Turn"}};

    public PlayerInteractionPanel(ButtonHandler buttonHandler, GameHandler gameHandler) {

        this.buttonHandler = buttonHandler;
        this.gameHandler = gameHandler;

       // buttons_num = GameLogic.getButtonCount();
        setLayout(new GridLayout(buttons_num, 1));

        setUI();
        setPanel();
    }




       public void setUI() {

        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

            panelWidth = 130;
            panelHeight = 300;

           int startX = 40;
           int startY = 400;

          setBounds(startX, startY, panelWidth , panelHeight);
          setPreferredSize(new Dimension(panelWidth, panelHeight));

      }




public void setPanel() {

    for(int i = 0 ; i<buttons_num ; i++) {

        JPanel interactionPanelContainer = new JPanel(new BorderLayout());
        interactionPanelContainer.setBorder(BorderFactory.createCompoundBorder(blackBorder, padding));
        interactionPanelContainer.setBackground(Color.WHITE);

        int p_index = GameLogic.getGamePhaseAsIndex();
        String buttonName = buttonNames[p_index][i];
        int[] id = {p_index,i};

        Font labelFont = new Font("Arial", Font.PLAIN, 10);


        ActionButton actionButton = new ActionButton(buttonName, labelFont, id ,Color.WHITE);
        actionButton.addActionListener(actionButton);


        JPanel emptyPanel = new JPanel();
        emptyPanel.setOpaque(false);

        interactionPanelContainer.add(actionButton,BorderLayout.CENTER);
        interactionPanelContainer.add(emptyPanel, BorderLayout.SOUTH);

        add(actionButton);

    }
}

}










