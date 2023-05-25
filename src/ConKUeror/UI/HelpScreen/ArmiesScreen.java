package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ArmiesScreen extends JFrame {
    public ArmiesScreen() {

        JFrame gameMapFrame = new JFrame("Armies Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      
        gameMapFrame.setVisible(true);

     


   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus("Armies \n"+
        "The game comprises of 6 sets of armies, each set including 3 types of army pieces: Infantry, which holds a value of 1; Cavalry, worth 5 \n"+
        "Infantry; and Artillery, worth either 10 Infantry or 2 Cavalry. At the beginning of the game, Infantry pieces are placed. As the game \n"+
        "progresses, players can exchange 5 Infantry for 1 Cavalry, or trade in 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.\n\n");

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
