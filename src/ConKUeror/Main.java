package src.ConKUeror;

import javax.swing.JFrame;

import src.ConKUeror.controller.BuildHandler;
import src.ConKUeror.model.BuildMode;
import src.ConKUeror.view.BuildModeScreen;

public class Main {


public static void main(String[] args) {

 BuildMode buildMode = new BuildMode();
 BuildHandler buildHandler= new BuildHandler(buildMode);

 BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);


}
}

