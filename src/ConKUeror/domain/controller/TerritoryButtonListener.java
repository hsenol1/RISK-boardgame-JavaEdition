package ConKUeror.domain.controller;

import java.util.List;
import java.awt.Color;


import ConKUeror.UI.Buttons.TerritoryButton;

public interface TerritoryButtonListener {

    void getButtonList(List<Integer> neigborIdsList);
    void setTerritoryButtonInfo(int buttonID,int armyUnit,Color color,int territoryArmy);
    void setArmyCount(int armyCount);
    void updateTerritory(int buttonID,int army );
}
