package src.ConKUeror.model;

import java.util.List;
import java.util.ArrayList;

import src.ConKUeror.model.Board.Board;
import src.ConKUeror.model.Board.Card;
import src.ConKUeror.model.Board.Territory;
import src.ConKUeror.model.Player.PlayerInventory;
import src.ConKUeror.view.MyButton;
import src.ConKUeror.controller.MapListener;


public class GameLogic {

  private Board board;
  private PlayerInventory p;
  private Territory inputTerritory;
  private ArrayList<Territory> inputTerritories = new ArrayList<Territory>();
  
  private List<MapListener> listeners = new ArrayList<>();



  public Boolean selectedButton;

  public enum GameState {
    BUILD,
    START,
    CARD,
    DEPLOY,
    ATTACK,
    FORTIFY
  }

  private GameState currentState = GameState.BUILD;

    public GameLogic(Board board) {
      this.board = board;
    }
        public Board getBoard() {
          return board;
    }

    public void addMapListener(MapListener lis) {
      listeners.add(lis);
  }
  
  
  public void publishBoardEvent(MyButton button) {
      for(MapListener l: listeners){
          l.onBoardEvent(button);
  
      }
         
  }


    public void execute(Territory t) {

      switch(currentState) {

        case BUILD:
        this.inputTerritory = t;
        board.takeTerritoryForRemoval(inputTerritory);
        break;

        case START:
        this.inputTerritory = t;
          break;

        case CARD:
          System.out.println("Card");
          break;

          case DEPLOY:
          System.out.println("Deploy");
          break;

        case ATTACK:
           System.out.println("Attack");
          break;

        case FORTIFY:
          System.out.println("Fortify");
          break;
      }


    }

    public GameState getGameState() {

      return currentState;
    }

    public void setGameState(GameState state ) {
      this.currentState = state;
    }

    



























    public void tradeCardArmy(Card c[], Army a[]) {
  p.deleteCards(c);
  p.insertArmies(a);
    }
    



}
