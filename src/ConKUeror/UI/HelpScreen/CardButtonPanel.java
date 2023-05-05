package src.ConKUeror.UI.HelpScreen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class CardButtonPanel extends JPanel {



    public CardButtonPanel(JButton territoryButton, JButton armyButton, JButton chanceButton) {

        setLayout(new GridLayout(1, 3)); // Create a panel to hold the buttons
        add(territoryButton);
        add(armyButton);
        add(chanceButton);


        territoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TerritoryCardScreen();
            }
        });

        armyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ArmyCardScreen();
            }
        });
        
        chanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChanceCardScreen();
            }
        });

        
     
    }
}