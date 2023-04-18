package src.ConKUeror.model;

public class PlayerInventory {

private Player p;



public void deleteCards(Card c[]) {
    
    for(Card c1: c) {

        p.getCards().remove(c1);
        
    }
}

    public void insertArmies(Army a[]) {

        for (Army a1: a) {
        
        //p.getArmies().add(a1);
        
        }
    }
}