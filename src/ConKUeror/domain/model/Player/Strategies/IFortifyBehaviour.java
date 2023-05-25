package ConKUeror.domain.model.Player.Strategies;

import ConKUeror.domain.model.Board.Territory;

public interface IFortifyBehaviour {


    void fortify(Territory fortifyFrom, Territory fortifyTo, int army);

}
