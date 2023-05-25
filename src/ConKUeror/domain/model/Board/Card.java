package ConKUeror.domain.model.Board;
import ConKUeror.domain.model.Player.*;



public abstract class Card {

    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void use(Player player);



}