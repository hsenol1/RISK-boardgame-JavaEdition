package ConKUeror.UI.HelpScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ChanceCardScreen2 extends JFrame {
    public ChanceCardScreen2() {

        JFrame gameMapFrame = new JFrame("ArmyCards Window");
        gameMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameMapFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      
        gameMapFrame.setVisible(true);

     


   

        JTextAreaPlus textAreaPlus = new JTextAreaPlus( "Chance Cards\n\n"+ 
            "“Disaster”: This card causes a natural disaster to strike a certain continent, affecting all players who control territories on that continent. The disaster causes a certain number of armies to be lost \n on each territory, and the player with the fewest armies on each territory loses control of it.\n"
+ "“Draft”: This card allows you to draw two additional army cards at the end of your turn.\n"
+ "“Bombardment”: You can use this card to attack a territory with a barrage of artillery, allowing you to roll two dice instead of one for that attack.\n"
+ "“Rebellion”: This card allows you to incite a rebellion in one of your opponent's territories, causing half/percentage of their armies there to switch to your side.\n"
+ "“Decoy”: This card allows you to place a fake army onto a territory you control, tricking your opponent into thinking it is a stronger position than it actually is.\n"
+ "“Nuclear Strike”: This card allows you to wipe out all armies in one territory, regardless of how many there are, but at the cost of destroying one of your own territories as well.\n"
+ "“Revolt”: Play this card on your turn to remove all armies from one of your territories and add them to another.\n"
+ "“Trade Deal”: Play this card to trade one territory card of your choice with an opponent.\n"
+ "“Secret Weapon”: Play this card to reveal and use one of your opponent's unplayed territory or army cards.\n"
+ "“World Event”: Roll a die. On a 1-2, all players receive three extra armies. On a 3-4, all players lose three armies. On a 5-6, all players exchange one territory they control with another player \n of their choice.");

        textAreaPlus.setFont(new Font("Times New Roman",Font.PLAIN,20));
        

        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("armies.jpg"));
            textAreaPlus.setImage(icon);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        //textAreaPlus.setForeground(Color.white);

        gameMapFrame.add(textAreaPlus); // size the frame to fit the label





    }

}
