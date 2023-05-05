package src.ConKUeror.domain.model.Modes;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import src.ConKUeror.UI.Buttons.TerritoryButton;
import src.ConKUeror.domain.controller.MapListener;
import src.ConKUeror.domain.controller.TerritoryButtonListener;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerInventory;


public class GameLogic {

  private Board board;
  private PlayerInventory p;
  private Territory inputTerritory;
  private ArrayList<Territory> inputTerritories = new ArrayList<Territory>();
  private List<MapListener> listeners = new ArrayList<>();
  private List<TerritoryButtonListener> territoryButtonListeners = new ArrayList<>();
  private static List<Player> orderedPlayerList;


  public Boolean selectedButton;

  public GameMode gameMode = GameMode.BUILD;
  public static StartMode startMod;

  public Territory[] memory = new Territory[2];
  private int memoryIndex = 0;

  private static int phaseIndex= 0;

    public GameLogic(Board board,StartMode sMode) {

      this.startMod = sMode;
      this.board = board;
    }

    public void addToMemory(Territory t) {


      if(memory[0] == null) {
        memory[0] = t;
      }
      else if(memory[1] == null) {
        memory[1] = t;
      }
      else {
        if(memoryIndex%2 ==0) {
          memory[0]=t;
          memoryIndex++;
        }

      }


    }

    public Territory[] getMemory() {
      return memory;
    }



    /*
    public static List<Player> getPlayerList() {

      orderedPlayerList = startMod.;
      return orderedPlayerList;

    }
*/
    public Board getBoard() {
        return board;
    }

    public void addMapListener(MapListener lis) {
      listeners.add(lis);
  }

  public void addTerritoryButtonListener(TerritoryButtonListener lis) {
    territoryButtonListeners.add(lis);
  }

  public void giveNeighborIdsOfSelectedTerritoryButton(List<Integer> neigborIdsList ) {
    for(TerritoryButtonListener l: territoryButtonListeners) {
      l.getButtonList(neigborIdsList);
    }

  }


  public void publishBoardEvent(TerritoryButton button) {
      for(MapListener l: listeners){
          l.onBoardEvent(button);

      }

  }

  public void prepareTerritory(Territory t) {
    board.setTerritory(inputTerritory);

  }

  //this will be changed later as observer pattern
  public static int getGamePhaseAsIndex() {
      return phaseIndex;

  }


    public void prepareButton(Territory t,GameMode gameMode) {

      switch(gameMode) {

        case BUILD:

        this.inputTerritory = t;
        this.phaseIndex=0;
        prepareTerritory(t);
        addToMemory(t);


        break;

        case CONNECTION:

        this.inputTerritory=t;
        Map<Integer,Territory>  adjList = t.getAdjacencyList();
        List<Integer> neighborIds = new ArrayList<Integer>();

        for (Map.Entry<Integer, Territory> set : adjList.entrySet()) {
          int territoryId =set.getKey();
          neighborIds.add(territoryId);
        }



        giveNeighborIdsOfSelectedTerritoryButton(neighborIds);
        break;

        case START:
        this.inputTerritory = t;
        this.phaseIndex=1;

          break;

        case CHANCECARD:
          System.out.println("Card");
          this.phaseIndex=2;

          break;

        case DEPLOY:
          System.out.println("Deploy");
          this.phaseIndex=3;

          break;

        case ATTACK:
           System.out.println("Attack");
           this.phaseIndex=4;

          break;

        case FORTIFY:
          System.out.println("Fortify");
          this.phaseIndex=5;

          break;
      }


    }


































}
