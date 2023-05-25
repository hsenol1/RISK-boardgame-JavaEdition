package ConKUeror.domain.model.Board;
import ConKUeror.domain.model.Player.*;
public abstract class ChanceCard {
    public enum ChanceType {
        ALLIANCE, REINFORCEMENTS, SABOTAGE, COUP, SURPRISE_ATTACK, DIPLOMATIC_IMMUNITY, MERCENARIES
    }

    private ChanceType type;
    private String name;
    private String description;

    public ChanceCard(String name, String description) {
       // super(name);
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public abstract void use(Player player, Board board);


    public class AllianceCard extends ChanceCard {
        public AllianceCard() {
            super("Alliance", "Form an alliance with another player of your choice for the duration of the turn.");
        }

        @Override
        public void use(Player player, Board gameMap) {
            Player otherPlayer = gameMap.choosePlayerForAlliance(player);

            if (otherPlayer != null) {
                gameMap.formAlliance(player, otherPlayer);
            }
        }
    }

    public class ReinforcementsCard extends ChanceCard {
        public ReinforcementsCard() {
            super("Reinforcements", "Add a certain number of armies to one of your territories.");
        }

        @Override
        public void use(Player player, Board gameMap) {
            int additionalArmies = gameMap.rollDiceForReinforcements();

            Territory territoryToReinforce = gameMap.chooseTerritoryToReinforce(player);

            if (territoryToReinforce != null) {
               // territoryToReinforce.addArmy(additionalArmies);
            }
        }
    }
    public class SabotageCard extends ChanceCard {
        public SabotageCard() {
            super("Sabotage", "Remove a certain number of armies from an opponent's territory.");
        }


        @Override
        public void use(Player player,Board gameMap) {
            int armiesToRemove = gameMap.rollDiceForSabotage();

            Territory territoryToSabotage = gameMap.chooseTerritoryToSabotage(player);

            if (territoryToSabotage != null) {
                // Remove the specified number of armies from the chosen territory
                //territoryToSabotage.removeArmies(armiesToRemove);
            }

        }

    }
        public class CoupCard extends ChanceCard {
            public CoupCard() {
                super("Coup", "Take control of one of your opponent's territories without a fight.");
            }

            @Override
            public void use(Player player, Board gameMap) {
                Territory territoryToConquer = gameMap.chooseTerritoryToConquer(player);

                if (territoryToConquer != null) {
                    // Transfer control of the territory to the player and remove all opponent's armies
                    territoryToConquer.setOwner(player);
                   // territoryToConquer.removeArmies(territoryToConquer.getTotalUnit());
                }
            }
        }
        public class SurpriseAttackCard extends ChanceCard {
            public SurpriseAttackCard() {
                super("Surprise Attack", "Launch a surprise attack on an opponent's territory.");
            }

            @Override
            public void use(Player player,Board gameMap) {
                int additionalArmies = gameMap.rollDiceForSurpriseAttack();

                Territory attackingTerritory = gameMap.chooseAttackingTerritory(player);
                Territory defendingTerritory = gameMap.chooseDefendingTerritory(player, attackingTerritory);

                if (attackingTerritory != null && defendingTerritory != null) {
                    gameMap.performSurpriseAttack(attackingTerritory, defendingTerritory, additionalArmies);
                }
            }
        }
        public class DiplomaticImmunityCard extends ChanceCard {
            public DiplomaticImmunityCard() {
                super("Diplomatic Immunity", "Protect one of your territories from attack for one turn.");
            }

            @Override
            public void use(Player player, Board gameMap) {
                Territory territoryToProtect = gameMap.chooseTerritoryToProtect(player);

                if (territoryToProtect != null) {
                    gameMap.protectTerritoryFromAttack(territoryToProtect);
                }
            }
        }

        // Mercenaries
        public class MercenariesCard extends ChanceCard {
            public MercenariesCard() {
                super("Mercenaries", "Hire a group of mercenaries to fight for you.");
            }

            @Override
            public void use(Player player, Board gameMap) {
                int additionalArmies = gameMap.rollDiceForMercenaries();


                Territory territoryToDeploy = gameMap.chooseTerritoryToDeployMercenaries(player);

                if (territoryToDeploy != null) {
                    // Deploy the mercenaries to the chosen territory
                    //territoryToDeploy.addArmy(additionalArmies);
                }
            }






        }


}
