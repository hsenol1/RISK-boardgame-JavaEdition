package src.ConKUeror.domain.controller;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

//import com.apple.laf.resources.aqua;

import src.ConKUeror.UI.Buttons.TerritoryButton;
import src.ConKUeror.UI.Frames.MapView;
import src.ConKUeror.UI.Panels.ArmySelectionPanel;
import src.ConKUeror.UI.Panels.PlayerInteractionPanel;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.DeployMode;
import src.ConKUeror.domain.model.Modes.FortifyMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerExpert;
import src.ConKUeror.domain.model.Board.Die;
import src.ConKUeror.domain.model.Board.DiceRoller;

public class ButtonHandler{
    private static ButtonHandler instance;
    private BuildMode bMode;
    private GameLogic gMode;
    private Territory[] memory;
    private TerritoryButton selectedButton;

    private ButtonHandler(BuildMode bMode, GameLogic gMode) {
            this.bMode = bMode;
            this.gMode = gMode;

    }
    public static ButtonHandler getInstance(BuildMode bMode, GameLogic gMode) {
        if (instance == null) {
            instance = new ButtonHandler(bMode,gMode);
        }
        return instance;
    }


    public void matchButtonWithTerritory(int id) {
          Territory t = Board.getTerritoryWithIndex(id);
          //System.out.println(t.getId());
          System.out.println(gMode.getGameMode());
          System.out.println(t.getId());
          gMode.prepareButton(t,gMode.getGameMode());

    }

    public void addToMemory(int id) {
        Territory t = Board.getTerritoryWithIndex(id);
        gMode.addToMemory(t);
    }

    public Territory[] getMemoryList() {
        return gMode.getMemory();
    }

    public void selectButton(TerritoryButton button) {

        selectedButton= button;

    }

    public void chooseDeployArmy() {

        ArmySelectionPanel armySelectionPanel = new ArmySelectionPanel("Choose Army");
        armySelectionPanel.setMaxValue(DeployMode.getMaxValue());
        armySelectionPanel.createSlider();

        Object[] options = {"OK", "Cancel"};
        int result = JOptionPane.showOptionDialog(null, armySelectionPanel, "Deploy",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

       int deployedArmy= armySelectionPanel.getValue();
       DeployMode.setDeployedArmy(deployedArmy);

    }

    public void chooseFortifyArmy() {

if(FortifyMode.canFortify()) {




        memory = gMode.getMemory();
        ArmySelectionPanel armySelectionPanel = new ArmySelectionPanel("Choose Army");
        armySelectionPanel.setMaxValue(FortifyMode.getMaxValue(memory[0]));
        armySelectionPanel.createSlider();

        Object[] options = {"OK", "Cancel"};
        int result = JOptionPane.showOptionDialog(null, armySelectionPanel, "Fortify",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

       int fortifiedArmy= armySelectionPanel.getValue();
       FortifyMode.setFortifiedArmy(fortifiedArmy);
    } else {
        memory=gMode.getMemory();
        System.out.println("Memory slot 0" +memory[0]);
        System.out.println("Memory slot 1" +memory[1]);

        System.out.println("Sorry, cant fortify");
    }

    }

    public void addConnection() {

       // System.out.prinzt("add connection methodundayım");

        Territory[] territories=gMode.getMemory();
        territories[0].addConnectionDual(territories[1]);

        Map<Integer, Territory> tests= territories[0].getAdjacencyList();
       // System.out.println("komsularim basladi");

        for (Map.Entry<Integer, Territory> set : tests.entrySet()) {
            int territoryId =set.getKey();
            System.out.println(territoryId);
            }
           // System.out.println("komsularim bitti");


    }

    public int getArmyUnitFromInputTerritory()
    {
        int i = 0;
        try {
            i = gMode.getMemory()[0].getTotalUnit();
        }
        catch (NullPointerException e)
        {

        }
        return i;
    }

    public void increaseArmyCount()
    {
        System.out.print("increase army count methodundayım");
        gMode.publishArmyIncreasedEvent(getArmyUnitFromInputTerritory() + 1);
    }

    public void attack()
    {
        gMode.setForAttack();
    }

    public void deploy(){

        Player playerInTurn = PlayerExpert.getPlayerInTurn();
        Territory t = Board.getCurrenTerritory();
        int army = DeployMode.getDeployedArmy();
        playerInTurn.deploy(t,army);



    }
    public void fortify() {
        Player playerInTurn = PlayerExpert.getPlayerInTurn();
         memory = getMemoryList();

        Territory fortifyFrom =memory[0];
        Territory fortifyTo =memory[1];

        if (FortifyMode.isValidForFortify(fortifyFrom)) {
            int army = FortifyMode.getFortifiedArmy();
            playerInTurn.fortify(fortifyFrom,fortifyTo,army);
        }




       // int army = FortifyMode.getFortifiedArmy();



    }

    public Color getPlayerColor() {

        return PlayerExpert.getPlayerInTurn().getColor();

               }

    public void removeButton() {
        getBoard().removeTerritory();
        gMode.publishRemoveEvent(selectedButton);;

    }

    public void rollButton() {

        gMode.roll();
        gMode.setFirstPlayer();

    }

	public Board getBoard() {
        return  gMode.getBoard();
	}

	public BuildMode getBuildMode() {
		return bMode;
	}

    public void nextPhase() {
        gMode.increasePhaseIndex();
        gMode.moveToOtherPhase();

    }




    public int getPhaseIndex() {
        return gMode.getGamePhaseAsIndex();
    }



    public int getXFromList(int i) {

        return bMode.getCoordinateList().get(i).getX();
    }

    public int getYFromList(int i) {

        return bMode.getCoordinateList().get(i).getY();

    }

    public void registerAsTerritoryListener(TerritoryButtonListener territoryListener) {
        gMode.addTerritoryButtonListener(territoryListener);
    }


     public void registerAsRollListener( RollDieListener rollDieListener) {
        gMode.addRollDieListener(rollDieListener);

    }

    public void registerNextAsListener(PlayerInteractionPanel pPanel) {
        gMode.addNButtonListener(pPanel);
    }


    public void addTerritoryCard() {
        gMode.addTerritoryCard();
    }

    public void useTerritoryCards() {
        gMode.useTerritoryCard();
    }

    public void addArmyCard() {
        gMode.addArmyCard();
    }

    public void useArmyCards() {
        gMode.useArmyCards();
    }
    public void setAttackingArmyCount(int armyCount)
    {
        gMode.setAttackingArmyUnit(armyCount);
    }












}
