package src.ConKUeror;

import javax.swing.JFrame;

import src.ConKUeror.controller.BuildHandler;
import src.ConKUeror.model.BuildMode;
import src.ConKUeror.view.BuildModeScreen;

public class Main {


public static void main(String[] args) {

 BuildMode buildMode = new BuildMode(); // model never takes parameters

 // controllerın içine modeli atıyoruz
 BuildHandler buildHandler= new BuildHandler(buildMode);


 //view ın içine controller atıyoruz
 BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);




// view -> controller -> model

//observer design pattern
}
}

