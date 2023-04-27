package src.ConKUeror.domain.controller;
import java.util.List;
import java.util.ArrayList;
import src.ConKUeror.domain.model.Board.*;
import src.ConKUeror.domain.model.Player.*;
import java.util.Collections;
public class CardController {
    private List<Card> deck;
    private Card activeCard;

    public CardController(List<Player> players, int numberOfTerritories) {
        deck = new ArrayList<>();
        initializeDeck(players, numberOfTerritories);
    }

    private void initializeDeck(List<Player> players, int numberOfTerritories) {
        // Add territory cards
        for (int i = 1; i <= numberOfTerritories; i++) {
            deck.add(new TerritoryCard("Territory Card " + i, "Territory " + i));
        }

        // Add army cards for each player
        for (Player player : players) {
            for (int i = 1; i <= 3; i++) {
                deck.add(new ArmyCard("Infantry Card " + i, ArmyCard.ArmyType.INFANTRY));
            }
            for (int i = 1; i <= 2; i++) {
                deck.add(new ArmyCard("Cavalry Card " + i, ArmyCard.ArmyType.CAVALRY));
            }
            deck.add(new ArmyCard("Artillery Card", ArmyCard.ArmyType.ARTILLERY));
        }

        // Add chance cards
        for (ChanceCard.ChanceType chanceType : ChanceCard.ChanceType.values()) {
            deck.add(new ChanceCard(chanceType.name() + " Card", chanceType));
        }

        // Shuffle the deck
        Collections.shuffle(deck);
    }

    public Card drawCard(Player player) {
       
          if (!deck.isEmpty()) {
            activeCard = deck.remove(0);
           
            //player.addCardToHand(activeCard); //will implement this method


            return activeCard;
        } else {
            
            return null;
        }
    }

    public void playCard(Player player, Card card) {
        card.use(player);
        discardCard(player, card);
    }

    public void discardCard(Player player, Card card) {
        
       //player.removeCardFromHand(card); will implement this one too
        //  kartı alta eri koysun mu koymasın mı buna karar verelim opsiyonel
        deck.add(card);
        // Shuffle the deck
        Collections.shuffle(deck);
    }
}
