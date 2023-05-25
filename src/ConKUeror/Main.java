package ConKUeror;


import ConKUeror.domain.controller.BuildHandler;
import ConKUeror.UI.Frames.BuildModeScreen;
import ConKUeror.domain.controller.HandlerFactory;

public class Main {


public static void main(String[] args) {


  HandlerFactory controller = HandlerFactory.getInstance();
  BuildHandler buildHandler = controller.giveBuildHandler();
  BuildModeScreen buildModeScreen = new BuildModeScreen(buildHandler);



}
}

