package src.ConKUeror.controller;

import src.ConKUeror.model.BuildMode;
import src.ConKUeror.model.GameLogic;
import src.ConKUeror.model.Board.Territory;
import src.ConKUeror.model.GameLogic.GameState;
import src.ConKUeror.view.MyButton;

public class ButtonHandler{

    private BuildMode bMode;
    private GameLogic gMode;
    private MyButton selectedButton;

    public ButtonHandler(BuildMode bMode, GameLogic gMode) {
            this.bMode = bMode;
            this.gMode = gMode;
      
    }


    public void matchButtonWithTerritory(int id) {

          Territory t = gMode.getBoard().getTerritoryWithIndex(id);  
          System.out.println(t.getId());     
          gMode.execute(t);

    }

    public void checkButtonforRemoval(MyButton button) {

        selectedButton= button;

    }

    public void executeButton() {
       gMode.publishBoardEvent(selectedButton);;

    } 




    public int getXFromList(int i) {

        return bMode.getCoordinateList().get(i).getX();
    }

    public int getYFromList(int i) {

        return bMode.getCoordinateList().get(i).getY();

    }



    
}
