package ConKUeror.domain.model.Board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ConKUeror.domain.controller.AnimationMapListener;
import ConKUeror.domain.controller.MapListener;
import ConKUeror.domain.controller.TerritoryButtonListener;
import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Army.Artillery;
import ConKUeror.domain.model.Army.Cavalry;
import ConKUeror.domain.model.Army.Infantry;
import ConKUeror.domain.model.Army.Soldier;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerExpert;

public class DiceRoller implements Serializable {
    private List<AnimationMapListener> aMapListeners = new ArrayList<>();
    private static DiceRoller diceRollerInstance = null;
    private static int lossInteger = 0;
    private static int firstRollValue = 9;
    private static int secondRollValue = 9;
    Die die;
    PlayerExpert playerExpert;

    List<Soldier> attackingSoldiers;
    List<Soldier> defendingSoldiers;

    static List<Infantry> remainingInfantryList;
    static List<Cavalry> remainingCavalryList;
    static List<Artillery> remainingArtilleryList;

    static int attackingArmyUnitAtBeginning;
    static int attackingArmyUnitAtEnd;

    private DiceRoller() {
        this.die = Die.getDieInstance();
        playerExpert = PlayerExpert.getPlayerExpert();
    }

    public static DiceRoller getDiceRollerInstance() {
        if (diceRollerInstance == null) {
            diceRollerInstance = new DiceRoller();
        }
        return diceRollerInstance;
    }

    int attackerArmy;
    int defenderArmy;

    public int rollDice() {
        die.rollDie();
        return die.getFaceValue();
    }

    public static int getDefenderArmyLoss() {
        return lossInteger;
    }

    public static int[] getRollValues() {
        int[] returnArray = { firstRollValue, secondRollValue };
        return returnArray;
    }

    public void addAniMapListener(AnimationMapListener animationMapListener) {
        aMapListeners.add(animationMapListener);
    }

    public void displayAnimation(int number1, int number2) {
        for (AnimationMapListener aMapL : aMapListeners) {
            aMapL.showAnimation(number1, number2);
        }
    }

    public boolean rollForAttack(List<Infantry> attackingInfantries, List<Cavalry> attackingCavalries,
            List<Artillery> attackingArtilleries, Army defendingArmy) {
        boolean attackSuccess = false;
        lossInteger = defendingArmy.getTotalArmyUnit();
        attackingArmyUnitAtBeginning = attackingInfantries.size() + attackingCavalries.size() * 5
                + attackingArtilleries.size() * 10;

        attackingSoldiers = new ArrayList<Soldier>();
        defendingSoldiers = new ArrayList<Soldier>();

        // add all attacking soldiers to a list
        if (attackingInfantries.size() > 0) {
            for (Infantry infantry : attackingInfantries) {
                attackingSoldiers.add(infantry);
            }
        }

        if (attackingCavalries.size() > 0) {
            for (Cavalry cavalry : attackingCavalries) {
                attackingSoldiers.add(cavalry);
            }
        }

        if (attackingArtilleries.size() > 0) {
            for (Artillery artillery : attackingArtilleries) {
                attackingSoldiers.add(artillery);
            }
        }

        // add all defending soldiers to a list
        List<Infantry> defendingInfantries = defendingArmy.getInfantryList();
        List<Cavalry> defendingCavalries = defendingArmy.getCavalryList();
        List<Artillery> defendingArtilleries = defendingArmy.getArtilleryList();

        if (defendingInfantries.size() > 0) {
            for (Infantry infantry : defendingInfantries) {
                defendingSoldiers.add(infantry);
            }
        }

        if (defendingCavalries.size() > 0) {
            for (Cavalry cavalry : defendingCavalries) {
                defendingSoldiers.add(cavalry);
            }
        }

        if (defendingArtilleries.size() > 0) {
            for (Artillery artillery : defendingArtilleries) {
                defendingSoldiers.add(artillery);
            }
        }

        // loop until a list's size becomes 0
        if (attackingSoldiers.size() != 0 && defendingSoldiers.size() != 0) {
            // int attackerIndex = 0;
            // int defenderIndex = 0;
            int firstRoll = 0;
            int secondRoll = 0;
            while (attackingSoldiers.size() > 0 && defendingSoldiers.size() > 0) {

                firstRoll = rollDice();

                secondRoll = rollDice();

                System.out.println(firstRoll + " " + secondRoll);

                if (firstRoll > secondRoll) {
                    defendingSoldiers.get(0).takeHit();
                    if (defendingSoldiers.get(0).getHealth() == 0) {
                        defendingSoldiers.remove(0);
                        // defenderIndex++;
                    }
                } else {
                    attackingSoldiers.get(0).takeHit();
                    if (attackingSoldiers.get(0).getHealth() == 0) {
                        attackingSoldiers.remove(0);
                        // attackerIndex++;
                    }
                }

            }

            displayAnimation(firstRoll, secondRoll);

        }

        if (attackingSoldiers.size() != 0) {
            attackSuccess = true;
            addAllRemainingSoldiersToTheirRespectiveLists();
        } else {
            addAllRemainingSoldiersToTheirRespectiveLists();
        }

        return attackSuccess;

        // while (attackerArmy > 0 && defenderArmy > 0) {

        // die.rollDie();
        // int roll1 =die.getFaceValue();
        // //System.out.println(roll1);
        // die.rollDie();
        // int roll2 =die.getFaceValue();
        // //System.out.println(roll2);

        // if (roll1 > roll2) {
        // defenderArmy--;
        // System.out.println("ATTACKER HITS");

        // } else {
        // attackerArmy--;
        // System.out.println("DEFENDER HITS");

        // }
        // }
        // this.attackerArmy = attackerArmy;
        // this.defenderArmy = defenderArmy;

        // return defenderArmy == 0;

    }

    public int postWarGetAttackerArmy() {

        return attackerArmy;
    }

    public int postWarGetDefenderArmy() {
        return defenderArmy;

    }

    public void addAllRemainingSoldiersToTheirRespectiveLists() {
        remainingInfantryList = new ArrayList<Infantry>();
        remainingCavalryList = new ArrayList<Cavalry>();
        remainingArtilleryList = new ArrayList<Artillery>();

        for (Soldier soldier : attackingSoldiers) {
            if (soldier instanceof Infantry) {
                remainingInfantryList.add((Infantry) soldier);
            } else if (soldier instanceof Cavalry) {
                remainingCavalryList.add((Cavalry) soldier);
            } else {
                remainingArtilleryList.add((Artillery) soldier);
            }
        }
    }

    public Player getFirstPlayer() {

        return PlayerExpert.getPlayersList().get(die.getCustomValue(PlayerExpert.getPlayersListSize() - 1));

    }

    public static List<Infantry> getRemainingInfantryList() {
        return remainingInfantryList;
    }

    public static List<Cavalry> getRemainingCavalryList() {
        return remainingCavalryList;
    }

    public static List<Artillery> getRemainingArtilleryList() {
        return remainingArtilleryList;
    }

    public static int getAttackingArmyUnit() {
        return attackingArmyUnitAtEnd;
    }

}