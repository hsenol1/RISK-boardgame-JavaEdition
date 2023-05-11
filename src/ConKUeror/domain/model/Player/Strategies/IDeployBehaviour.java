package src.ConKUeror.domain.model.Player.Strategies;

import src.ConKUeror.domain.model.Board.Territory;

public interface IDeployBehaviour {

    void deploy(Territory t, int army);
}
