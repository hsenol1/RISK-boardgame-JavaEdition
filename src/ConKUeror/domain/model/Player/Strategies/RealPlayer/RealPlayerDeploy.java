package src.ConKUeror.domain.model.Player.Strategies.RealPlayer;

import src.ConKUeror.domain.controller.HandlerFactory;
import src.ConKUeror.domain.controller.MapHandler;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerExpert;
import src.ConKUeror.domain.model.Player.Strategies.IDeployBehaviour;

public class RealPlayerDeploy implements IDeployBehaviour {

    @Override
    public void deploy(Territory t, int army) {
        // TODO Auto-generated method stub


        t.addInfantries(army);
        Player player = PlayerExpert.getPlayerInTurn();
        int player_index =PlayerExpert.getPlayersList().indexOf(player);

        player.getInventory().removeInfantries(army);

        PlayerExpert.updatePlayerCount(player_index);

       MapHandler mapHandler =  HandlerFactory.getInstance().giveMapHandler();

        int buttonId = t.getId();
        int result = t.getTotalUnit();

       mapHandler.updateTerritory(buttonId,result);
    }

}
