package ConKUeror.domain.model.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ConKUeror.domain.model.Board.Board;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Player;
import ConKUeror.domain.model.Player.PlayerInventory;

public class PlayerData {
    private String playerName;
    private int armySize;
    private List<Territory> territories;
    private PlayerInventory inventory;
    public PlayerData(Player player) {
        this.playerName = player.getName();
        this.armySize = player.getInventory().getNumberOfArmies();
        this.territories = player.getInventory().getOwnedTerritories();
        this.inventory = player.getInventory();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getArmySize() {
        return this.armySize;
    }
    public void setArmySize(int n){
        this.armySize = n;
    }

    public List<Territory> getTerritories() {
        return this.territories;
    }
    /*public static PlayerData fromString(String str, List<Player> playerList) {
        String[] parts = str.split(",");
        for (Player player : playerList) {
            if (player.getName().equals(parts[0])) {
                PlayerData playerData = new PlayerData(player);
                playerData.armySize = Integer.parseInt(parts[1]);
    
                List<Integer> territoryIds = Arrays.stream(parts[2].split(";"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    
                playerData.setTerritoriesFromIds(territoryIds);
                return playerData;
            }
        }
        return null;
    }*/

   /*  public static PlayerData fromString(String str, List<Player> playerList) {
        String[] parts = str.split(",");
        for (Player player : playerList) {
            if (player.getName().equals(parts[0])) {
                PlayerData playerData = new PlayerData(player);
                playerData.armySize = Integer.parseInt(parts[1]);
    
                List<Integer> territoryIds = Arrays.stream(parts[2]
                    .replaceAll("\\[|\\]", "") // Remove square brackets
                    .split(";"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    
                playerData.setTerritoriesFromIds(territoryIds);
                return playerData;
            }
        }
        return null;
    }
    */
    public static PlayerData fromString(String str, List<Player> playerList) {
        String[] parts = str.split(",");
        for (Player player : playerList) {
            if (player.getName().equals(parts[0])) {
                PlayerData playerData = new PlayerData(player);
                if (!parts[1].isEmpty()) {
                    try {
                        playerData.armySize = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing armySize: " + e.getMessage());
                    }
                }
                List<Integer> territoryIds = Arrays.stream(parts[2]
                    .replaceAll("\\[|\\]", "") // Remove square brackets
                    .split(";"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
                playerData.setTerritoriesFromIds(territoryIds);
                return playerData;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return playerName + "," + armySize + "," + String.join(";", territories.toString());
    }
    public void setTerritoriesFromIds(List<Integer> territoryIds) {
        for (Integer id : territoryIds) {
            Territory territory = Board.getTerritories().get(id);
            if (territory != null) {
                this.territories.add(territory);
            } else {
                throw new IllegalArgumentException("Territory with id " + id + " does not exist.");
            }
        }
    }

    public int getInfantryCount() {
        return inventory.getInfantryCount();
    }
    public int getArtilleryCount() {
        return inventory.getArtilleryCount();
    } 
     public int getCavalryCount() {
        return inventory.getCavalryCount();
    }  
}
