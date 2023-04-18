package src.ConKUeror.model;

import src.ConKUeror.model.Board.Card;
import src.ConKUeror.model.Player.PlayerInventory;

public class GameLogic {

    private PlayerInventory p;
    
    public void tradeCardArmy(Card c[], Army a[]) {

  p.deleteCards(c);
  p.insertArmies(a);


    }
    



}
