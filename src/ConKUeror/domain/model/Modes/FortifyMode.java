package src.ConKUeror.domain.model.Modes;

import src.ConKUeror.domain.model.Board.Territory;

public class FortifyMode {
    static int fortifiedArmy;


    public static Boolean isValidForFortify(Territory t) {

        if(t.getTotalUnit() > 1) {
            return true;
        } else {
            return false;
         }

    }

    public static int getMaxValue(Territory t) {

        int army = t.getTotalUnit();
        return (army-1);


     }

    public static void setFortifiedArmy(int army) {

        fortifiedArmy = army;

    }

    public static int getFortifiedArmy() {

       return fortifiedArmy;
    }
}
