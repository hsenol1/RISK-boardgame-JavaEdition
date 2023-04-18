package src.ConKUeror.model.Player;

import java.util.List;

import src.ConKUeror.model.Army;
import src.ConKUeror.model.Board.Card;
import src.ConKUeror.model.Board.Territory;
import src.ConKUeror.model.Player.Strategies.IAttackBehaviour;
import src.ConKUeror.model.Player.Strategies.IDeployBehaviour;
import src.ConKUeror.model.Player.Strategies.IFortifyBehaviour;

public class Player {
    
        PlayerInventory inv;

        IDeployBehaviour db;
        IAttackBehaviour ab;
        IFortifyBehaviour fb;



        private String name;
        //private List<Army> armies;
        //private List<Territory> territories;
        private List<Card> cards;

        public Player(String name,
        IDeployBehaviour db,
        IAttackBehaviour ab,
        IFortifyBehaviour fb ) {

            this.name = name;
            this.db = db;
            this.ab = ab;
            this.fb = fb;


        }

        public void deploy() {
            db.deploy();
        }
        public void attack() {
            ab.attack();
        }

        public void fortify() {
            fb.fortify();
        }

        public String getName() {

            return this.name;
        }
        
        public List<Card> getCards() {

            return this.cards;
        }

        

        
        
    }
    

