package src.ConKUeror.domain.controller;

import src.ConKUeror.UI.MapView;
import src.ConKUeror.UI.PlayerPanel;
import src.ConKUeror.UI.TerritoryButton;
import src.ConKUeror.domain.enums.GameMode;
import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Board.Territory;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Board.Die;
import src.ConKUeror.domain.model.Board.DiceRoller;

public class ButtonHandler{

    private BuildMode bMode;
    private GameLogic gMode;
    private TerritoryButton selectedButton;

    public ButtonHandler(BuildMode bMode, GameLogic gMode) {
            this.bMode = bMode;
            this.gMode = gMode;

    }


    public void matchButtonWithTerritory(int id) {

          Territory t = gMode.getBoard().getTerritoryWithIndex(id);
          System.out.println(t.getId());
          //gMode.execute(t,GameMode.BUILD);
          gMode.execute(t,GameMode.CONNECTION);

    }

    public void checkButtonforRemoval(TerritoryButton button) {

        selectedButton= button;

    }

    public void executeButton() {
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
