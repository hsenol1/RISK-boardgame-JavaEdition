package src.ConKUeror.domain.model.Modes;

import java.util.List;
import java.util.ArrayList;

import src.ConKUeror.UI.TerritoryButton;
import src.ConKUeror.domain.controller.MapListener;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Card;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerInventory;


public class GameLogic {

  private Board board;
  private PlayerInventory p;
  private Territory inputTerritory;
  private ArrayList<Territory> inputTerritories = new ArrayList<Territory>();
  
  private List<MapListener> listeners = new ArrayList<>();
  private static List<Player> orderedPlayerList;


  public Boolean selectedButton;

  public GameMode gameMode = GameMode.BUILD;
  public static StartMode startMod;


    public GameLogic(Board board,StartMode sMode) {

      this.startMod = sMode;
      this.board = board;
    }

    /* 
    public static List<Player> getPlayerList() {

      orderedPlayerList = startMod.;
      return orderedPlayerList;

    } */

    
    public Board getBoard() {
        return board;
    }

    public void addMapListener(MapListener lis) {
      listeners.add(lis);
  }
  
  
  public void publishBoardEvent(TerritoryButton button) {
      for(MapListener l: listeners){
          l.onBoardEvent(button);
  
      }
         
  }


    public void execute(Territory t,GameMode gameMode) {

      switch(gameMode) {

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

  

    






























}
