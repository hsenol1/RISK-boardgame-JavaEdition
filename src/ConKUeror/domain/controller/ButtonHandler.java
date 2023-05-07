package src.ConKUeror.domain.controller;

import java.util.Map;

import src.ConKUeror.UI.Buttons.TerritoryButton;
import src.ConKUeror.UI.Frames.MapView;
import src.ConKUeror.UI.Panels.PlayerInteractionPanel;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Board.Die;
import src.ConKUeror.domain.model.Board.DiceRoller;

public class ButtonHandler{
    private static ButtonHandler instance;
    private BuildMode bMode;
    private GameLogic gMode;
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



          gMode.prepareButton(t,gMode.getGameMode());

    }

    public void selectButton(TerritoryButton button) {

        selectedButton= button;

    }

    public void addConnection() {

        System.out.print("add connection methodundayım");

        Territory[] territories=gMode.getMemory();
        territories[0].addConnectionDual(territories[1]);

        Map<Integer, Territory> tests= territories[0].getAdjacencyList();
        System.out.println("komsularim basladi");

        for (Map.Entry<Integer, Territory> set : tests.entrySet()) {
            int territoryId =set.getKey();
            System.out.println(territoryId);
            }
            System.out.println("komsularim bitti");


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
    












}
