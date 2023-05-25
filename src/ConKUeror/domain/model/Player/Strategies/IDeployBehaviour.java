package ConKUeror.domain.model.Player.Strategies;

import ConKUeror.domain.model.Board.Territory;

public interface IDeployBehaviour {

    void deploy(Territory t, int army);
}
