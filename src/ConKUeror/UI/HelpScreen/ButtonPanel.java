import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonPanel extends JPanel {

    public ButtonPanel(JButton gameMapButton, JButton armiesButton, JButton cardsButton) {

        setLayout(new GridLayout(1, 3)); // Create a panel to hold the buttons
        add(gameMapButton);
        add(armiesButton);
        add(cardsButton);


        gameMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MapScreen();
            }
        });

        armiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ArmiesScreen();
            }
        });
        
        cardsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CardsScreen();
            }
        });
    }



}