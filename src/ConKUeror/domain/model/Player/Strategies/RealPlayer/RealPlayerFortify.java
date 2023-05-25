package ConKUeror.domain.model.Player.Strategies.RealPlayer;

import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.controller.MapHandler;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.Strategies.IFortifyBehaviour;

public class RealPlayerFortify implements IFortifyBehaviour{

    @Override
    public void fortify(Territory fortifyFrom, Territory fortifyTo, int army) {
        // TODO Auto-generated method stub


        fortifyFrom.removeInfantries(army);
        fortifyTo.addInfantries(army);


       MapHandler mapHandler =  HandlerFactory.getInstance().giveMapHandler();

       Territory[] fortifyTerritories= new Territory[2];
       fortifyTerritories[0] = fortifyFrom;
       fortifyTerritories[1] = fortifyTo;

       for(int i = 0 ; i<2 ; i++) {

            Territory t=fortifyTerritories[i];

            int buttonId = t.getId();
            int result = t.getTotalUnit();

            mapHandler.updateTerritory(buttonId,result);

       }



    }

}
