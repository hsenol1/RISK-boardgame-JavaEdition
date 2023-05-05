package src.ConKUeror.domain.controller;

import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Modes.GameLogic;

public class MapHandler {
    GameLogic game;
    private static MapHandler instance ;

    private MapHandler(GameLogic _game, Board board) {
        this.game = _game;

    }

    public static MapHandler getInstance(GameLogic _game, Board board) {
        if (instance == null) {
            instance = new MapHandler(_game, board);
        }
        return instance;
    }


    public void registerAsListener(MapListener listener) {
        game.addMapListener(listener);


    }


}
