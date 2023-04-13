package src.ConKUeror.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import src.ConKUeror.model.BuildMode;
import src.ConKUeror.model.Player;
import src.ConKUeror.view.BuildModeScreen;
import src.ConKUeror.view.BuildModeScreen.ResponsiveImage;

public class BuildModeController {
    

private BuildMode buildMode;
private BuildModeScreen buildModeScreen;


    public BuildModeController(BuildModeScreen bModeScreen, BuildMode bMode) {


        this.buildMode = bMode;
        this.buildModeScreen = bModeScreen;
        



        buildModeScreen.addHelpButtonListener(new HelpButtonListener());
        buildModeScreen.addConfirmButtonListener(new ConfirmButtonListener());



	}





	class ConfirmButtonListener implements ActionListener {
        
        int count = 0;
        int index; 
        int humanPlayer;    

		@Override
		public void actionPerformed(ActionEvent e) {

            //get player numbers
            if(count == 0) {
                int totalPlayerNumber= buildModeScreen.getPlayerNumberComboboxValue();
                int botPlayerNumber = buildModeScreen.getBotNumberComboboxValue();
                humanPlayer = totalPlayerNumber-botPlayerNumber;
                index = humanPlayer;
            }
            
            count++;

            //according to player numbers,open the name screen and creates the player
            if(index !=0) {
                index--;

              

                String playerName = buildModeScreen.openPanelForPlayerDetail((humanPlayer - index));
                System.out.println(String.format("(player name: %s", playerName));

                buildMode.initalizePlayer(playerName);
                
                for (Player player :    buildMode.getPlayers()) {
                    System.out.println(player.getName());
                }
                
            }

            if (index == 0) {
                ResponsiveImage startMode = new ResponsiveImage("src\\images\\worldMap.png");
            }
            
		

		}

	}

	class HelpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		

		}

	}
}
