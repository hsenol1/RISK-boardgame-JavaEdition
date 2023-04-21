package src.ConKUeror.controller;

import src.ConKUeror.model.GameLogic;
import src.ConKUeror.model.Board.Board;

public class MapHandler {
    GameLogic game;

    public MapHandler(GameLogic _game, Board board) {
        this.game = _game; 
        
    }


    public void registerAsListener(MapListener listener) {
        game.addMapListener(listener);


    }

    
}
