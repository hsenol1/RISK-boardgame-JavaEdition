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
    Player player;
    int player_index;

    public void waitAndExecute(Runnable action) {
        int delay = 2000; // delay for 1 second.
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
        waitAndExecute(() -> {
            player = PlayerExpert.getPlayerInTurn();
            System.out.println("PLAYER " + player.getName());
            player_index = PlayerExpert.getPlayersList().indexOf(player);

            PlayerExpert.updatePlayerCount(player_index);

            // After the above task is done and we waited for 1 second, continue with the following tasks
            SwingUtilities.invokeLater(() -> {
                System.out.println("COMPUTER DEPLOY YAPIYOR");
                System.out.println("DEPLOYLANICAK TERRITORY" + t.getId());
                System.out.println("DEPLOYLANICAK ARMY" + army);

                if (t == null) {
                    return;
                }

                t.addInfantries(army);
                player.getInventory().removeInfantries(army);
                System.out.println("PLAYER INDEXIM" + player_index);
                PlayerExpert.updatePlayerCount(player_index);

                MapHandler mapHandler = HandlerFactory.getInstance().giveMapHandler();
                int buttonId = t.getId();
                int result = t.getTotalUnit();

                // After the above tasks are done, we wait again for 1 second and then do the following
                waitAndExecute(() -> {
                    mapHandler.updateTerritory(buttonId, result);
                });
            });
        });
    }



}
