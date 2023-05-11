package src.ConKUeror.domain.model.Modes;

import src.ConKUeror.domain.model.Army.Army;
import src.ConKUeror.domain.model.Player.Player;

public class DeployMode {


 public static void setDeployedArmy(Player p1) {

    //Army deployedArmy =p1.getInventory().getArmy();
    int territoryCount = p1.getInventory().getOwnedTerritories().size();

    if(territoryCount<9) {

        p1.getInventory().addInfantries(3);

    } else {

        int deployedArmyCount = territoryCount/3;
        p1.getInventory().addInfantries(deployedArmyCount);
    }

 }







}
