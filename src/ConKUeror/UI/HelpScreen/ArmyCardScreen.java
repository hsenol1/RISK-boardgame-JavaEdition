package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ArmyCardScreen extends JFrame {
    public ArmyCardScreen() {

        JFrame gameMapFrame = new JFrame("ArmyCards Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      
        gameMapFrame.setVisible(true);

     


   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus( "Army Cards\nThere will be three types of army cards for infantry, cavalry, and artillery." + 
        "For each player in the game, there will be three infantry, two cavalry, and one artillery card. Thus, the total number of army cards will be as follows:\n \n# "+
        "of army cards = # of players x (3 Infantry + 2 Cavalry + 1 Artillery)\n\nA player can trade army cards to gain an additional army if she/he has a set of 3 cards."+ 
       "He/she can place new armies in any territories she/he has. The rules of gaining armies is as follows:\n\n3 Infantry cards => 1 Cavalry\n2 Infantry cards + 1 Cavalry card => 2"+
         "Cavalry\n2 Infantry cards + 1 Artillery card => 2 Artillery\n1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery\n1 Artillery + 2 Cavalry cards => 3 Artillery\nNOTE:"+
          "If you have collected a set of territory and/or army cards, you may turn them in at the beginning of your next turn to conquer a continent or gain soldiers.\n\n"+
          "NOTE: If the territory and army cards end before the game ends, they are shuffled and used again. Therefore, a player who has conquered a continent using territory"+
          "cards may lose that continent to another player later in the game.\n\n");

        textAreaPlus.setFont(new Font("Times New Roman",Font.PLAIN,20));
        

        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("armies.jpg"));
            textAreaPlus.setImage(icon);
        } catch (Exception e) {

        }
  
        textAreaPlus.setForeground(Color.white);

        gameMapFrame.add(textAreaPlus); // size the frame to fit the label





    }

}
