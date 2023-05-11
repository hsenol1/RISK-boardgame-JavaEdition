package src.ConKUeror.domain.model.Modes;

import src.ConKUeror.domain.model.Army.Army;
import src.ConKUeror.domain.model.Player.Player;
import src.ConKUeror.domain.model.Player.PlayerExpert;

public class DeployMode {
    static int deployedArmy;


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


 public static int getMaxValue() {

    Player player = PlayerExpert.getPlayerInTurn();
    System.out.println(player.getName());
      System.out.println(player.getInventory().getArmy().getTotalArmyUnit());
    return player.getInventory().getArmy().getTotalArmyUnit();


 }

 public static void setDeployedArmy(int army) {
    deployedArmy = army;

 }

 public static int getDeployedArmy() {

    return deployedArmy;
 }







}
