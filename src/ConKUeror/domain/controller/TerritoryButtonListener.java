package src.ConKUeror.domain.controller;

import java.util.List;
import java.awt.Color;


import src.ConKUeror.UI.Buttons.TerritoryButton;

public interface TerritoryButtonListener {

    void getButtonList(List<Integer> neigborIdsList);
    void setTerritoryButtonInfo(int buttonID,int armyUnit,Color color,int territoryArmy);
}
