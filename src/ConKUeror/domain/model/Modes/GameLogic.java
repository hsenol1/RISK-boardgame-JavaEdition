package src.ConKUeror.domain.model.Modes;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import src.ConKUeror.UI.Buttons.TerritoryButton;
import src.ConKUeror.domain.controller.MapListener;
import src.ConKUeror.domain.controller.NextButtonListener;
import src.ConKUeror.domain.controller.RollDieListener;
import src.ConKUeror.domain.controller.TerritoryButtonListener;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Card;
import src.ConKUeror.domain.model.Board.DiceRoller;
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
  private List<RollDieListener> rollListeners = new ArrayList<>();
  private List<NextButtonListener> nButtonListener = new ArrayList<>();
  private static List<Player> orderedPlayerList;
  DiceRoller diceRoller = new DiceRoller();


  public Boolean selectedButton;

  public GameMode currentGameMode = GameMode.BUILD;
  public static StartMode startMod;

  public Territory[] memory = new Territory[2];
  private int memoryIndex = 0;

  private int phaseIndex= 0;

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


    public GameMode getGameMode() {
      return currentGameMode;
    }


    public void setGameMode(GameMode mode ) {
        this.currentGameMode = mode;
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

  public void addRollDieListener(RollDieListener rdlis) {
    rollListeners.add(rdlis);
  }

  public void addNButtonListener(NextButtonListener nbLis) {
    nButtonListener.add(nbLis);
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

  public void giveFirstPlayer(String playerName) {
    for (RollDieListener l: rollListeners) {
        l.getRollEvent(playerName);
    }
  }
  public void roll() {
    Player player = diceRoller.getFirstPlayer();

    startMod.setOrderedAfterRoll(player);
    giveFirstPlayer(player.getName());
}

    public void increasePhaseIndex() {
        phaseIndex += 1;
        for (NextButtonListener l : nButtonListener ) {
            l.nextPhaseEvent(phaseIndex);
        }
    }

    public int getGamePhaseAsIndex() {
         return phaseIndex;

}
public void moveToOtherPhase() {
  if(currentGameMode== GameMode.BUILD) {
    setGameMode(GameMode.CONNECTION);
  }
  else if (currentGameMode == GameMode.CONNECTION) {
    setGameMode(GameMode.START);

  }else if (currentGameMode == GameMode.START) {
    setGameMode(GameMode.CHANCECARD);

  }
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
