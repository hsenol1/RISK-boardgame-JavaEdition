package src.ConKUeror.domain.controller;

import java.util.List;
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




    public List<String >getButtonNames() {


        buttons.add("Add Connection");
        buttons.add("Remove");
        buttons.add("Next");

        return buttons;


    }




}
