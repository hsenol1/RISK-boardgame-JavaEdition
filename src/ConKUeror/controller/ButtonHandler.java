package src.ConKUeror.controller;

import src.ConKUeror.model.BuildMode;
import src.ConKUeror.model.GameLogic;
import src.ConKUeror.model.Board.Territory;
import src.ConKUeror.view.MyButton;

public class ButtonHandler{

    private BuildMode bMode;
    private GameLogic gMode;

    public ButtonHandler(BuildMode bMode, GameLogic gMode) {
            this.bMode = bMode;
            this.gMode = gMode;
      
    }


    public void matchButton(int id) {

          Territory t =   gMode.getBoard().getTerritoryWithIndex(id);
        
          System.out.println("you clicked this button. this button has id:"); 
           System.out.println(t.getId()); 
    }




    public int getXFromList(int i) {

        return bMode.getCoordinateList().get(i).getX();
    }

    public int getYFromList(int i) {

        return bMode.getCoordinateList().get(i).getY();

    }



    
}
