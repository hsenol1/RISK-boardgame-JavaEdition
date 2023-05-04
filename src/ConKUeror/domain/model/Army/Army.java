package src.ConKUeror.domain.model.Army;

public class Army {

    public final static int INFANTRY_UNIT = 1;
    public final static int CAVALRY_UNIT = 5;
    public final static int ARTILLERY_UNIT = 10;

    
    private int infantry;
    private int cavalry;
    private int artillery;

    public Army() {
        this.infantry = 0;
        this.cavalry = 0;
        this.artillery = 0;
    }


    public void addInfantries(int inf) {
        this.infantry += inf;
    }
    public void addCavalries(int cav) {
        this.cavalry += cav;
    }
    public void addArtilleries(int art) {
        this.artillery += art;
    }

    public void removeInfantries(int inf) {
        this.infantry -= inf;
    }
    public void removeCavalries(int cav) {
        this.cavalry -= cav;

    }
    public void removeArtilleries(int art) {
        this.artillery -= art;
    }

    public int getInfantries() {
        return infantry; 
    }
    public int getCavalries() {
        return cavalry;
    }
    public int getArtilleries() {
        return artillery;
    }


    public int getTotalArmyUnit() {
        return infantry*INFANTRY_UNIT + cavalry*CAVALRY_UNIT +artillery*ARTILLERY_UNIT;
    }

    
}
