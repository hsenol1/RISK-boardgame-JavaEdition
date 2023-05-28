package ConKUeror.domain.controller;

import java.util.List;

import ConKUeror.domain.model.Data.GameState;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GameHandler {

    List<String> buttons = new ArrayList<String>();

    private static GameHandler instance;
    private GameHandler() {

    }

    public static GameHandler getInstance() {

        if (instance == null) {
            instance = new GameHandler();
        }
        return instance;
    }
 
    

    public void registerPlayerPanelAsListener(PlayerExpertListener listener) {
        PlayerExpert.addPlayerPanelAsListener(listener);

    }



    public List<String >getButtonNames() {


        buttons.add("Add Connection");
        buttons.add("Remove");
        buttons.add("Next");

        return buttons;




    }




}
