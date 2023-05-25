package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MapScreen extends JFrame {
    public MapScreen() {

        JFrame gameMapFrame = new JFrame("GameMap Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

      
      
        gameMapFrame.setVisible(true);

     


   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus( "Game Map\n"+
        "The initial game map comprises of 42 territories divided among 6 continents, with each continent colored differently and consisting of 4 to \n"+
        "12 territories. Players follow the rules to allocate their armies across theses territories.  \n"+
        "However, during the building mode, it is feasible to activate or deactivate certain continents and territories.\n\n");

        textAreaPlus.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("gameMap.jpg"));
            textAreaPlus.setImage(icon);
        } catch (Exception e) {
            // TODO: handle exception
        }
  
        //textAreaPlus.setForeground(Color.white);

        gameMapFrame.add(textAreaPlus); // size the frame to fit the label





    }

}
