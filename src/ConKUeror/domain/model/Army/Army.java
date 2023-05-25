package ConKUeror.domain.model.Army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public final static int INFANTRY_UNIT = 1;
    public final static int CAVALRY_UNIT = 5;
    public final static int ARTILLERY_UNIT = 10;

    private int totalArmy;


    private List<Infantry> infantryList = new ArrayList<Infantry>();
    private List<Cavalry> cavalaryList = new ArrayList<Cavalry>();
    private List<Artillery> artilleryList = new ArrayList<Artillery>();

    private int infantry;
    private int cavalry;
    private int artillery;

    public Army() {
        this.infantry = 0;
        this.cavalry = 0;
        this.artillery = 0;
    }


    public void addInfantries(int n) {
        for(int i = 0 ; i< n ; i++) {
            Infantry inf = new Infantry();
            addInfantrytoInfantryList(inf);
        }
    }
    public void addCavalries(int n) {
        for(int i = 0 ; i< n ; i++) {
            Cavalry cav = new Cavalry();
            addCavalarytoCavalaryList(cav);
        }
    }
    public void addArtilleries(int n) {
        for(int i = 0 ; i< n ; i++) {
            Artillery art = new Artillery();
            addArtillerytoArtilleryList(art);
        }    }

    public void removeInfantries(int inf) {
        if (!infantryList.isEmpty()) {

            for(int i = 0; i<inf ; i++) {
                infantryList.remove(infantryList.size()-1);
            }

        }



        }
    public void removeCavalries(int cav) {
        if (!cavalaryList.isEmpty()) {
            for(int i = 0; i<cav ; i++) {
                cavalaryList.remove(cavalaryList.size()-1);
            }

        }





    }
    public void removeArtilleries(int art) {
        if (!artilleryList.isEmpty()) {

            for(int i = 0; i<art ; i++) {
                artilleryList.remove(artilleryList.size()-1);
            }
        }

    }

    public int getInfantries() {
        return infantryList.size();
    }
    public int getCavalries() {
        return cavalaryList.size();
    }
    public int getArtilleries() {
        return artilleryList.size();
    }

    public void addInfantrytoInfantryList(Infantry inf) {
        infantryList.add(inf);

    }
    public void addCavalarytoCavalaryList(Cavalry cav) {
        cavalaryList.add(cav);

    }

    public void addArtillerytoArtilleryList(Artillery ar) {
        artilleryList.add(ar);

    }

    public int getTotalArmyUnit() {
        totalArmy= getInfantries()*INFANTRY_UNIT + getCavalries()*CAVALRY_UNIT +getArtilleries()*ARTILLERY_UNIT;
        return totalArmy;
    }

    public void setTotalArmyUnit(int newArmyUnit) {
        this. totalArmy = newArmyUnit;
    }


}
