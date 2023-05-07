package src.ConKUeror.domain.model.Modes;

import java.util.List;
import java.util.Map;
import java.awt.Color;
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
import src.ConKUeror.domain.model.Board.TerritoryCard;
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
  private Player playerInTurn;
  private Player cardPlayer;


  public Boolean selectedButton;

  public GameMode currentGameMode = GameMode.BUILD;
  public static StartMode startMod;

  public Territory[] memory = new Territory[2];
  private int memoryIndex = 0;

  private int phaseIndex= 0;
  private int cardCounter = 0;

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
        memory[0] = memory[1];
        memory[1] = t;
      }

 

    }

    public static void setGameOrderList(List<Player> orderList) {
      orderedPlayerList =orderList;

    }


    public void passToNextPlayer(Player p1) {


        int currentIndex = orderedPlayerList.indexOf(p1);
        playerInTurn= orderedPlayerList.get((currentIndex + 1)% orderedPlayerList.size()) ;

    }

    public void setFirstPlayer() {
      System.out.println(orderedPlayerList.get(0).getName() );

      this.playerInTurn = orderedPlayerList.get(0);
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

  private void showAvailableAttacks(List<Integer> territoriesAvailableForAttack)
    {
      for(TerritoryButtonListener l: territoryButtonListeners) {
        l.getButtonList(territoriesAvailableForAttack);
      }
    }


  public void setTerritoryInfo(int ID, int armyUnit, Color color,int territoryArmy) {
    for(TerritoryButtonListener l: territoryButtonListeners) {
      l.setTerritoryButtonInfo(ID, armyUnit, color,territoryArmy);
    }
  }

  public void publishRemoveEvent(TerritoryButton button) {
      for(MapListener l: listeners){
          l.removeOnboardEvent(button);

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

  public void addTerritoryCard() {
      //  cardPlayer = playerInTurn;
        cardCounter += 1;
        int territory_id = 37 + cardCounter;
        Territory territory = new Territory(territory_id);
        

        TerritoryCard territoryC = new TerritoryCard("Territory Card!", territory);
        playerInTurn.inv.addTerritoryCard(territoryC);
    

        
  }

  public void useTerritoryCard() {
        playerInTurn.inv.useTerritoryCards();

  }


  public void addArmyCard() {
       // cardPlayer
  }


  public void roll() {

    //Rollayarak ilk playera karar veriyor
    Player player = diceRoller.getFirstPlayer();
    //bu playerın solundaki playerlari listeye atıyor ve orderli bir player listesi oluşturuyor
    startMod.setOrderedAfterRoll(player);
    //ilk ismi döndürüyor
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
        else if (currentGameMode == GameMode.CHANCECARD)
        {
            setGameMode(GameMode.DEPLOY);
        }
        else if (currentGameMode == GameMode.DEPLOY)
        {
            setGameMode(GameMode.ATTACK);
        }

        else if (currentGameMode == GameMode.ATTACK)
        {
            setGameMode(GameMode.FORTIFY);
        }
        else if (currentGameMode == GameMode.FORTIFY)
        {
            setGameMode(GameMode.TERRITORYCARD);
        }

        else if (currentGameMode == GameMode.TERRITORYCARD)
        {
            setGameMode(GameMode.ARMYCARD);
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
        this.phaseIndex=1;
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
        this.phaseIndex=2;

        if(t.getOwner()==null || t.getOwner() == playerInTurn) {
          if(playerInTurn.getInventory().getTotalArmy()>0) {

         //inventorydeki asker sayısını değiştirecek
          playerInTurn.getInventory().removeInfantries(1);
          t.setOwner(playerInTurn);
          t.addInfantries(1);

          playerInTurn.getInventory().addTerritory(t);
           //uidaki territory buttonını değiştirecek ve rengi değiştirecek
           setTerritoryInfo(t.getId(),playerInTurn.getInventory().getTotalArmy(),playerInTurn.getColor(),t.getTotalUnit());
        }
        passToNextPlayer(playerInTurn);

      }




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
           this.inputTerritory=t;
           
           //Map<Integer,Territory>  adjacentList = t.getAdjacencyList();
           List<Integer> territoriesAvailableForAttack = new ArrayList<Integer>();
           t.checkAvailableAttacks(territoriesAvailableForAttack);
           showAvailableAttacks(territoriesAvailableForAttack);
           addToMemory(t);
          break;

        case FORTIFY:
          System.out.println("Fortify");
          this.phaseIndex=5;

          break;

        case TERRITORYCARD:
            System.out.println("Territory Card Phase test");
            this.phaseIndex = 6;
            break;



        case ARMYCARD:
            System.out.println("Army Card Phase test");
            this.phaseIndex = 7;
            break;


      }



    }

    


































}
