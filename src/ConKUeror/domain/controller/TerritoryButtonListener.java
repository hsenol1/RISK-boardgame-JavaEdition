package ConKUeror.domain.controller;

import java.util.List;
import java.awt.Color;


import ConKUeror.UI.Buttons.TerritoryButton;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Player;

public interface TerritoryButtonListener {

    void getButtonList(List<Integer> neigborIdsList);
    void setTerritoryButtonInfo(int buttonID,int armyUnit,Color color,int territoryArmy);
    void setArmyCount(int armyCount);
    void updateTerritory(int buttonID,int army );

    //attack result update only
    void updateAfterAttack(boolean attackResult, Player playerInTurn, Territory territory, Territory territory2);

    
}
