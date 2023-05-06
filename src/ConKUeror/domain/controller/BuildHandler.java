package src.ConKUeror.domain.controller;



import src.ConKUeror.domain.model.Board.Board;
import src.ConKUeror.domain.model.Modes.BuildMode;
import src.ConKUeror.domain.model.Modes.GameLogic;
import src.ConKUeror.domain.model.Modes.StartMode;


public class BuildHandler {

private static BuildHandler instance;
private Boolean firstConfirm = true;
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





	public void initializeGame() {

		buildMode.initalizeConnections();
		HandlerFactory controller = HandlerFactory.getInstance();
		 StartHandler startHandler =controller.giveStartHandler();
		 startHandler.setStartMode();
    }







}
