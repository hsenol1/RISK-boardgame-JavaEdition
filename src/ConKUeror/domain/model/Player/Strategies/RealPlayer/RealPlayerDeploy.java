package ConKUeror.domain.model.Player.Strategies.RealPlayer;

import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.controller.MapHandler;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.Strategies.IDeployBehaviour;

public class RealPlayerDeploy implements IDeployBehaviour {

    @Override
    public void deploy(Territory t, int army) {
        // TODO Auto-generated method stub

        if (t == null) {
            return;
        }
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
