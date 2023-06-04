package ConKUeror;

import ConKUeror.UI.Frames.BuildModeScreen;
import ConKUeror.UI.Frames.LoginFrame;
import ConKUeror.UI.Frames.MapView;
import ConKUeror.UI.HelpScreen.HelpScreen;
import ConKUeror.UI.HelpScreen.MapScreen;
import ConKUeror.domain.controller.BuildHandler;
import ConKUeror.domain.controller.HandlerFactory;
import ConKUeror.domain.model.Board.Board;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws IOException {
        
        SwingUtilities.invokeLater(LoginFrame::new);
      

        HandlerFactory controller = HandlerFactory.getInstance();

        BuildHandler buildHandler = controller.giveBuildHandler();

        buildHandler.initalizeBots(2);
        buildHandler.initializeGame();
              try {
                MapView map = new MapView();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


    }
}
