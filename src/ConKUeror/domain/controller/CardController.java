package src.ConKUeror.domain.controller;
import java.util.List;
import java.util.ArrayList;
import src.ConKUeror.domain.model.Board.*;
public class CardController {
    private List<Card> deck;
    private Card activeCard;

    public CardController() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Populate the deck with cards, e.g. TerritoryCard, ArmyCard, and ChanceCard instances
    }

    public void drawCard() {
        // Draw a card from the deck and set it as the active card
    }

    public void playCard() {
        // Call the effect() method on the active card and update the game state accordingly
    }

    public void discardCard() {
        // Discard the active card and remove it from the player's hand
    }
}
