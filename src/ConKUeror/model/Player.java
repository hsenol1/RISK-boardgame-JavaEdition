package src.ConKUeror.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
        private String name;
        private List<Army> armies;
        private List<Territory> territories;
        private List<Card> cards;

        public Player(String name, List<Card> cards) {
            this.name = name;
            this.cards = cards;

        }

        public String getName() {

            return this.name;
        }
        
        public List<Card> getCards() {

            return this.cards;
        }

        
        
    }
    

