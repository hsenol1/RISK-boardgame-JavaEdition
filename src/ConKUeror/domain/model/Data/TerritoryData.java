package ConKUeror.domain.model.Data;

import java.awt.Color;
import java.io.Serializable;
import java.util.Map;

import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Player;

public class TerritoryData implements Serializable {

    private int artillery;
    private int cavalry;
    private int infantry;
    private Color color;
    private Player owner;
    private Boolean isDeleted;
    private int id;
    private int totalUnit;

    private Territory territory;
    //private Map<Integer, Territory> adjacencyList;

    public void setArtillery(int artillery) {
        this.artillery = artillery;
    }

    public void setCavalry(int cavalry) {
        this.cavalry = cavalry;
    }

    public void setInfantry(int infantry) {
        this.infantry = infantry;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }

    public int getArtillery() {
        return artillery;
    }

    public int getCavalry() {
        return cavalry;
    }

    public int getInfantry() {
        return infantry;
    }

    public Color getColor() {
        return color;
    }

    public Player getOwner() {
        return owner;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public int getId() {
        return id;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    public Territory getTerritory() {
        return territory;
    }

    public TerritoryData(Territory territory) {
        this.territory = territory;

        this.artillery = territory.getArmy().getArtilleries();
        this.cavalry = territory.getArmy().getCavalries();
        this.infantry = territory.getArmy().getInfantries();
        this.color =  territory.getColor();
        this.owner = territory.getOwner();
        this.isDeleted =territory.isDeleted();
        this.id = territory.getId();
        this.totalUnit = territory.getTotalUnit();
       // territory.getAdjacencyList();



    }

}
