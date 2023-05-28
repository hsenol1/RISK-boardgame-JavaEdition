package ConKUeror.domain.model.Army;


public class ArmyFactory {
    private static ArmyFactory instance;
    private ArmyFactory() {};

    public static ArmyFactory getInstance() {
        if(instance==null) {
            instance = new ArmyFactory();
        }
        return instance;

    }


    public void createInfantaries(int n, Army army) {


        for(int i = 0; i<n; i++) {
            Infantry infantry = new Infantry();
            army.addInfantrytoInfantryList(infantry);
        }


    }
    public void createArtilleries(int n, Army army) {

        for(int i = 0; i<n; i++) {
            Artillery artillery = new Artillery();
            army.addArtillerytoArtilleryList(artillery);
         }



    }
    public void createCavalaries(int n, Army army) {

        for(int i = 0; i<n; i++) {
            Cavalry cavalary = new Cavalry();
            army.addCavalrytoCavalryList(cavalary);
            }


    }

}