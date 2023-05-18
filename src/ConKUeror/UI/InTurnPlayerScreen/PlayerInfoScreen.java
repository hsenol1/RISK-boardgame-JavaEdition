package src.ConKUeror.UI.InTurnPlayerScreen;

import java.awt.Font;

import javax.swing.JFrame;

import src.ConKUeror.UI.HelpScreen.JTextAreaPlus;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerInventory;

public class PlayerInfoScreen extends JFrame {
    Player player; 

    public PlayerInfoScreen(Player player) {
        this.player = player;
        JFrame infoFrame = new JFrame("Introduction Window");

        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        infoFrame.setSize(400, 800);
        PlayerInventory pInv = player.getInventory();

        String name = player.getName();
        int armies = pInv.getNumberOfArmies();

        String territories = " "; 

        for (Territory t : pInv.getOwnedTerritories()) {
            territories += t.getName() + " ";
        }

        JTextAreaPlus textArea = new JTextAreaPlus("The Player Name: " + name + "\n" + "Total Army Unit: " + armies 
        + "\n" + "The territories owned: " + territories.toString() + "\n");

        textArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        infoFrame.add(textArea);


        infoFrame.setVisible(true);
    }


    
}
