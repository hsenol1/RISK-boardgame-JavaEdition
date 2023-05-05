package src.ConKUeror.domain.controller;

import java.util.Map;

import src.ConKUeror.UI.Buttons.TerritoryButton;
import src.ConKUeror.UI.Frames.MapView;
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

          Territory t = gMode.getBoard().getTerritoryWithIndex(id);
          //System.out.println(t.getId());
          gMode.prepareButton(t,GameMode.BUILD);

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
       // System.out.print(tests.size());



        for (Map.Entry<Integer, Territory> set : tests.entrySet()) {
            int territoryId =set.getKey();
            System.out.println(territoryId);
            }
            System.out.println("komsularim bitti");


    }


    public void removeButton() {
        getBoard().removeTerritory();
        gMode.publishBoardEvent(selectedButton);;

    }

    public void rollButton() {

        gMode.roll();

    }
        //just for test

	public Board getBoard() {
        return  gMode.getBoard();
	}

	public BuildMode getBuildMode() {
		return bMode;
	}






    public int getXFromList(int i) {

        return bMode.getCoordinateList().get(i).getX();
    }

    public int getYFromList(int i) {

        return bMode.getCoordinateList().get(i).getY();

    }

    public void registerAsListener(MapView mapView) {
        gMode.addTerritoryButtonListener(mapView);
        gMode.addRollDieListener(mapView);


    }









}
