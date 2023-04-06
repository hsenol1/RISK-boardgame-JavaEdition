package src.ConKUeror;

import javax.swing.JFrame;

import src.ConKUeror.controller.BuildModeController;
import src.ConKUeror.model.BuildMode;
import src.ConKUeror.view.BuildModeScreen;

public class Main {


public static void main(String[] args) {

 BuildMode buildMode = new BuildMode() ;
 BuildModeScreen buildModeScreen = new BuildModeScreen();
 BuildModeController buildModeController = new BuildModeController(buildModeScreen, buildMode);


}
}

