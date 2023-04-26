package src.ConKUeror.domain.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Modes.StartMode;


public class BuildHandler {
    
private Boolean firstConfirm = true;
private BuildMode buildMode;
private Board board;
private GameLogic gamelogic;
private StartMode sMode;

    public BuildHandler(BuildMode bMode) {
        this.buildMode = bMode;

	}

	public void registerAsListener(BuildModeListener listener) {
			buildMode.addBuildModeListener(listener);
	}

	public void validateNumbers(int totalNum, int botNum ) {
		
			Boolean isValid = buildMode.validatePlayerNums(totalNum, botNum);
			if(isValid && firstConfirm) {
				buildMode.openPlayerInputPanel();
				firstConfirm = false;
			}

	}

	
	public void enterNameForRealPlayers(String name) {
		buildMode.initalizePlayer(name,"Real Player");
	}


	public void initalizeBots(int botPlayerCount) {
		
		for (int i = 1; i <= botPlayerCount; i++) {
			String name = "Computer " + i;
			buildMode.initalizePlayer(name, "Computer Player");
		}

	}

	public void openPlayerSelection() {
		buildMode.openPlayerInputPanel();
	}

	public void setStartStatus() {
		buildMode.setStart();
	}

	

	//burada da controllerda logic kullanıyorum. Bu olabilir mi bilmiyorum bunu da sorarım da şu anlık işler kod olması için yapıyorum
	public void initializeGame() {
		 board = new Board();
		 
		 sMode = new StartMode(buildMode);

		 gamelogic = new GameLogic(board);
    }

	



	public MapHandler giveMapHandler() {

			MapHandler mapHandler = new MapHandler(gamelogic,board);
			return mapHandler;

	}

	public ButtonHandler giveButtonHandler() {

		ButtonHandler buttonHandler = new ButtonHandler(buildMode,gamelogic);
		return buttonHandler;


}

public StartHandler giveStartHandler() {

			StartHandler startHandler = new StartHandler(sMode);
			return startHandler;
}








}
