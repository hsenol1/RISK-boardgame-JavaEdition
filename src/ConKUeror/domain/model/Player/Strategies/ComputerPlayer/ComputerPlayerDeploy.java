package ConKUeror.domain.model.Player.Strategies.ComputerPlayer;

import java.io.Serializable;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.controller.MapHandler;

import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.Strategies.IDeployBehaviour;

public class ComputerPlayerDeploy implements IDeployBehaviour,Serializable{


    public void waitAndExecute(Runnable action) {
        int delay = 1000; // delay for 1 second.
        Timer timer = new Timer(delay, null);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SwingUtilities.invokeLater(action);
                timer.stop(); // stop the timer after it fires
            }
        };
        timer.addActionListener(taskPerformer);
        timer.start();
    }



    @Override
    public void deploy(Territory t, int army) {
        // TODO Auto-generated method stub


        if (t == null) {
            return; }

        t.addInfantries(army);
        Player player = PlayerExpert.getPlayerInTurn();
        int player_index =PlayerExpert.getPlayersList().indexOf(player);

        player.getInventory().removeInfantries(army);

        PlayerExpert.updatePlayerCount(player_index);

        MapHandler mapHandler =  HandlerFactory.getInstance().giveMapHandler();

        int buttonId = t.getId();
        int result = t.getTotalUnit();

        waitAndExecute(() -> {
            mapHandler.updateTerritory(buttonId,result);
        });

    }


}
