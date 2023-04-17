package src.ConKUeror.model;

public class PlayerInventory {

private Player p;



public void deleteCards(Card c[]) {
    
    for(Card c1: c) {

        p.getCards().remove(c1);
        
    }



}
}