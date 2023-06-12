package ConKUeror.domain.controller;

import java.util.List;

import java.util.ArrayList;
import ConKUeror.domain.model.Board.*;
import ConKUeror.domain.model.Player.*;
import java.util.Collections;
import java.util.Random;

import javax.swing.event.ChangeEvent;

public class CardController {

    private List<ArmyCard> armyDeck;
    private List<TerritoryCard> terittoryDeck;

    private List<ChanceCard> chanceDeck;
    private TerritoryCard activeTerritoryCard;
    private ArmyCard activeArmyCard;
    private ChanceCard activeChanceCard;
    private static CardController instance;

    // after calling card controller we have to call initializeDeck !

    private CardController() {
        terittoryDeck = new ArrayList<>();
        armyDeck = new ArrayList<>();
        chanceDeck = new ArrayList<>();

    }

    public static CardController getInstance() {
        if (instance == null) {
            instance = new CardController();
        }
        return instance;
    }

    public void initializeDeck(List<Player> players, int numberOfTerritories) {
        // Add territory cards
        for (int i = 0; i < numberOfTerritories; i++) {
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

        chanceDeck.add(new ChanceCard("COUP", ChanceCard.ChanceType.COUP));
        chanceDeck.add(new ChanceCard("REVOLT", ChanceCard.ChanceType.REVOLT));
        chanceDeck.add(new ChanceCard("REBELLION", ChanceCard.ChanceType.REBELLION));
        chanceDeck.add(new ChanceCard("SECRET-WEAPON", ChanceCard.ChanceType.SECRETWEAPON));
        chanceDeck.add(new ChanceCard("DRAFT", ChanceCard.ChanceType.DRAFT));

        Collections.shuffle(armyDeck);
        Collections.shuffle(terittoryDeck);
        Collections.shuffle(chanceDeck);

    }

    public ChanceCard drawChanceCard(Player player) {

        if (!chanceDeck.isEmpty()) {
            activeChanceCard = chanceDeck.remove(0);
            Random random = new Random();
            int nextInt = random.nextInt(chanceDeck.size());

            activeChanceCard = chanceDeck.get(nextInt);

            // player.addCardToHand(activeCard); //will implement this method

            return activeChanceCard;
        } else {

            return null;
        }
    }

    public TerritoryCard drawTerritoryCard(Player player) {

        if (!terittoryDeck.isEmpty()) {
            activeTerritoryCard = terittoryDeck.remove(0);

            // player.addCardToHand(activeCard); //will implement this method

            return activeTerritoryCard;
        } else {

            return null;
        }
    }

    public ArmyCard drawArmyCard(Player player) {

        if (!armyDeck.isEmpty()) {
            activeArmyCard = armyDeck.remove(0);

            // player.addCardToHand(activeCard); //will implement this method

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
     * public void discardCard(Player player, Card card) {
     *
     * //player.removeCardFromHand(card); will implement this one too
     * // kartı alta eri koysun mu koymasın mı buna karar verelim opsiyonel
     * deck.add(card);
     * // Shuffle the deck
     * Collections.shuffle(deck);
     * }
     */
}