package src.ConKUeror;


import src.ConKUeror.UI.Frames.BuildModeScreen;
import src.ConKUeror.domain.controller.BuildHandler;
import src.ConKUeror.domain.controller.HandlerFactory;
import src.ConKUeror.domain.model.Modes.BuildMode;

public class Main {


public static void main(String[] args) {


  HandlerFactory controller = HandlerFactory.getInstance();
  BuildHandler buildHandler = controller.giveBuildHandler();

 //view ın içine controller atıyoruz
 BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);




// view -> controller -> model



//observer design pattern


}
}

