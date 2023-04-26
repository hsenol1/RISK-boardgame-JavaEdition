package src.ConKUeror;

import javax.swing.JFrame;

import src.ConKUeror.UI.BuildModeScreen;
import src.ConKUeror.domain.controller.BuildHandler;
import src.ConKUeror.domain.model.Modes.BuildMode;

public class Main {


public static void main(String[] args) {

 BuildMode buildMode = new BuildMode(); 


 // controllerın içine modeli atıyoruz
 BuildHandler buildHandler= new BuildHandler(buildMode);


 //view ın içine controller atıyoruz
 BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);




// view -> controller -> model



//observer design pattern


}
}

