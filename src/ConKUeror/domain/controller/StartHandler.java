package src.ConKUeror.domain.controller;

import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Modes.StartMode;

public class StartHandler {
    private StartMode startMode;
    private Board board;
    private GameLogic gamelogic;

    public StartHandler(StartMode sMode) {
        this.startMode = sMode;
    }

    public void registerAsListener(StartModeListener listener) {
        // startMode.addBuildModeListener(listener);
    }

    public void occupyTerritory(int id) {
     //    startMode
    }

    public String enterMessageString() {

	
        return startMode.getInitialMessage();

    }


}
