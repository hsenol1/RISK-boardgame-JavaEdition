package src.ConKUeror.domain.model.Player;

import src.ConKUeror.domain.model.Army.Army;

import src.ConKUeror.domain.model.Board.Card;

public class PlayerInventory {

private Player p;

private int infantryNum;
private int cavalryNum;
private int artilleryNum;
private Army army;


   public PlayerInventory() {
        this.army = new Army();
    }

    public void addInfantries(int n) {
        army.addInfantries(n);
    }
    public void addArtilleries(int n) {
        army.addArtilleries(n);
    }
    
    public void addCavalries(int n) {
        army.addCavalries(n);
    }

    public int getTotalArmy() {
       return  army.getTotalArmyUnit();
    }
    





public void deleteCards(Card c[]) {
    
    for(Card c1: c) {

        p.getCards().remove(c1);
        
    }
}

    
}