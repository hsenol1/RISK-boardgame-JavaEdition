package ConKUeror.domain.model.Board;
import java.io.Serializable;

import ConKUeror.domain.model.Player.*;



public abstract class Card implements Serializable{

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