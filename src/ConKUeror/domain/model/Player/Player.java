package ConKUeror.domain.model.Player;

import java.awt.Color;
import java.util.List;

import ConKUeror.domain.model.Army.Army;
import ConKUeror.domain.model.Board.Card;
import ConKUeror.domain.model.Board.Territory;
import ConKUeror.domain.model.Player.Strategies.IAttackBehaviour;
import ConKUeror.domain.model.Player.Strategies.IDeployBehaviour;
import ConKUeror.domain.model.Player.Strategies.IFortifyBehaviour;

public class Player {

        public PlayerInventory inv = new PlayerInventory();
        //private Army deployedArmy = new Army();
        private String type;
        private Color playerColor;

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
        IFortifyBehaviour fb,
        PlayerInventory inv) {

            this.name = name;
            this.db = db;
            this.ab = ab;
            this.fb = fb;
            this.inv = inv;


        }


        public void setType(String type) {
            this.type = type;
        }


        public String getType() {
            return this.type;
        }




        public void setColor(Color color) {
                this.playerColor = color;

        }
        public Color getColor() {
            return playerColor;
        }

/**
 * Deploy Method
 *
 * Requires: (about domain range of values) -> Düzelt
 * Modifies: Territory.army and Player.playerInventory
 * Effects: Armies are deployed to territory's army,
 * and from player's inventory army is removed.</p>
 */
        public void deploy(Territory t, int army) {
            db.deploy(t,army);
        }

        public void attack(int attackingArmy, int defendingArmy) {
            ab.attack(attackingArmy, defendingArmy);
        }

        public void fortify(Territory fortifyFrom, Territory fortifyTo, int army) {
            fb.fortify(fortifyFrom,fortifyTo,army);
        }

        public String getName() {

            return this.name;
        }

        public List<Card> getCards() {

            return this.cards;
        }

        public PlayerInventory getInventory() {
            return inv;


        }


    }


