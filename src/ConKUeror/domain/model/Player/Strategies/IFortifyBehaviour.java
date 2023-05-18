package src.ConKUeror.domain.model.Player.Strategies;

import src.ConKUeror.domain.model.Board.Territory;

public interface IFortifyBehaviour {


    void fortify(Territory fortifyFrom, Territory fortifyTo, int army);

}
