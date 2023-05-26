package ConKUeror.domain.model.Modes;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

import ConKUeror.UI.Buttons.TerritoryButton;
import ConKUeror.domain.controller.CardController;
import ConKUeror.domain.controller.MapListener;
import ConKUeror.domain.controller.NextButtonListener;
import ConKUeror.domain.controller.RollDieListener;
import ConKUeror.domain.controller.TerritoryButtonListener;
import ConKUeror.domain.enums.GameMode;
import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Board.ArmyCard;
import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Card;
import ConKUeror.domain.model.Board.DiceRoller;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Board.TerritoryCard;
import ConKUeror.domain.model.Board.ArmyCard.ArmyType;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;
import ConKUeror.domain.model.Player.PlayerInventory;


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
  private Set<Integer> accessibleTerritoryIds = new HashSet<>();
  private Map<Integer, Territory> unoccupiedTerritories = new LinkedHashMap<>();
  private Random rand ;


  DiceRoller diceRoller = DiceRoller.getDiceRollerInstance();
  private Player playerInTurn;

  private int attackingArmyUnit;
  private Player cardPlayer;
  public Boolean selectedButton;
  public GameMode currentGameMode = GameMode.BUILD;
  public static StartMode startMod;

  public Territory[] memory = new Territory[2];
  private int memoryIndex = 0;

  private int phaseIndex= 0;
  private int cardCounter = 0;
  private int armyCardCounter = 0;
  private CardController cardController;

  private static final int UNOCCUPIED_FIXED_SIZE =  42;

    public GameLogic(Board board,StartMode sMode) {

      this.startMod = sMode;
      this.board = board;
       rand = new Random();

    }

    public void waitAndExecute(Runnable action) {
      int delay = 1000; // delay for 1 second.
      Timer timer = new Timer(delay, null);
      ActionListener taskPerformer = new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              SwingUtilities.invokeLater(action);
              timer.stop(); // stop the timer after it fires
          }
      };
      timer.addActionListener(taskPerformer);
      timer.start();
  }



    public void addToMemory(Territory t) {

        if (memory[0] == null) {
            memory[0] = t;
        } else if (memory[1] == null && memory[0] != t) {
            memory[1] = t;
        } else if (memory[0] != t && memory[1] != t) {
            memory[0] = memory[1];
            memory[1] = t;
        }

    }

    public static void setGameOrderList(List<Player> orderList) {
      orderedPlayerList =orderList;
      PlayerExpert.setPlayersList(orderedPlayerList);

    }




     public void setForMapInitalization() throws InterruptedException {

       String playerType= playerInTurn.getType();

       if (playerType.equals("Computer")) {
        computerChoosesTerritory();
       }



    }




    public void computerChoosesTerritory() throws InterruptedException {



       if (playerInTurn.getInventory().getTotalArmy()>0 && playerInTurn.getType().equals("Computer")) {

            if(!unoccupiedTerritories.isEmpty()) {

              int size =  unoccupiedTerritories.size();



              int randomTerritoryId = rand.nextInt(UNOCCUPIED_FIXED_SIZE);
              Territory t = unoccupiedTerritories.get(randomTerritoryId);

              while(t == null) {
                 randomTerritoryId = rand.nextInt(UNOCCUPIED_FIXED_SIZE);
                 t = unoccupiedTerritories.get(randomTerritoryId);
              }

              unoccupiedTerritories.remove(randomTerritoryId);

              playerInTurn.getInventory().removeInfantries(1);
              t.setOwner(playerInTurn);
              t.addInfantries(1);
              playerInTurn.getInventory().addTerritory(t);
              setTerritoryInfo(t.getId(),playerInTurn.getInventory().getTotalArmy(),playerInTurn.getColor(),t.getTotalUnit());
              passToNextPlayer(playerInTurn);

          } else {

              List<Territory> ownedTerritories = playerInTurn.inv.getOwnedTerritories();
              int size = ownedTerritories.size();
              int randomTerritoryId = rand.nextInt(size);
              Territory t = ownedTerritories.get(randomTerritoryId);

                randomTerritoryId = rand.nextInt(size);
                t = ownedTerritories.get(randomTerritoryId);


              playerInTurn.getInventory().removeInfantries(1);
              t.addInfantries(1);
              setTerritoryInfo(t.getId(),playerInTurn.getInventory().getTotalArmy(),playerInTurn.getColor(),t.getTotalUnit());
              passToNextPlayer(playerInTurn);

          }

      }






    }



    public void passToNextPlayer(Player p1) throws InterruptedException {
      int currentIndex = orderedPlayerList.indexOf(p1);
      PlayerExpert.updatePlayerCount(currentIndex);
      int newIndex = (currentIndex+1 ) %orderedPlayerList.size();
      playerInTurn= orderedPlayerList.get(newIndex);
      int oldIndex = currentIndex;
      PlayerExpert.publishPlayerInfoEvent(oldIndex, newIndex, playerInTurn.getColor());
      if(playerInTurn.getType().equals("Computer")) {
        waitAndExecute(() -> {
            try {
                computerChoosesTerritory();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
      }
  }


    public void setFirstPlayer() {
     // System.out.println(orderedPlayerList.get(0).getName() );
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

  public void updateTerritory(int buttonID,int army ){
    for(TerritoryButtonListener l: territoryButtonListeners) {
      l.updateTerritory(buttonID,army);
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

  public void publishArmyIncreasedEvent(int i)
  {
    for(TerritoryButtonListener l: territoryButtonListeners) {
      l.setArmyCount(i);
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
        CardController cc  = CardController.getInstance();
        TerritoryCard tCard = cc.drawTerritoryCard(playerInTurn);
        if (tCard != null) {
            System.out.println(tCard.getName());

            playerInTurn.inv.addTerritoryCard(tCard);
        }
  }

  public void useTerritoryCard() {

        playerInTurn.inv.useTerritoryCards();

  }



  public void addArmyCard() {
        CardController cc = CardController.getInstance();
        ArmyCard aCard = cc.drawArmyCard(playerInTurn);
        if (aCard != null) {
            playerInTurn.inv.addArmyCard(aCard);
            System.out.println(aCard.getName());


        }

  }

  public void useArmyCards(int type) {

    playerInTurn.inv.useArmyCards(type);
    //System.out.println("After Using!");
    // f

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
            board.initUnoccupiedTerritories();
            unoccupiedTerritories = board.getUnoccupiedTerritories();

        }
        else if (currentGameMode == GameMode.CONNECTION) {
            setGameMode(GameMode.START);


        }else if (currentGameMode == GameMode.START) {
            setGameMode(GameMode.CHANCECARD);


        }
        else if (currentGameMode == GameMode.CHANCECARD)
        {
            setGameMode(GameMode.DEPLOY);
            DeployMode.setDeployedArmy(playerInTurn);
            int player_index =PlayerExpert.getPlayersList().indexOf(playerInTurn);
            PlayerExpert.updatePlayerCount(player_index);
        }
        else if (currentGameMode == GameMode.DEPLOY)
        {
            setGameMode(GameMode.ATTACK);
        }

        else if (currentGameMode == GameMode.ATTACK)
        {
          memory[0]=null;
          memory[1]=null;

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


    public void prepareGame(Territory t,GameMode gameMode) throws InterruptedException {

      PlayerExpert.setPlayerInTurn(playerInTurn);

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
        if (playerInTurn.getInventory().getTotalArmy()>0) {

          if(t.getOwner() ==  null) {
            playerInTurn.getInventory().removeInfantries(1);
            t.setOwner(playerInTurn);
            t.addInfantries(1);
            playerInTurn.getInventory().addTerritory(t);
            setTerritoryInfo(t.getId(),playerInTurn.getInventory().getTotalArmy(),playerInTurn.getColor(),t.getTotalUnit());
            unoccupiedTerritories.remove(t.getId());

            passToNextPlayer(playerInTurn);

          } else if (t.getOwner() == playerInTurn) {
            playerInTurn.getInventory().removeInfantries(1);
            t.addInfantries(1);
            setTerritoryInfo(t.getId(),playerInTurn.getInventory().getTotalArmy(),playerInTurn.getColor(),t.getTotalUnit());

            passToNextPlayer(playerInTurn);

          }

        }

          break;

        case CHANCECARD:
          System.out.println("Card");
          this.phaseIndex=3;

          break;

        case DEPLOY:
          System.out.println("Deploy");
          this.phaseIndex=4;
          this.inputTerritory = t;

          if(t.getOwner() == playerInTurn) {
            prepareTerritory(t);

          }

          break;

        case ATTACK:
           System.out.println("Attack");
           this.phaseIndex=5;
           this.inputTerritory=t;

           //Map<Integer,Territory>  adjacentList = t.getAdjacencyList();
           List<Integer> territoriesAvailableForAttack = new ArrayList<Integer>();
           t.checkAvailableAttacks(territoriesAvailableForAttack);
           showAvailableAttacks(territoriesAvailableForAttack);
           addToMemory(t);
          break;

        case FORTIFY:
          System.out.println("Fortify ");
          this.phaseIndex=6;

          if(t.getOwner() == playerInTurn ) {

            if (memory[0] != null && memory[0].getId() != t.getId()  && accessibleTerritoryIds.contains(t.getId())) {
              memory[1] = t; // Add the green territory to the second slot of memory
              FortifyMode.setCanFortify();

          }

          else if (memory[0] == null || memory[0].getId() != t.getId()) {
            this.inputTerritory = t;
            Set<Integer> visited = new HashSet<>();
            List<Integer> ownedTerritoryIds = new ArrayList<>();
            dfs(inputTerritory, visited, ownedTerritoryIds);
            accessibleTerritoryIds.clear();
            accessibleTerritoryIds.addAll(ownedTerritoryIds);
            giveNeighborIdsOfSelectedTerritoryButton(ownedTerritoryIds);
            memory[0] = t;  // Add the territory to memory
            memory[1] = null; // Reset the second slot of memory
        }



          }
          // If the territory is not owned by the current player, clear the memory
          else {
            memory[0] = null;
            memory[1] = null;
            accessibleTerritoryIds.clear();
          }


          break;

        case TERRITORYCARD:
            System.out.println("Territory Card Phase test");
            this.phaseIndex = 7;
            break;



        case ARMYCARD:
            System.out.println("Army Card Phase test");
            this.phaseIndex = 8;
            break;


      }



    }



    private void dfs(Territory territory, Set<Integer> visited, List<Integer> ownedTerritoryIds) {
      // Check if this territory has already been visited or not owned by the player
      int territoryId = territory.getId();
      if (visited.contains(territoryId) || territory.getOwner() != playerInTurn) {
          return;
      }

      // Mark the current node as visited and add it to our list
      visited.add(territoryId);
      ownedTerritoryIds.add(territoryId);

      // Get the adjacency list for the current territory
      Map<Integer, Territory> adjList = territory.getAdjacencyList();

      // Recursively visit all the neighbors
      for (Map.Entry<Integer, Territory> set : adjList.entrySet()) {
          Territory neighbor = set.getValue();
          dfs(neighbor, visited, ownedTerritoryIds);
      }
  }



    public int getAttackingArmyUnit() {
      return attackingArmyUnit;
    }

    public void setAttackingArmyUnit(int attackingArmyUnit) {
      this.attackingArmyUnit = attackingArmyUnit;
    }

    public void setForAttack()
    {
      int attackingArmy = attackingArmyUnit;
      try {
          int defendingArmy = memory[1].getTotalUnit();
          playerInTurn.attack(attackingArmy, defendingArmy);
      }
      catch (NullPointerException e)
      {
          System.out.println("Please choose an attack target");
      }

    }






























}
