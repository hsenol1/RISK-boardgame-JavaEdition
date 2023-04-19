package src.ConKUeror.view;

import javax.swing.JFrame;

import src.ConKUeror.controller.MapHandler;

public class Map extends JFrame{

    MapHandler mapHandler;

public Map(MapHandler _mapHandler) {

    this.mapHandler = _mapHandler;
    setVisible(true);

    
}



}
