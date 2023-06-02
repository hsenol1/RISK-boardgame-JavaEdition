
package ConKUeror.domain.controller;



import java.awt.Color;
import java.io.Serializable;

import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Modes.BuildMode;
import ConKUeror.domain.model.Modes.GameLogic;
import ConKUeror.domain.model.Modes.StartMode;


public class BuildHandler  implements Serializable{

private static BuildHandler instance;
private Boolean isFirstConfirmClick = true;
private BuildMode buildMode;
private Board board;
private GameLogic gamelogic;
private StartMode sMode;

    private BuildHandler(BuildMode bMode) {
        this.buildMode = bMode;

	}
	public static BuildHandler getInstance(BuildMode buildMode) {
        if (instance == null) {
            instance = new BuildHandler(buildMode);
        }
        return instance;
    }

	public void registerAsListener(BuildModeListener listener) {
			buildMode.addBuildModeListener(listener);
	}

	public void handlePlayerCounts(int totalNum, int botNum ) {

			Boolean isPlayerCountsValid = buildMode.validatePlayerNums(totalNum, botNum);
			if(isPlayerCountsValid && isFirstConfirmClick) {
				buildMode.setPlayerIndex();
				isFirstConfirmClick = false;
			}

	}


	public void enterNameForRealPlayers(String name) {
		buildMode.initalizePlayer(name,"Real Player");
	}
	public GameLogic getGameLogic(){
		return gamelogic;
	}
	public void initializeColoredPlayers(String name , Color color){
		buildMode.initalizeColoredPlayer(name,"Real Player",color);
	}
	public void initalizeBots(int botPlayerCount) {

		for (int i = 1; i <= botPlayerCount; i++) {
			String name = "Comp" +i;
			buildMode.initalizePlayer(name, "Computer Player");
		}

	}
	public void initalizeColoredBots(int botPlayerCount, Color color) {

		for (int i = 1; i <= botPlayerCount; i++) {
			String name = "Comp" +i;
			buildMode.initalizeColoredPlayer(name, "Computer Player", color);
		}

	}
	public void openPlayerSelection() {
		buildMode.setPlayerIndex();
	}

	public void setStartStatus() {
		buildMode.setStart();
	}
	public BuildMode getBuildMode(){
		return buildMode;
	}


	public void initializeGame() {

		buildMode.initalizeConnections();
		HandlerFactory controller = HandlerFactory.getInstance();
		 StartHandler startHandler =controller.giveStartHandler();
		 startHandler.setStartMode();
    }







}
