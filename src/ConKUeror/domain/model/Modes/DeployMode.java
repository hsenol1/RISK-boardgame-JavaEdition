package ConKUeror.domain.model.Modes;

import java.io.Serializable;

import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;

public class DeployMode  implements Serializable{
    static int deployedArmy;


 public static void setDeployedArmy(Player p1) {


    //Army deployedArmy =p1.getInventory().getArmy();
    int territoryCount = p1.getInventory().getOwnedTerritories().size();

    if(territoryCount<9) {

        p1.getInventory().addInfantries(3);

    } else {
        System.out.println(territoryCount);
        int deployedArmyCount = territoryCount/3;
        System.out.println(deployedArmyCount);
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
