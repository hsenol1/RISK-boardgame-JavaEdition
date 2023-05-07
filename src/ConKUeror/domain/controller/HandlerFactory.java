package src.ConKUeror.domain.controller;

import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Modes.StartMode;

public class HandlerFactory {

    private GameLogic gameLogic;
    private Board board;
    private BuildMode buildMode;
    private StartMode startMode;

    private static HandlerFactory instance;

    private HandlerFactory() {
        board = new Board();
        buildMode = new BuildMode();
        startMode = new StartMode(buildMode);
        gameLogic = new GameLogic(board, startMode);

    }

    public static HandlerFactory getInstance() {
        if (instance == null) {
            instance = new HandlerFactory();
        }
        return instance;
    }

    public GameHandler giveGameHandler() {
        return GameHandler.getInstance();
    }

    public MapHandler giveMapHandler() {
        return MapHandler.getInstance(gameLogic, board);
    }

    public ButtonHandler giveButtonHandler() {
        return ButtonHandler.getInstance(buildMode,gameLogic);

    }
    public StartHandler giveStartHandler() {
        return StartHandler.getInstance(startMode);
    }
    public BuildHandler giveBuildHandler() {
        return BuildHandler.getInstance(buildMode);

    }

    public CardController giveCardController() {
        return CardController.getInstance();
    }
}
