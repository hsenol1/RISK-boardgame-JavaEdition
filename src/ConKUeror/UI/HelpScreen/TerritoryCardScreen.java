package src.ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TerritoryCardScreen extends JFrame {
    public TerritoryCardScreen() {

        JFrame gameMapFrame = new JFrame("TerritoryCards Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      
        gameMapFrame.setVisible(true);

     


   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus( "\n \n \n \n \n                           Territory Cards\n\n" +
        "There will be territory cards as many as the number of territories in the game. During the game, the aim of collecting territory" +
        "cards is to conquer a continent without attacking. \n When the player collects all territory cards of a continent, the player conquers all territories"+
        " of that continent without a need to attack these territories. \n\n");

        textAreaPlus.setFont(new Font("Times New Roman",Font.PLAIN,20));
        

        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("armies.jpg"));
            textAreaPlus.setImage(icon);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        textAreaPlus.setForeground(Color.white);

        gameMapFrame.add(textAreaPlus); // size the frame to fit the label





    }

}
