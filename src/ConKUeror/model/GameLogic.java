package src.ConKUeror.model;

import src.ConKUeror.model.Board.Board;
import src.ConKUeror.model.Board.Card;
import src.ConKUeror.model.Player.PlayerInventory;

public class GameLogic {

  Board board;

    public GameLogic(Board board) {

      this.board = board;

      
    }


    public Board getBoard() {

      return board;
    }

    private PlayerInventory p;
    
    public void tradeCardArmy(Card c[], Army a[]) {

  p.deleteCards(c);
  p.insertArmies(a);


    }
    



}
