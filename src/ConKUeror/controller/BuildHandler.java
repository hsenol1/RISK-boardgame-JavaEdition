package src.ConKUeror.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import src.ConKUeror.model.BuildMode;


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
		buildMode.handleMenuLogicAndPlayerCreation();
	}
	






}
