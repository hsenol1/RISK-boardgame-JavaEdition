package src.ConKUeror.domain.controller;
import java.util.List;
import java.util.ArrayList;
import src.ConKUeror.domain.model.Board.*;
import src.ConKUeror.domain.model.Player.*;
import java.util.Collections;
public class CardController {

    private List<Card> armyDeck;
    private List<Card> terittoryDeck;

    private List<ChanceCard> chanceDeck;
    private Card activeTerritoryCard;
    private Card activeArmyCard;
    private ChanceCard activeChanceCard;



    public CardController(List<Player> players, int numberOfTerritories) {
        terittoryDeck = new ArrayList<>();
        armyDeck = new ArrayList<>();
        chanceDeck = new ArrayList<>();

        initializeDeck(players, numberOfTerritories);
    }

    private void initializeDeck(List<Player> players, int numberOfTerritories) {
        // Add territory cards
        for (int i = 1; i <= numberOfTerritories; i++) {
            terittoryDeck.add(new TerritoryCard("Territory Card " + i, "Territory " + i));
        }

        // Add army cards for each player
        for (Player player : players) {
            for (int i = 1; i <= 3; i++) {
                armyDeck.add(new ArmyCard("Infantry Card " + i, ArmyCard.ArmyType.INFANTRY));
            }
            for (int i = 1; i <= 2; i++) {
                armyDeck.add(new ArmyCard("Cavalry Card " + i, ArmyCard.ArmyType.CAVALRY));
            }
            armyDeck.add(new ArmyCard("Artillery Card", ArmyCard.ArmyType.ARTILLERY));
        }

        // Add chance cards
       /*  for (ChanceCard.ChanceType chanceType : ChanceCard.ChanceType.values()) {
            String name = chanceType.name() + " Card";
            chanceDeck.add(new ChanceCard(      chanceType.name() + " Card";
            , chanceType));
        }
*/
        // Shuffle the deck
        Collections.shuffle(chanceDeck);
        Collections.shuffle(armyDeck);
        Collections.shuffle(terittoryDeck);

    }

    public ChanceCard drawChanceCard(Player player) {

          if (!chanceDeck.isEmpty()) {
            activeChanceCard = chanceDeck.remove(0);

            //player.addCardToHand(activeCard); //will implement this method


            return activeChanceCard;
        } else {

            return null;
        }
    }
    public Card drawTerritoryCard(Player player) {

        if (!terittoryDeck.isEmpty()) {
          activeTerritoryCard = terittoryDeck.remove(0);

          //player.addCardToHand(activeCard); //will implement this method


          return activeTerritoryCard;
      } else {

          return null;
      }
  }
  public Card drawArmyCard(Player player) {

    if (!armyDeck.isEmpty()) {
      activeArmyCard = armyDeck.remove(0);

      //player.addCardToHand(activeCard); //will implement this method


      return activeArmyCard;
  } else {

      return null;
  }
}

    public void playCard(Player player, Card card) {
        card.use(player);
       // discardCard(player, card);
    }
/*
    public void discardCard(Player player, Card card) {

       //player.removeCardFromHand(card); will implement this one too
        //  kartı alta eri koysun mu koymasın mı buna karar verelim opsiyonel
        deck.add(card);
        // Shuffle the deck
        Collections.shuffle(deck);
    }
    */
}
