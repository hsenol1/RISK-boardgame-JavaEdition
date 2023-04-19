package src.ConKUeror.controller;

import src.ConKUeror.model.StartMode;
import src.ConKUeror.model.GameLogic;
import src.ConKUeror.model.Board.Board;

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




}
