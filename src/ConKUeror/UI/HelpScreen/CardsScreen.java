package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CardsScreen extends JFrame {
    public CardsScreen() {

        JFrame gameMapFrame = new JFrame("Cards Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

      
      
        gameMapFrame.setVisible(true);

        JButton territoryButton = new JButton("Territory Cards");
        JButton armyButton = new JButton("Army Cards");
        JButton chanceButton = new JButton("Chance Cards");
        JButton nextButton = new JButton("Next");

        CardButtonPanel cardPanel = new CardButtonPanel(territoryButton, armyButton, chanceButton);

   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus("Cards\n"+
        "The game will feature three types of cards: territory cards, chance cards, and army cards. At the start of each turn, you will select a \n"+
        "chance card, and by the end of any turn where you have conquered at least one territory, you will receive a randomly selected territory or \n"+
        "army card.\n");
        
        textAreaPlus.setFont(new Font("Times New Roman",Font.PLAIN,20));
        textAreaPlus.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the text
        textAreaPlus.setAlignmentY(Component.CENTER_ALIGNMENT);
        


        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("card.jpg"));
            textAreaPlus.setImage(icon);
        } catch (Exception e) {
            // TODO: handle exception
        }
     
       // textAreaPlus.setForeground(Color.white);

        gameMapFrame.add(textAreaPlus); // size the frame to fit the label

        gameMapFrame.add(cardPanel, BorderLayout.SOUTH); // Add the button panel to the frame  



    }

}
