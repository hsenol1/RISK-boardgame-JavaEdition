package src.ConKUeror.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import src.ConKUeror.model.BuildMode;
import src.ConKUeror.model.Player;


public class BuildHandler {
    

private BuildMode buildMode;


    public BuildHandler(BuildMode bMode) {
        this.buildMode = bMode;
        

	}

	public void registerAsListener(BuildModeListener listener) {
			buildMode.addBuildModeListener(listener);
	}


	public Boolean validateNumbersAndOpenPlayerMenu(int totalNum, int botNum) {		
			Boolean isValid = buildMode.validatePlayerNums(totalNum,botNum);
			return isValid;

	}

	public void enterName(String name) {
		buildMode.initalizePlayer(name);
	}

	public void openPlayerSelection() {
		buildMode.handleMenuLogicAndPlayerCreation();
	}
	






}
